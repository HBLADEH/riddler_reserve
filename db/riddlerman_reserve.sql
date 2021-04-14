/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : riddlerman_reserve

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 14/04/2021 15:11:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rm_admin
-- ----------------------------
DROP TABLE IF EXISTS `rm_admin`;
CREATE TABLE `rm_admin`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名，唯一',
  `nickname` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `avatar` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像url',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_admin
-- ----------------------------
INSERT INTO `rm_admin` VALUES (1, 'blade', '泡椒', '$2a$10$8Z7gxMGNpKAb6436mmOkie02x0f2r0HG1v7S3BGQGG7hA/IiODNT6', NULL, '1012582116@qq.com', '2021-04-05 23:49:47.953', '2021-04-06 01:11:00.591');

-- ----------------------------
-- Table structure for rm_goods
-- ----------------------------
DROP TABLE IF EXISTS `rm_goods`;
CREATE TABLE `rm_goods`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `package_list` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '套餐, 使用 json 来存储 {name: \'名称\', price: \'价格\'}',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_goods
-- ----------------------------
INSERT INTO `rm_goods` VALUES (1, '商品666', '简介', '{\"name\": \"套餐1\", \"price\": \"99\"}', '2021-04-07 01:41:48.217', '2021-04-07 19:08:41.051');
INSERT INTO `rm_goods` VALUES (3, '商品1', '简介', '{\"name\": \"套餐1\", \"price\": \"99\"}', '2021-04-07 01:49:08.643', '2021-04-07 01:49:08.647');
INSERT INTO `rm_goods` VALUES (4, '商品12', '简介', '{\"name\": \"套餐1\", \"price\": \"99\"}', '2021-04-07 13:42:47.612', '2021-04-07 19:23:43.765');
INSERT INTO `rm_goods` VALUES (5, '商品3', '简介', '{\"name\": \"套餐1\", \"price\": \"99\"}', '2021-04-08 00:59:04.227', '2021-04-10 01:00:11.933');
INSERT INTO `rm_goods` VALUES (6, '商品4', '简介', '{\"name\": \"套餐1\", \"price\": \"99\"}', '2021-04-10 00:59:07.979', '2021-04-10 00:59:07.979');
INSERT INTO `rm_goods` VALUES (7, '商品5', '简介', '{\"name\": \"套餐1\", \"price\": \"99\"}', '2021-04-10 00:59:10.640', '2021-04-10 00:59:10.640');
INSERT INTO `rm_goods` VALUES (8, '商品6', '简介', '{\"name\": \"套餐1\", \"price\": \"99\"}', '2021-04-10 00:59:13.391', '2021-04-10 00:59:13.391');
INSERT INTO `rm_goods` VALUES (9, '商品7', '简介', '{\"name\": \"套餐1\", \"price\": \"99\"}', '2021-04-10 00:59:16.045', '2021-04-10 00:59:16.045');
INSERT INTO `rm_goods` VALUES (10, '商品8', '简介', '{\"name\": \"套餐1\", \"price\": \"99\"}', '2021-04-10 00:59:18.733', '2021-04-10 00:59:18.733');
INSERT INTO `rm_goods` VALUES (11, '商品9', '简介', '{\"name\": \"套餐1\", \"price\": \"99\"}', '2021-04-10 00:59:21.113', '2021-04-10 00:59:21.113');
INSERT INTO `rm_goods` VALUES (12, '商品10', '简介', '{\"name\": \"套餐1\", \"price\": \"99\"}', '2021-04-10 00:59:23.895', '2021-04-10 00:59:23.895');
INSERT INTO `rm_goods` VALUES (13, '商品11', '简介', '{\"name\": \"套餐1\", \"price\": \"99\"}', '2021-04-10 00:59:26.568', '2021-04-10 00:59:26.568');
INSERT INTO `rm_goods` VALUES (14, '商品13', '简介', '{\"name\": \"套餐1\", \"price\": \"99\"}', '2021-04-10 00:59:30.361', '2021-04-10 00:59:30.361');
INSERT INTO `rm_goods` VALUES (15, '商品14', '简介', '{\"name\": \"套餐1\", \"price\": \"99\"}', '2021-04-10 00:59:32.863', '2021-04-10 00:59:32.863');

-- ----------------------------
-- Table structure for rm_order
-- ----------------------------
DROP TABLE IF EXISTS `rm_order`;
CREATE TABLE `rm_order`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `order_round` int(11) NULL DEFAULT NULL COMMENT '预约场次 ID',
  `order_room` int(11) NULL DEFAULT NULL COMMENT '预约房间 ID',
  `order_time` datetime NULL DEFAULT NULL COMMENT '预约时间 ( YYYY-MM-dd )',
  `order_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '预约金额',
  `order_state` int(2) NULL DEFAULT NULL COMMENT '订单状态(0=未付款,1=已付款,2=已退款,3=已取消)',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '对应的下单用户 ID',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_order
-- ----------------------------

-- ----------------------------
-- Table structure for rm_role
-- ----------------------------
DROP TABLE IF EXISTS `rm_role`;
CREATE TABLE `rm_role`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `rolename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_role
-- ----------------------------
INSERT INTO `rm_role` VALUES (1, 'user');
INSERT INTO `rm_role` VALUES (2, 'admin');

-- ----------------------------
-- Table structure for rm_room
-- ----------------------------
DROP TABLE IF EXISTS `rm_room`;
CREATE TABLE `rm_room`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房间名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_room
-- ----------------------------
INSERT INTO `rm_room` VALUES (1, '房间1232');
INSERT INTO `rm_room` VALUES (4, '房间1');

-- ----------------------------
-- Table structure for rm_round
-- ----------------------------
DROP TABLE IF EXISTS `rm_round`;
CREATE TABLE `rm_round`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '场次名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_round
-- ----------------------------
INSERT INTO `rm_round` VALUES (1, '场次1232');
INSERT INTO `rm_round` VALUES (3, '场次1');

-- ----------------------------
-- Table structure for rm_user
-- ----------------------------
DROP TABLE IF EXISTS `rm_user`;
CREATE TABLE `rm_user`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名，唯一',
  `nickname` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `avatar` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像url',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_user
-- ----------------------------
INSERT INTO `rm_user` VALUES (1, 'pj', 'Blade', NULL, NULL, '2021-04-05 02:47:14.985', '2021-04-06 01:08:08.731', '123');

SET FOREIGN_KEY_CHECKS = 1;
