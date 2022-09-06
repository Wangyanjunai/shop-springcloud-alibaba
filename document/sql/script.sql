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

-- 创建t_idiom成语表，与Idiom实体类对应
create table if not exists `t_idiom` (
  `id` bigint(20) unsigned not null primary key comment '主键，数据id',
  `t_idiom_name` varchar(50) not null comment '成语名称',
  `t_search_keywords` varchar(16) not null comment '搜索关键字母，成语的每个字拼音首字母组合',
  `t_create_time` timestamp(0) not null default current_timestamp comment '创建时间',
  `t_update_time` timestamp(0) not null default current_timestamp on update current_timestamp(0) comment '更新时间',
  `t_reserve_column01` varchar(255) null default null comment '预留字段01',
  `t_reserve_column02` varchar(255) null default null comment '预留字段02',
  `t_reserve_column03` varchar(255) null default null comment '预留字段03',
  `t_reserve_column04` varchar(255) null default null comment '预留字段04'
) engine = innodb character set = utf8 collate = utf8_general_ci comment = '成语表' row_format = compact;

-- 创建t_idiom_item成语条目表，与IdiomItem实体类对应
create table if not exists `t_idiom_item` (
  `id` bigint(20) unsigned not null primary key comment '主键，数据id',
  `t_idiom_id` bigint(20) not null comment '成语id',
  `t_sort` tinyint(1) unsigned not null comment '排序',
  `t_idiom_words` tinytext not null comment '解说文字',
  `t_image_url` varchar(1024) not null comment '图片文件url',
  `t_audio_url` varchar(1024) not null comment '语音文件url',
  `t_lrc_url` varchar(1024) not null comment '歌词文件url',
  `t_create_time` timestamp(0) not null default current_timestamp comment '创建时间',
  `t_update_time` timestamp(0) not null default current_timestamp on update current_timestamp(0) comment '更新时间',
  `t_reserve_column01` varchar(255) null default null comment '预留字段01',
  `t_reserve_column02` varchar(255) null default null comment '预留字段02',
  `t_reserve_column03` varchar(255) null default null comment '预留字段03',
  `t_reserve_column04` varchar(255) null default null comment '预留字段04'
) engine = innodb character set = utf8 collate = utf8_general_ci comment = '成语条目表' row_format = compact;