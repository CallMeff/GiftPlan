-- 创建数据库
Create DATABASE seckill;
-- 使用数据库
USE seckill;
-- 创建秒杀表
CREATE TABLE seckill(
  seckill_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
  name VARCHAR(255) NOT NULL COMMENT '商品名称',
  number int NOT NULL  COMMENT '库存数量',
  start_time TIMESTAMP NOT NULL  COMMENT '秒杀开始时间',
  end_time DATETIME NOT NULL COMMENT '秒杀结束时间',
  create_time TIMESTAMP NOT NULL DEFAULT  current_timestamp COMMENT '创建时间',
  PRIMARY KEY (seckill_id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET = utf8 COMMENT = '秒杀库存表';
-- 初始化数据
insert into
  seckill(name,number,start_time,end_time)
values
  ('1000元秒杀iphone 6s',100,'2017-5-18 00:00:00','2017-6-18 00:00:00'),
  ('500元秒杀 ipad 4',200,'2017-5-18 00:00:00','2017-6-18 00:00:00'),
  ('300元秒杀 红米 6',400,'2017-5-18 00:00:00','2017-6-18 00:00:00'),
  ('10元秒杀 充电宝 ',1000,'2017-5-18 00:00:00','2017-6-18 00:00:00');
-- 秒杀成功明细表
-- 用户登陆认证相关的信息
create table success_killed(
  seckill_id BIGINT NOT NULL COMMENT '秒杀商品ID',
  user_phone BIGINT NOT NULL COMMENT '用户手机号',
  state TINYINT DEFAULT -1 COMMENT '状态标示 无效：-1 成功：0 已付款：1 ',
  create_time TIMESTAMP NOT NULL COMMENT '创建时间',
  PRIMARY KEY (seckill_id,user_phone),
  key idx_create_time(create_time)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '秒杀成功明细表';


-- 修改情况

-- Version 1.0

-- Version 1.1

