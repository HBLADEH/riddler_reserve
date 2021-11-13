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

 Date: 14/11/2021 01:45:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rm_admin
-- ----------------------------
DROP TABLE IF EXISTS `rm_admin`;
CREATE TABLE `rm_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名，唯一',
  `nickname` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `avatar` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像url',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_admin
-- ----------------------------
INSERT INTO `rm_admin` VALUES (1, 'blade', '泡椒', '$2a$10$8Z7gxMGNpKAb6436mmOkie02x0f2r0HG1v7S3BGQGG7hA/IiODNT6', NULL, '1012582116@qq.com', '2021-04-05 23:49:47.953', '2021-04-06 01:11:00.591');

-- ----------------------------
-- Table structure for rm_admin_permissions
-- ----------------------------
DROP TABLE IF EXISTS `rm_admin_permissions`;
CREATE TABLE `rm_admin_permissions`  (
  `admin_id` int(11) NOT NULL COMMENT '管理员ID',
  `permissions_id` int(11) NOT NULL COMMENT '权限ID',
  INDEX `rm_admin_permissions_ibfk_1`(`permissions_id`) USING BTREE,
  INDEX `admin_id`(`admin_id`) USING BTREE,
  CONSTRAINT `rm_admin_permissions_ibfk_1` FOREIGN KEY (`permissions_id`) REFERENCES `rm_permissions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rm_admin_permissions_ibfk_2` FOREIGN KEY (`admin_id`) REFERENCES `rm_admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_admin_permissions
-- ----------------------------
INSERT INTO `rm_admin_permissions` VALUES (1, 1);
INSERT INTO `rm_admin_permissions` VALUES (1, 2);
INSERT INTO `rm_admin_permissions` VALUES (1, 3);
INSERT INTO `rm_admin_permissions` VALUES (1, 4);
INSERT INTO `rm_admin_permissions` VALUES (1, 5);
INSERT INTO `rm_admin_permissions` VALUES (1, 6);
INSERT INTO `rm_admin_permissions` VALUES (1, 7);
INSERT INTO `rm_admin_permissions` VALUES (1, 8);
INSERT INTO `rm_admin_permissions` VALUES (1, 9);
INSERT INTO `rm_admin_permissions` VALUES (1, 10);
INSERT INTO `rm_admin_permissions` VALUES (1, 11);
INSERT INTO `rm_admin_permissions` VALUES (1, 12);
INSERT INTO `rm_admin_permissions` VALUES (1, 13);
INSERT INTO `rm_admin_permissions` VALUES (1, 14);

-- ----------------------------
-- Table structure for rm_goods
-- ----------------------------
DROP TABLE IF EXISTS `rm_goods`;
CREATE TABLE `rm_goods`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `cover_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `play_num` int(11) NOT NULL COMMENT '游玩人数',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '描述',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_goods
-- ----------------------------
INSERT INTO `rm_goods` VALUES (3, 'http://image.riddlerreserve.com:8887/static/goods/coverImage/1636291482330宿醉.jpg', 6, '宿醉', '简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介1111111111111111111111111111111111111111111', '2021-04-07 01:49:08.000', '2021-10-15 12:55:17.000');
INSERT INTO `rm_goods` VALUES (9, 'http://image.riddlerreserve.com:8887/static/goods/coverImage/1636291438306舍离2.jpg', 6, '舍离2断念', '简介', '2021-04-10 00:59:16.000', '2021-10-15 12:55:17.000');
INSERT INTO `rm_goods` VALUES (10, 'http://image.riddlerreserve.com:8887/static/goods/coverImage/1636291357584星火号.png', 5, '星火号', '简介', '2021-04-10 00:59:18.000', '2021-10-15 12:55:48.000');
INSERT INTO `rm_goods` VALUES (11, 'http://image.riddlerreserve.com:8887/static/goods/coverImage/1636291225274爱幼.jpg', 8, '爱幼妇产医院', '简介', '2021-04-10 00:59:21.000', '2021-10-15 12:55:17.000');
INSERT INTO `rm_goods` VALUES (18, 'http://image.riddlerreserve.com:8887/static/goods/coverImage/1636291088569校规.jpg', 7, '二十二条校规', '现在是深夜凌晨2：00，往日人声鼎沸的学校里此刻充满寂静，阴冷的月光照在一个个无人的教室中，给黑夜平添上了一分诡异感。教学楼一共有6层，此时5楼某个教室中，一个人影悄悄的打开了教室的门，然后小心翼翼的观察着周围的走廊，良久，这个人影似乎松了口气，轻轻的走出去并关上教室的门似是在极力避免发出声音，突然，“他”浑身一抖似乎感应到了什么一样，立刻朝着走廊的边狂奔，看到楼梯后“他”飞速向下跑，正想口气冲下一楼时“他”突然在楼梯口停了下来，接着头也不回的转身朝二楼跑去，似乎楼梯下面有什么非常恐怖的东西在等着“他”一样，终于“他”累了跑不动了，“他”在走廊尽头找到了一间教室便赶忙冲了进去想要躲躲，但是打开门的瞬间，“他”的脸色瞬间变得惨白，眼睛直勾勾的看着眼前难以置信的一幕，随后，死寂的校园中传出了一声凄厉的怡叫。', '2021-04-15 04:28:04.000', '2021-11-14 01:37:23.708');
INSERT INTO `rm_goods` VALUES (46, 'http://image.riddlerreserve.com:8887/static/goods/coverImage/1635673043048c7fac52864.jpg', 0, '666', '12', '2021-10-31 12:58:25.000', '2021-10-31 12:58:25.000');

-- ----------------------------
-- Table structure for rm_goods_package
-- ----------------------------
DROP TABLE IF EXISTS `rm_goods_package`;
CREATE TABLE `rm_goods_package`  (
  `goods_id` int(11) NOT NULL COMMENT '商品ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '套餐名称',
  `price` decimal(10, 2) NOT NULL COMMENT '价格',
  INDEX `rm_goods_package_ibfk_1`(`goods_id`) USING BTREE,
  CONSTRAINT `rm_goods_package_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `rm_goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_goods_package
-- ----------------------------
INSERT INTO `rm_goods_package` VALUES (18, '基本套餐', 55.00);

-- ----------------------------
-- Table structure for rm_order
-- ----------------------------
DROP TABLE IF EXISTS `rm_order`;
CREATE TABLE `rm_order`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单号',
  `order_group` int(11) NOT NULL COMMENT '组局 ID',
  `order_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '预约时间 ( YYYY-MM-dd )',
  `order_price` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '预约金额',
  `order_state` int(2) NOT NULL COMMENT '订单状态(0=未付款,1=已付款,2=已退款,3=已取消)',
  `user_id` int(11) NOT NULL COMMENT '对应的下单用户 ID',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_order
-- ----------------------------
INSERT INTO `rm_order` VALUES (1, '123123123124124124', 1, '2021-04-29 00:00:00.000', 11.00, 0, 1, '2021-04-29 23:41:26.474', '2021-11-13 20:23:42.757');
INSERT INTO `rm_order` VALUES (2, '123123123124124124', 1, '2021-05-30 00:00:01.000', 11.00, 0, 1, '2021-04-29 23:41:26.474', '2021-11-13 20:23:42.763');
INSERT INTO `rm_order` VALUES (3, '123123123124124124', 1, '2021-05-10 00:00:00.000', 11.00, 0, 1, '2021-04-29 23:41:26.474', '2021-11-13 20:23:42.779');
INSERT INTO `rm_order` VALUES (4, '123123123124124124', 1, '2021-05-30 00:00:00.000', 11.00, 0, 1, '2021-04-29 23:41:26.474', '2021-11-13 20:23:42.794');
INSERT INTO `rm_order` VALUES (5, '657060406648647680', 1, '2021-11-14 00:44:34.179', 55.67, 0, 1, '2021-11-14 00:44:34.179', '2021-11-14 00:44:34.179');
INSERT INTO `rm_order` VALUES (9, '657073706191040512', 1, '2021-11-14 01:37:25.038', 55.67, 0, 1, '2021-11-14 01:37:25.038', '2021-11-14 01:37:25.038');

-- ----------------------------
-- Table structure for rm_order_group
-- ----------------------------
DROP TABLE IF EXISTS `rm_order_group`;
CREATE TABLE `rm_order_group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `goods_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `round_id` int(11) NOT NULL,
  `package_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '套餐名称',
  `package_price` decimal(10, 2) NOT NULL COMMENT '套餐价格',
  `play_time` date NOT NULL COMMENT '预约时间',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_order_group
-- ----------------------------
INSERT INTO `rm_order_group` VALUES (1, 18, 1, 1, '套餐123', 55.67, '2021-10-11', '2021-10-18 23:21:58.000');
INSERT INTO `rm_order_group` VALUES (2, 3, 1, 2, '套餐1', 55.00, '2021-10-19', '2021-10-19 00:59:36.574');
INSERT INTO `rm_order_group` VALUES (5, 18, 2, 2, '基本套餐', 55.00, '2021-10-25', '2021-10-25 18:49:48.045');
INSERT INTO `rm_order_group` VALUES (8, 18, 8, 2, '套餐123', 55.67, '2021-10-11', '2021-10-27 00:13:59.211');
INSERT INTO `rm_order_group` VALUES (9, 18, 8, 4, '套餐123', 55.67, '2021-10-11', '2021-10-27 00:20:58.996');
INSERT INTO `rm_order_group` VALUES (10, 9, 2, 4, '套餐123', 55.67, '2021-10-11', '2021-10-27 00:21:20.320');

-- ----------------------------
-- Table structure for rm_permissions
-- ----------------------------
DROP TABLE IF EXISTS `rm_permissions`;
CREATE TABLE `rm_permissions`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_permissions
-- ----------------------------
INSERT INTO `rm_permissions` VALUES (1, '主控台', 'dashboard_console');
INSERT INTO `rm_permissions` VALUES (2, '商品列表', 'goods_list');
INSERT INTO `rm_permissions` VALUES (3, '商品列表添加', 'goods_add');
INSERT INTO `rm_permissions` VALUES (4, '商品列表修改', 'goods_edit');
INSERT INTO `rm_permissions` VALUES (5, '商列表删除', 'goods_delete');
INSERT INTO `rm_permissions` VALUES (6, '组局列表添加', 'order_group_add');
INSERT INTO `rm_permissions` VALUES (7, '组列表修改', 'order_group_edit');
INSERT INTO `rm_permissions` VALUES (8, '组列表删除', 'order_group_delete');
INSERT INTO `rm_permissions` VALUES (9, '房间列表添加', 'room_add');
INSERT INTO `rm_permissions` VALUES (10, '房间列表修改', 'room_edit');
INSERT INTO `rm_permissions` VALUES (11, '房间列表删除', 'room_delete');
INSERT INTO `rm_permissions` VALUES (12, '场次列表添加', 'round_add');
INSERT INTO `rm_permissions` VALUES (13, '场次列表修改', 'round_edit');
INSERT INTO `rm_permissions` VALUES (14, '场次列表删除', 'round_delete');

-- ----------------------------
-- Table structure for rm_resource
-- ----------------------------
DROP TABLE IF EXISTS `rm_resource`;
CREATE TABLE `rm_resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '地址',
  `target_type` int(11) NOT NULL COMMENT '类型',
  `target_id` int(11) NULL DEFAULT NULL COMMENT '类型对应ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_resource
-- ----------------------------
INSERT INTO `rm_resource` VALUES (29, '1635673043048c7fac52864.jpg', 1, 46);
INSERT INTO `rm_resource` VALUES (33, '1636291088569校规.jpg', 1, 18);
INSERT INTO `rm_resource` VALUES (34, '1636291225274爱幼.jpg', 1, 11);
INSERT INTO `rm_resource` VALUES (35, '1636291357584星火号.png', 1, 10);
INSERT INTO `rm_resource` VALUES (36, '1636291438306舍离2.jpg', 1, 9);
INSERT INTO `rm_resource` VALUES (37, '1636291482330宿醉.jpg', 1, 3);

-- ----------------------------
-- Table structure for rm_role
-- ----------------------------
DROP TABLE IF EXISTS `rm_role`;
CREATE TABLE `rm_role`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `rolename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_room
-- ----------------------------
INSERT INTO `rm_room` VALUES (1, '二楼');
INSERT INTO `rm_room` VALUES (2, '三楼');
INSERT INTO `rm_room` VALUES (8, '四楼');

-- ----------------------------
-- Table structure for rm_round
-- ----------------------------
DROP TABLE IF EXISTS `rm_round`;
CREATE TABLE `rm_round`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '场次名称',
  `start_time` time NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` time NULL DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_round
-- ----------------------------
INSERT INTO `rm_round` VALUES (1, '下午场', '14:00:00', '18:00:00');
INSERT INTO `rm_round` VALUES (2, '晚上场', '19:00:00', '22:00:00');
INSERT INTO `rm_round` VALUES (4, '深夜场', '00:00:00', '04:00:00');

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rm_user
-- ----------------------------
INSERT INTO `rm_user` VALUES (1, 'pj', 'Blade', NULL, NULL, '2021-04-05 02:47:14.985', '2021-11-13 20:05:50.302', '$2a$10$LsMMVt/JHg9mtBo4Em8R1OUCuuRpmkDZx8PCAZ6jn4gf3tbs3muEC');

-- ----------------------------
-- View structure for rm_order_group_player
-- ----------------------------
DROP VIEW IF EXISTS `rm_order_group_player`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `rm_order_group_player` AS select `og`.`id` AS `id`,`g`.`name` AS `goods_name`,`g`.`play_num` AS `play_num`,`rm`.`name` AS `room_name`,`rd`.`name` AS `round_name`,`og`.`package_name` AS `package_name`,`og`.`package_price` AS `package_price`,`og`.`play_time` AS `play_time`,`og`.`create_time` AS `create_time`,ifnull(`player`.`player_num`,0) AS `players` from ((((`rm_order_group` `og` left join (select `o`.`order_group` AS `order_group`,count(`o`.`order_group`) AS `player_num` from `rm_order` `o` group by `o`.`order_group`) `player` on((`player`.`order_group` = `og`.`id`))) join `rm_goods` `g`) join `rm_room` `rm`) join `rm_round` `rd`) where ((`og`.`goods_id` = `g`.`id`) and (`og`.`room_id` = `rm`.`id`) and (`og`.`round_id` = `rd`.`id`));

SET FOREIGN_KEY_CHECKS = 1;
