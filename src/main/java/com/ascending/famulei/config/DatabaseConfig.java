package com.ascending.famulei.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.ascending.famulei.repository")
public class DatabaseConfig {
    private final Logger logger = LoggerFactory.getLogger(getClass());
//    private String databaseUrl = "jdbc:postgresql://localhost:5431/famulei";
//    private String databaseUserName = "admin";
//    private String databasePassword = "password";
//    private String driverClassName = "org.postgresql.ds.PGSimpleDataSource";

    @Value("${database.serverName}")
    protected String databaseUrl; //databaseUrl:"jdbc:postgresql://localhost:5431/famulei_dev"

    @Value("${database.userName}")
    protected String databaseUserName; //databaseUserName:"admin"

    @Value("${database.password}")
    protected String databasePassword; //databasePassword:"password"

//    @Value("#{shareProperties['database.driverClassName']")
    @Value("#{shareProperties['database.driverClassName']}")
    protected String driverClassName; //driverClassName:"org.postgresql.ds.PGSimpleDataSource"



    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DataSource dataSource = createDataSource();
        return dataSource;
    }

    @Bean(name = "entityManagerFactory")
//    @Profile({"dev", "test", "stage", "prod"})
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(getDataSource());
        factoryBean.setPackagesToScan(new String[]{"com.ascending.famulei.domain", "com.ascending.famulei.repository"});
        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.spatial.dialect.postgis.PostgisDialect");
        props.put("hibernate.hbm2ddl.auto", "validate");
        props.put("hibernate.connection.charSet", "UTF-8");
        props.put("hibernate.show_sql", "true");
        factoryBean.setJpaProperties(props);

        return factoryBean;
    }

    @Bean(name="transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory, @Autowired DataSource dataSource){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        transactionManager.setDataSource(dataSource);
        return transactionManager;

    }



    private BasicDataSource createDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(databaseUserName);
        dataSource.setPassword(databasePassword);
//dataSource.setValidationQuery(databaseValidationQuery);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(1800000);
        dataSource.setNumTestsPerEvictionRun(3);
        dataSource.setMinEvictableIdleTimeMillis(1800000);
        return dataSource;
    }
}
