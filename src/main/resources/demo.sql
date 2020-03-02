/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 28/02/2020 00:10:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图书名称',
  `type_id` int(11) DEFAULT NULL COMMENT '分类id',
  `press_name` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '出版社名称',
  `author` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '作者',
  `synopsis` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '简介',
  `remark` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态:0借出,1在库',
  `create_time` datetime DEFAULT NULL COMMENT '入库时间',
  `update_time` datetime DEFAULT NULL COMMENT '最近更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for borrow_log
-- ----------------------------
DROP TABLE IF EXISTS `borrow_log`;
CREATE TABLE `borrow_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL COMMENT '图书id',
  `reader_id` int(11) NOT NULL COMMENT '读者id',
  `out_time` datetime DEFAULT NULL COMMENT '借出时间',
  `end_time` datetime DEFAULT NULL COMMENT '到期时间',
  `back_time` datetime DEFAULT NULL COMMENT '归还时间',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态:1借出,2归还,0异常',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for readers
-- ----------------------------
DROP TABLE IF EXISTS `readers`;
CREATE TABLE `readers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8mb4_general_ci NOT NULL COMMENT '读者名称',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `mob` bigint(11) DEFAULT NULL COMMENT '手机号码',
  `create_time` datetime DEFAULT NULL COMMENT '入会时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of readers
-- ----------------------------
BEGIN;
INSERT INTO `readers` VALUES (1, '孙悟空', NULL, 15866053630, '2020-02-27 23:47:55');
COMMIT;

-- ----------------------------
-- Table structure for types
-- ----------------------------
DROP TABLE IF EXISTS `types`;
CREATE TABLE `types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL COMMENT '父类id',
  `name` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分类名',
  `level` tinyint(1) DEFAULT NULL COMMENT '等级',
  `path` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES (1, 'admin', '123123', '717437709@qq.com', '山东济宁', '1996-10-14');
INSERT INTO `users` VALUES (3, 'sunran', '123456', NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
