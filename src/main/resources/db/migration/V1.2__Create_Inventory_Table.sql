CREATE SEQUENCE invt_id_seq;
create table Inventory (
    id bigint not null DEFAULT NEXTVAL('invt_id_seq'),
    primary key (id)
);
ALTER SEQUENCE invt_id_seq OWNED BY Inventory.id;