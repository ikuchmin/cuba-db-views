-- begin CUBADBVIEWS_ORDER
create table CUBADBVIEWS_ORDER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CUSTOMER_ID uuid,
    --
    primary key (ID)
)^
-- end CUBADBVIEWS_ORDER
-- begin CUBADBVIEWS_PRODUCT
create table CUBADBVIEWS_PRODUCT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end CUBADBVIEWS_PRODUCT
-- begin CUBADBVIEWS_CUSTOMER
create table CUBADBVIEWS_CUSTOMER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255),
    --
    primary key (ID)
)^
-- end CUBADBVIEWS_CUSTOMER
-- begin CUBADBVIEWS_ORDER_ITEM
create table CUBADBVIEWS_ORDER_ITEM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_ID uuid,
    PRODUCT_ID uuid,
    --
    primary key (ID)
)^
-- end CUBADBVIEWS_ORDER_ITEM
-- begin CUBADBVIEWS_ORDER_WITH_PRODUCTS
create or replace view CUBADBVIEWS_ORDER_WITH_PRODUCTS as
with products as (
    select coi.order_id,
           string_agg(p.name, ', ' order by p.name) as products,
           json_agg(p.id)                           as product_ids,
    from cubadbviews_product p
             join cubadbviews_order_item coi on p.ID = coi.product_id
    group by coi.order_id
)
select o.*,
       c.first_name || ' ' || c.LAST_NAME as customer,
       p.product_ids,
       p.products
from cubadbviews_order as o
         join cubadbviews_customer c on o.customer_id = c.id
         join products p on p.order_id = o.id^
-- end CUBADBVIEWS_ORDER_WITH_PRODUCTS