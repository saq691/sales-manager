create database `hmall_db` default character set utf8;
use `hmall_db`;

drop table if exists `tb_category`;
create table `tb_category`(
  `id` bigint(20) not null,
  `name` varchar(200) default null comment '名称',
  `sort_order` int(4) not null default '1' comment '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
  `create_time` datetime default null,
  `update_time` datetime default null,
  primary key (`id`)
)engine=InnoDB default charset=utf8 comment='分类表';

drop table if exists `tb_category_image`;
create table `tb_category_image`(
  `id` bigint(20) not null comment '图片ID',
  `c_id` varchar(5) not null comment '分类id',
  `name` varchar(200) default null comment '名称',
  `url` varchar(256) default null comment '网址或网页id',
  `status` int(1) not null default '1' comment '状态。可选值:1(正常),2(删除)',
  `image_path` varchar(256) default null comment '图片路径',
  `sort_order` int(4) not null default '1' comment '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
  `create_time` datetime default null,
  `update_time` datetime default null,
  primary key (`id`)
)engine=InnoDB default charset=utf8 comment='分类图片表';

drop table if exists `tb_category_secondary`;
create table `tb_category_secondary` (
  `id` bigint(20) not null comment '类目ID',
  `c_id` varchar(5) not null comment '分类id',
  `parent_id` bigint(20) default null comment '父类目ID=0时，代表的是一级的类目 ID=-1时表示是c_id上部分类',
  `name` varchar(200) default null comment '名称',
  `url` varchar(256) default null comment '网址或网页id',
  `status` int(1) default '1' comment '状态。可选值:1(正常),2(删除)',
  `sort_order` int(4) default '1' comment '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
  `is_parent` tinyint(1) default '1' comment '该类目是否为父类目，1为true，0为false',
  `create_time` datetime default null,
  `update_time` datetime default null,
  primary key (`id`),
  key `parent_id` (`parent_id`,`status`) using btree,
  key `sort_order` (`sort_order`),
  key `c_id` (`c_id`)
)engine=InnoDB default charset=utf8 comment='次级分类表';

drop table if exists `tb_index_ad`;
create table `tb_index_ad` (
  `id` bigint(20) not null comment 'ID',
  `alt` varchar(5) default null comment '提示',
  `url` varchar(500) default null comment '网址',
  `src_big` varchar(256) default null comment '大图片',
  `src_samll` varchar(256) default null comment '小图片',
  `status` int(1) default '1' comment '状态。可选值:1(正常),2(删除)',
  `sort_order` int(4) default '1' comment '排序',
  `create_time` datetime default null,
  `update_time` datetime default null,
  primary key (`id`)
)engine=InnoDB default charset=utf8 comment='首页轮播广告';

drop table if exists `tb_panel`;
create table `tb_panel` (
  `id` bigint(20) not null comment '类目ID',
  `name` varchar(50) default null comment '板块名称',
  `type` int(1) default null comment '类型 0轮播图 1板块种类一 2板块种类二 3板块种类三 ',
  `sort_order` int(4) default null comment '排列序号',
  `position` int(1) default null comment '所属位置。0首页 1商品推荐 2我要捐赠',
  `limit_num` int(4) default null comment '板块限制商品数量',
  `status` int(1) default '1' comment '状态',
  `remark` varchar(255) default null comment '备注',
  `create_time` datetime default null comment '创建时间',
  `update_time` datetime default null comment '更新时间',
  primary key (`id`),
  key `parent_id` (`status`) using btree,
  key `sort_order` (`sort_order`)
)engine=InnoDB default charset=utf8 comment='板块分类';

drop table if exists `tb_panel_content`;
create table `tb_panel_content` (
  `id` bigint(20) not null comment 'ID',
  `panel_id` int(11) not null comment '所属板块id',
  `type` int(1) default null comment '类型。0关联商品 1其他链接',
  `product_id` bigint(20) default null comment '关联商品id',
  `sort_order` int(4) default null comment '排序',
  `full_url` varchar(500) default null comment '其他链接',
  `pic_url` varchar(500) default null comment '图片地址',
  `create_time` datetime default null comment '创建时间',
  `update_time` datetime default null comment '更新时间',
  primary key (`id`)
)engine=InnoDB default charset=utf8 comment='板块分类内容表';


