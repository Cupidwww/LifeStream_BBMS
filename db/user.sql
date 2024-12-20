CREATE TABLE `user` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `username` VARCHAR(50) NOT NULL COMMENT '用户名',
    `password` VARCHAR(255) DEFAULT NULL COMMENT '密码',
    `role` VARCHAR(20) NOT NULL COMMENT '角色',
    `employee_number` VARCHAR(50) DEFAULT NULL COMMENT '员工编号',
    `name` VARCHAR(100) DEFAULT NULL COMMENT '姓名',
    `gender` VARCHAR(10) DEFAULT NULL COMMENT '性别',
    `age` INT(3) DEFAULT NULL COMMENT '年龄',
    `phone` VARCHAR(20) DEFAULT NULL COMMENT '手机号',
    `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
    `id_card` VARCHAR(20) DEFAULT NULL COMMENT '身份证号',
    `home_address` VARCHAR(255) DEFAULT NULL COMMENT '家庭住址',
    `avatar` VARCHAR(255) DEFAULT NULL COMMENT '头像',
    `addtime` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

INSERT INTO `user` (`id`, `username`, `password`, `role`, `employee_number`, `name`, `gender`, `age`, `phone`, `email`, `id_card`, `home_address`, `avatar`, `addtime`) VALUES (1, 'admin', 'admin', 'ADMIN', '1', 'admin', 'male', 18, '10086', 'admin@qq.com', '123456789', '123456789', '', '2024-12-05 16:32:03');
INSERT INTO `user` (`id`, `username`, `password`, `role`, `employee_number`, `name`, `gender`, `age`, `phone`, `email`, `id_card`, `home_address`, `avatar`, `addtime`) VALUES (12456, 'test2', '12456', 'DONOR', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `role`, `employee_number`, `name`, `gender`, `age`, `phone`, `email`, `id_card`, `home_address`, `avatar`, `addtime`) VALUES (123456, 'test', NULL, 'DONOR', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `role`, `employee_number`, `name`, `gender`, `age`, `phone`, `email`, `id_card`, `home_address`, `avatar`, `addtime`) VALUES (1213456, 'test3', NULL, 'DONOR', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `role`, `employee_number`, `name`, `gender`, `age`, `phone`, `email`, `id_card`, `home_address`, `avatar`, `addtime`) VALUES (1234561, 'test4', NULL, 'DONOR', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
