create table order (
  id integer not null
  , name character varying(255) not null
  , store_name character varying(255) not null
  , arrival_date date not null
  , order_num integer not null
  , constraint order_PKC primary key (id)
) ;

create table product (
  name character varying(255) not null
  , price integer
  , constraint product_PKC primary key (name)
) ;

create table store (
  store_name character varying(255) not null
  , category character varying(50)
  , constraint store_PKC primary key (store_name)
) ;

