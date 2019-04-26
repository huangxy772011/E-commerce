package com.ascending.famulei.repository;

import com.ascending.famulei.config.AppConfig;
import com.ascending.famulei.domain.Inventory;
import com.ascending.famulei.domain.Orders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class OrdersRepositoryTest {
    @Autowired
    private OrdersRepository ordersRepository;

    @Test
    @Transactional
    public void findOrdersByCustomerId() {
        Orders o = new Orders();
        o.setOrderName("silver case");
//        v.setLocation("Washington D.C.");
        ordersRepository.save(o);
        Optional<Orders> testOrders = ordersRepository.findById(o.getId());
        assertNotNull(testOrders);
        assertEquals(o.getId(), testOrders.get().getId());
    }
}