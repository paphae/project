/*
 Navicat MySQL Data Transfer

 Source Server         : mysql57_3307
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3307
 Source Schema         : tmall

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 10/04/2020 16:11:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, 'medicine');
INSERT INTO `category` VALUES (2, 'fresh');
INSERT INTO `category` VALUES (3, 'food');
INSERT INTO `category` VALUES (4, 'clothing');
INSERT INTO `category` VALUES (5, 'phone');
INSERT INTO `category` VALUES (6, 'department');

-- ----------------------------
-- Table structure for invite
-- ----------------------------
DROP TABLE IF EXISTS `invite`;
CREATE TABLE `invite`  (
  `code` int(255) NOT NULL AUTO_INCREMENT,
  `status` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2002 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of invite
-- ----------------------------
INSERT INTO `invite` VALUES (1001, 9);
INSERT INTO `invite` VALUES (1002, 8);
INSERT INTO `invite` VALUES (1003, 7);
INSERT INTO `invite` VALUES (1004, 6);
INSERT INTO `invite` VALUES (2001, 1);

-- ----------------------------
-- Table structure for order_
-- ----------------------------
DROP TABLE IF EXISTS `order_`;
CREATE TABLE `order_`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `oid` int(11) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  `receiver` varchar(222) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人信息',
  `mobile` varchar(222) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `createDate` timestamp(0) NULL DEFAULT NULL COMMENT '订单创建日期',
  `deliveryDate` timestamp(0) NULL DEFAULT NULL COMMENT '发货日期',
  `confirmDate` timestamp(0) NULL DEFAULT NULL COMMENT '确认收货日期',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态，待发货，已发货，待评价，完成',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_o_o`(`oid`) USING BTREE,
  CONSTRAINT `fk_o_o` FOREIGN KEY (`oid`) REFERENCES `orderitem` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_
-- ----------------------------
INSERT INTO `order_` VALUES (1, 1, 'Tangshan', 'zhangb', '13908603081', '2020-04-01 13:57:01', '2020-04-02 13:57:27', '2020-04-09 13:57:32', '待评价');
INSERT INTO `order_` VALUES (2, 2, 'Qinhuangdao', 'haunsgek', '15483265884', '2020-04-02 14:02:03', '2020-04-04 14:02:07', '2020-04-09 14:02:10', '待评价');
INSERT INTO `order_` VALUES (3, 3, 'Tianjin', 'fange', '13548732326', '2020-03-31 14:02:48', '2020-04-01 14:02:51', '2020-04-08 14:02:53', '待评价');
INSERT INTO `order_` VALUES (6, 6, 'mmm', 'hhhh', '2113325', '2020-04-10 14:45:01', NULL, NULL, '已发货');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT NULL COMMENT '购买数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_orderitem_user`(`uid`) USING BTREE,
  INDEX `fk_orderitem_product`(`pid`) USING BTREE,
  CONSTRAINT `fk_orderitem_product` FOREIGN KEY (`pid`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_orderitem_user` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES (1, 1, 2, 5);
INSERT INTO `orderitem` VALUES (2, 2, 2, 5);
INSERT INTO `orderitem` VALUES (3, 11, 2, 1);
INSERT INTO `orderitem` VALUES (4, 10, 2, 5);
INSERT INTO `orderitem` VALUES (5, 32, 2, 1);
INSERT INTO `orderitem` VALUES (6, 3, 2, 4);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orignalPrice` double NULL DEFAULT NULL COMMENT '原始价格',
  `promotePrice` double NULL DEFAULT NULL COMMENT '优惠价格',
  `stock` int(11) NULL DEFAULT NULL COMMENT '库存',
  `cid` int(11) NULL DEFAULT NULL,
  `createDate` timestamp(0) NULL DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_product_category`(`cid`) USING BTREE,
  CONSTRAINT `fk_product_category` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, 'cookies', 30, 10, 10, 3, '2020-04-08 18:47:49');
INSERT INTO `product` VALUES (2, 'The instant noodles', 5, 4, 100, 3, '2020-04-09 13:48:18');
INSERT INTO `product` VALUES (3, 'yogurt', 6, 4, 92, 3, '2020-04-09 13:48:40');
INSERT INTO `product` VALUES (10, 'Eye drops', 25, 15, 10, 1, '2020-04-09 13:44:42');
INSERT INTO `product` VALUES (11, 'rhinitis', 30, 25, 20, 1, '2020-04-09 13:45:21');
INSERT INTO `product` VALUES (12, 'diarrhea', 20, 18, 30, 1, '2020-04-09 13:45:51');
INSERT INTO `product` VALUES (21, 'apple', 10, 9, 30, 2, '2020-04-09 13:46:32');
INSERT INTO `product` VALUES (22, 'jackfruit', 25, 21, 50, 2, '2020-04-09 13:47:06');
INSERT INTO `product` VALUES (23, 'Kiwi fruit', 22, 21, 60, 2, '2020-04-09 13:47:37');
INSERT INTO `product` VALUES (31, 'dress', 99, 88, 10, 4, '2020-04-09 13:49:58');
INSERT INTO `product` VALUES (32, 'fleece', 109, 99, 20, 4, '2020-04-09 13:50:01');
INSERT INTO `product` VALUES (33, 'A pair of jeans', 129, 99, 20, 4, '2020-04-09 13:50:03');
INSERT INTO `product` VALUES (41, 'Huawei mobile phone', 3500, 3458, 50, 5, '2020-04-09 13:51:25');
INSERT INTO `product` VALUES (42, 'Oppo phone', 2500, 2299, 40, 5, '2020-04-09 13:51:27');
INSERT INTO `product` VALUES (43, 'Millet mobile phone', 2999, 1999, 50, 5, '2020-04-09 13:51:29');
INSERT INTO `product` VALUES (51, 'Water glass', 60, 50, 50, 6, '2020-04-09 13:53:04');
INSERT INTO `product` VALUES (52, 'The umbrella', 60, 40, 50, 6, '2020-04-09 13:53:06');
INSERT INTO `product` VALUES (53, 'Creative articles', 50, 45, 60, 6, '2020-04-09 13:53:09');

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `uid` int(11) NULL DEFAULT NULL,
  `oid` int(11) NULL DEFAULT NULL,
  `createDate` timestamp(0) NULL DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_review_user`(`uid`) USING BTREE,
  INDEX `fk_o_r`(`oid`) USING BTREE,
  CONSTRAINT `fk_o_r` FOREIGN KEY (`oid`) REFERENCES `order_` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_review_user` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES (1, 'good', 2, 1, '2020-04-09 17:45:42');
INSERT INTO `review` VALUES (2, 'bad', 2, 2, '2020-04-09 17:45:45');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(2) NOT NULL COMMENT '会员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhangbo', 'zhangbo', 'lh0812', 1);
INSERT INTO `user` VALUES (2, 'lsi', 'lisi', '123456', 10);
INSERT INTO `user` VALUES (5, 'lala', 'shhs', '123456', 10);

SET FOREIGN_KEY_CHECKS = 1;
