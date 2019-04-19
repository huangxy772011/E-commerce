CREATE SEQUENCE customer_id_seq;
create table Customer (
    id bigint not null DEFAULT NEXTVAL('customer_id_seq'),
    primary key (id)
);
ALTER SEQUENCE customer_id_seq OWNED BY Customer.id;