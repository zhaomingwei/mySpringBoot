create table user(
	id varchar(36) not null comment '用户id',
	username varchar(45) null comment '用户名',
  passwd varchar(36) null comment '用户密码',
	age int(3) not null default 0 comment '用户年龄'
)