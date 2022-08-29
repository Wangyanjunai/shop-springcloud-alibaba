select * from `t_user`;
select * from `t_product`;
select * from `t_order`;
select * from `t_order_item`;

select count(1) from `t_user`;
select count(1) from `t_product`;
select count(1) from `t_order`;
select count(1) from `t_order_item`;

show columns from `t_user`;
show columns from `t_product`;
show columns from `t_order`;
show columns from `t_order_item`;

truncate table `t_order`;
truncate table `t_order_item`;

update `t_product` set `t_pro_stock` = 10000 where `id` = 1003;


