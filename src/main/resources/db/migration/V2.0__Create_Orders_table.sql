CREATE SEQUENCE orders_id_seq;
CREATE TABLE orders (
    id bigint not null DEFAULT NEXTVAL('orders_id_seq'),
    order_name varchar(255) not NULL,
    time_ordered varchar(255) not NULL,
    amount bigint DEFAULT NULL,
    customer_id bigint not null,
    primary key (id),
    CONSTRAINT fk_orders_customer
      FOREIGN KEY (customer_id)
      REFERENCES customer (id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);
ALTER SEQUENCE orders_id_seq OWNED BY orders.id;