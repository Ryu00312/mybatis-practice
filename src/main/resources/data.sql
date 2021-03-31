insert into public."order"(id,name,store_name,arrival_date,order_num) values (1,'カーディガン','大崎A','2021/03/01',10);
insert into public."order"(id,name,store_name,arrival_date,order_num) values (2,'Yシャツ','大崎B','2021/03/01',10);
insert into public."order"(id,name,store_name,arrival_date,order_num) values (3,'カーディガン','品川A','2021/03/30',20);
insert into public."order"(id,name,store_name,arrival_date,order_num) values (4,'スーツ','品川B','2021/03/01',10);
insert into public."order"(id,name,store_name,arrival_date,order_num) values (5,'パンツ','品川C','2021/03/30',10);

insert into public.store(store_name,category) values ('大崎A','EC');
insert into public.store(store_name,category) values ('大崎B','大型');
insert into public.store(store_name,category) values ('品川A','超大型
');
insert into public.store(store_name,category) values ('品川B','大型');
insert into public.store(store_name,category) values ('品川C','小型');


insert into public.product(name,price) values ('Yシャツ',5500);
insert into public.product(name,price) values ('カーディガン',3000);
insert into public.product(name,price) values ('スーツ',10000);
insert into public.product(name,price) values ('パンツ',1000);
