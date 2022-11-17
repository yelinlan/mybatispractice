/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : school

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 17/11/2022 23:28:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '学号',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '匿名' COMMENT '姓名',
  `pwd` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '123456' COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'a2', 'b2');
INSERT INTO `user` VALUES (3, 'a3', 'b3');
INSERT INTO `user` VALUES (4, 'yll', 'yll');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '学号',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '匿名' COMMENT '姓名',
  `pwd` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '123456' COMMENT '密码',
  `sex` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '女' COMMENT '性别',
  `birthday` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出生日期',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `money` int(0) NULL DEFAULT NULL,
  `tid` int(0) NULL DEFAULT NULL COMMENT 'teacher外键',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uniquename`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '小明', '123456', 'male', NULL, NULL, NULL, NULL, 1);
INSERT INTO `student` VALUES (2, '小雨', '123456', 'male', NULL, NULL, NULL, NULL, 1);
INSERT INTO `student` VALUES (3, '小三', '123456', 'male', NULL, NULL, NULL, NULL, 1);
INSERT INTO `student` VALUES (4, '笑著', '123456', 'male', NULL, NULL, NULL, NULL, 2);
INSERT INTO `student` VALUES (5, '小凱', '123456', 'male', NULL, NULL, NULL, NULL, 2);
INSERT INTO `student` VALUES (6, '小李', '123456', 'male', NULL, NULL, NULL, NULL, 2);
INSERT INTO `student` VALUES (7, '小品', '123456', 'male', NULL, NULL, NULL, NULL, 3);
INSERT INTO `student` VALUES (8, '小任', '123456', 'male', NULL, NULL, NULL, NULL, 3);
INSERT INTO `student` VALUES (9, '小米', '123456', 'male', NULL, NULL, NULL, NULL, 3);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '张老师');
INSERT INTO `teacher` VALUES (2, '李老师');
INSERT INTO `teacher` VALUES (3, '王老师');

SET FOREIGN_KEY_CHECKS = 1;
