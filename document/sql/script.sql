-- 创建用户
create user 'shop'@'%' identified by 'XueGod!@#123';
-- 创建数据库
create database if not exists shop default character set utf8 default collate utf8_general_ci;
-- 授权mysql5.7
grant all on shop.* to 'shop'@'%' identified by 'XueGod!@#123';
-- 授权mysql8.1
grant all privileges on shop.* to 'shop'@'%' with grant option;
alter user 'shop'@'%' identified with mysql_native_password by 'XueGod!@#123'; #修改加密规则
alter user 'shop'@'%' identified by 'XueGod!@#123' password expire never; #更新一下用户的密码且不过期
-- 刷新权限
flush privileges;

-- 创建t_user用户表，与User实体类对应
create table if not exists `t_user` (
    `id` bigint(20) unsigned not null primary key comment '主键，数据id',
    `t_username` varchar(50) null default null comment '用户名',
    `t_password` varchar(64) null default null comment '密码',
    `t_phone` varchar(20) null default null comment '手机号',
    `t_address` varchar(255) null default null comment '地址'
) engine = innodb character set = utf8 collate = utf8_general_ci comment = '用户表' row_format = compact;

-- 创建t_product商品表，与Product实体类对应
create table if not exists `t_product` (
    `id` bigint(20) unsigned not null primary key comment '主键，数据id',
    `t_pro_name` varchar(50) null default null comment '商品名称',
    `t_pro_price` decimal(10, 2) null default null comment '商品价格',
    `t_pro_stock` int(11) null default null comment '商品库存'
) engine = innodb character set = utf8 collate = utf8_general_ci comment = '商品表' row_format = compact;

-- 创建t_order订单表，与Order实体类对应
create table if not exists `t_order` (
    `id` bigint(20) unsigned not null primary key comment '主键，数据id',
    `t_user_id` bigint(20) not null comment '用户id',
    `t_user_name` varchar(50) null default null comment '用户名',
    `t_phone` varchar(20) null default null comment '手机号',
    `t_address` varchar(255) null default null comment '地址',
    `t_total_price` decimal(10, 2) null default null comment '商品价格（总价）'
) engine = innodb character set = utf8 collate = utf8_general_ci comment = '订单表' row_format = compact;

-- 创建t_order_item订单条目表，与OrderItem实体类对应
create table if not exists `t_order_item` (
    `id` bigint(20) unsigned not null primary key comment '主键，数据id',
    `t_order_id` bigint(20) not null comment '订单id',
    `t_pro_id` bigint(20) null default null comment '商品id',
    `t_pro_name` varchar(50) null default null comment '商品名称',
    `t_pro_price` decimal(10, 2) null default null comment '商品价格（单价）',
    `t_number` int(11) null default null comment '购买数量'
) engine = innodb character set = utf8 collate = utf8_general_ci comment = '订单条目表' row_format = compact;



