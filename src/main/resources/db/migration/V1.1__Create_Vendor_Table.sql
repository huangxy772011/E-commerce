CREATE SEQUENCE vendor_id_seq;
create table Vendor (
    id bigint not null DEFAULT NEXTVAL('vendor_id_seq'),
    primary key (id)
);
ALTER SEQUENCE vendor_id_seq OWNED BY Vendor.id;