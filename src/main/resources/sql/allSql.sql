CREATE TABLE `user` (
  `id` varchar(36) NOT NULL COMMENT '用户id',
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `passwd` varchar(36) DEFAULT NULL COMMENT '用户密码',
  `age` int(3) NOT NULL DEFAULT '0' COMMENT '用户年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;