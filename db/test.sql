/*
 Navicat Premium Dump SQL

 Source Server         : admin
 Source Server Type    : MySQL
 Source Server Version : 80040 (8.0.40)
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80040 (8.0.40)
 File Encoding         : 65001

 Date: 10/12/2024 22:57:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blood_bank_management
-- ----------------------------
DROP TABLE IF EXISTS `blood_bank_management`;
CREATE TABLE `blood_bank_management`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bloodCategory` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bloodVolume` float NULL DEFAULT NULL,
  `transactionDate` datetime NULL DEFAULT NULL,
  `expirationDate` datetime NULL DEFAULT NULL,
  `bloodDonationID` bigint NULL DEFAULT NULL,
  `remarks` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `addtime` datetime NULL DEFAULT NULL,
  `bloodType` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_blood_donation_id`(`bloodDonationID` ASC) USING BTREE,
  CONSTRAINT `fk_blood_donation_id` FOREIGN KEY (`bloodDonationID`) REFERENCES `blood_donation` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blood_bank_management
-- ----------------------------
INSERT INTO `blood_bank_management` VALUES (1, 'Whole Blood', 100, '2024-12-05 21:24:07', '2024-12-05 23:24:10', 1, 'Regular donor', '2024-12-05 21:26:05', 'A+');
INSERT INTO `blood_bank_management` VALUES (2, 'Shit Blood', 300, '2024-12-05 21:40:36', '2024-12-05 21:40:39', 1, 'Regular donor', '2024-12-05 21:40:57', 'A-');
INSERT INTO `blood_bank_management` VALUES (21, NULL, 500, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for blood_donation
-- ----------------------------
DROP TABLE IF EXISTS `blood_donation`;
CREATE TABLE `blood_donation`  (
  `id` bigint NOT NULL,
  `bloodType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bloodCategory` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bloodBagNumber` int NULL DEFAULT NULL,
  `bloodVolume` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isQualified` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `registrationDate` datetime NULL DEFAULT NULL,
  `donorID` bigint NULL DEFAULT NULL,
  `staffID` bigint NULL DEFAULT NULL,
  `healthID` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_health_id`(`healthID` ASC) USING BTREE,
  INDEX `fk_donor_id`(`donorID` ASC) USING BTREE,
  INDEX `fk_staff_id`(`staffID` ASC) USING BTREE,
  CONSTRAINT `fk_health_id` FOREIGN KEY (`healthID`) REFERENCES `health_management` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_donor_id` FOREIGN KEY (`donorID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_staff_id` FOREIGN KEY (`staffID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blood_donation
-- ----------------------------
INSERT INTO `blood_donation` VALUES (1, '1', '1', 1, '1', '1', '2024-12-06 18:07:59', 114514, 1733495135371, NULL);
INSERT INTO `blood_donation` VALUES (2, '2', '2', 2, '2', '2', '2024-12-03 18:08:12', 114514, 1733495135371, NULL);

-- ----------------------------
-- Table structure for health_management
-- ----------------------------
DROP TABLE IF EXISTS `health_management`;
CREATE TABLE `health_management`  (
  `id` bigint NOT NULL,
  `donorID` bigint NULL DEFAULT NULL,
  `staffID` bigint NULL DEFAULT NULL,
  `gender` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `weight` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `height` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `physicalExamTime` date NULL DEFAULT NULL,
  `physicalExamResult` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `testTubeNumber` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bloodType` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `hepatitisB` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `hiv` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `syphilis` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `testResult` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `testTime` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `donor_id`(`donorID` ASC) USING BTREE,
  INDEX `staff_id`(`staffID` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of health_management
-- ----------------------------
INSERT INTO `health_management` VALUES (1, 123456, 1, 'male', '60', '180', '2024-12-05', 'good', '1', 'A+', 'no', 'no', 'no', 'ok', '2024-12-06');

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint NOT NULL COMMENT '用户id',
  `username` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `tablename` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '表名',
  `role` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色',
  `token` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `addtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'token表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (1, 1, 'admin', 'user', '管理员', 'sviax4penfjle45qzbjyjvj4iohbd20z', '2024-12-06 22:04:57', '2099-12-06 22:04:57');
INSERT INTO `token` VALUES (2, 21, '献血编号1', 'xianxuerenyuan', '献血人员', 'ucgay0h8fy8i2fqsl0gcoeu4m5dkme0m', '2023-03-17 10:48:58', '2023-03-17 11:48:58');
INSERT INTO `token` VALUES (3, 11, '工号1', 'gongzuorenyuan', '工作人员', 'o840vdutur9br2giv7pdx4dbr52alhp9', '2023-03-17 10:49:20', '2023-03-17 11:49:20');
INSERT INTO `token` VALUES (4, 1679021649777, '111', 'xianxuerenyuan', '献血人员', 'hkbg3ajz5yvrnr1gbkebrcq5lb9i9xg5', '2023-03-17 10:54:13', '2023-03-17 11:58:40');
INSERT INTO `token` VALUES (5, 1679021723066, '222', 'gongzuorenyuan', '工作人员', 'ouzwpn2jsqx9z7kew9db11j4ldgvo252', '2023-03-17 10:55:26', '2023-03-17 11:55:27');
INSERT INTO `token` VALUES (6, 12456, 'test2', 'users', '献血人员', 'tosk6aihxf19ztzj8zne8hpjrxn1xn0w', '2024-12-06 18:27:34', '2099-12-06 18:27:34');
INSERT INTO `token` VALUES (7, 114514, 'new', 'users', '献血人员', 'p64foh9tiakwyigbsoed3u84yjb5kzvj', '2024-12-06 22:15:35', '2099-12-06 22:15:35');
INSERT INTO `token` VALUES (8, 12456, 'test2', 'users', 'DONOR', 'zz18u9asy2ecmfknrdojogahpizup33g', '2024-12-06 23:25:52', '2099-12-06 23:25:52');
INSERT INTO `token` VALUES (9, 1, 'admin', 'users', 'ADMIN', 'rk3qhkjdt5sy3ueik5yk3le79escaonq', '2024-12-06 23:50:05', '2099-12-06 23:50:05');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL,
  `username` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `employee_number` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gender` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `phone` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `id_card` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `home_address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `avatar` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `addtime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', 'ADMIN', '1', 'admin', 'male', 18, '10086', 'admin@qq.com', '123456789', '123456789', '', '2024-12-05 16:32:03');
INSERT INTO `user` VALUES (12456, 'test2', '12456', 'DONOR', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (114514, 'test6', '123456', 'DONOR', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (123456, 'test', NULL, 'DONOR', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (1213456, 'test3', NULL, 'DONOR', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (1234561, 'test4', NULL, 'DONOR', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (987654321, 'test5', NULL, 'DONOR', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (1733495135371, 'ilovegirl', NULL, 'EMPLOYEE', NULL, NULL, 'lesbian', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (1733495147590, 'ilove', NULL, NULL, NULL, NULL, 'lesbian', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (1733839060081, 'testid', 'ididid', 'DONOR', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
