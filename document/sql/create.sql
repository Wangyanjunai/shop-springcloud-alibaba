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