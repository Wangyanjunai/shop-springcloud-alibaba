-- 创建用户
create user 'seata'@'%' identified by 'XueGod!@#123';
-- 创建数据库
create database if not exists seata default character set utf8 default collate utf8_general_ci;
-- 授权mysql5.7
grant all on seata.* to 'seata'@'%' identified by 'XueGod!@#123';
-- 刷新权限
flush privileges;