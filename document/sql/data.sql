-- 插入用户表数据
insert into `shop`.`t_user`(`id`, `t_username`, `t_password`, `t_phone`, `t_address`) values (1001, 'binghe', 'c26be8aaf53b15054896983b43eb6a65', '13212345678', '北京');

-- 插入商品表数据
insert into `shop`.`t_product`(`id`, `t_pro_name`, `t_pro_price`, `t_pro_stock`) values (1001, '华为', 2399.00, 100), (1002, '小米', 1999.00, 100), (1003, 'iphone', 4999.00, 100);