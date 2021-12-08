/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : management

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 06/12/2021 14:38:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `custid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `custlogin` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '客户登录账号',
  `custpass` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '客户密码',
  `custname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '客户姓名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '客户电话',
  `custsex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '客户性别',
  PRIMARY KEY (`custid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (4, 'lx', 'admin123', '顾倾歌', '13750556677', '男');
INSERT INTO `customer` VALUES (5, 'wr', 'admin123', '温柔', '15618464656', '女');
INSERT INTO `customer` VALUES (6, '222', '123456', 'hiuh', '14687484336', '女');
INSERT INTO `customer` VALUES (7, '8848', '123456', '冰镩', '18662346466', '女');

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good`  (
  `commid` int(50) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '序号',
  `commname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '名称',
  `commoney` double(255, 2) NULL DEFAULT NULL COMMENT '前台销售价格',
  `commdesc` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品描述',
  `providerid` int(255) NULL DEFAULT NULL COMMENT '供应商编号',
  `commbering` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品编号',
  `size` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品规格',
  `inventory` int(255) UNSIGNED NULL DEFAULT NULL COMMENT '库存',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图片路径',
  PRIMARY KEY (`commid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES (3, '土豆', 5.00, '入口即化', 1, 'aDb62VnH', '500g', 2, '/upload/20211001172455第1页第20张.jpg');
INSERT INTO `good` VALUES (4, '玉米', 3.00, '又香又甜', 1, 'OnYnj4qf', '500g', 21, '/upload/20211001172504第1页第16张.jpg');
INSERT INTO `good` VALUES (5, '胡萝卜', 3.00, '清脆可口', 2, '1Q6sybk7', '500g', 256, '/upload/20211001211056第1页第21张.jpg');
INSERT INTO `good` VALUES (8, '山药', 10.00, '口感软糯', 2, 'TuBd8u6W', '500g', 230, '/upload/20211001215059第1页第2张.jpg');
INSERT INTO `good` VALUES (9, '莲花子', 8.00, '清甜香脆', 3, 'fSPVU1ur', '500g', 75, '/upload/20211001211928第1页第28张.jpg');
INSERT INTO `good` VALUES (14, '鸭子', 20.00, '齿颊留香', 3, 'wfb2xrIN', '500g', 3, '/upload/20211001214941第2页第21张.jpg');
INSERT INTO `good` VALUES (15, '雪梨', 12.00, '香甜可口', 2, '0oqLl3e8', '500g', 95, '/upload/20211006172204第1页第7张.jpg');
INSERT INTO `good` VALUES (17, '花生', 8.00, '五谷杂粮红皮生 四粒红花生 粗粮粥米豆浆原料', 3, 'YzyXzpsl', '500g', 270, '/upload/20211015001439第4页第27张.jpg');
INSERT INTO `good` VALUES (18, '苹果', 3.00, '烟台红富士苹果 一级铂金大果 单果220g以上 生鲜 新鲜水果 健康轻食', 1, '9jXUv2fA', '500g', 496, '/upload/20211021215607第2页第3张.jpg');
INSERT INTO `good` VALUES (19, '苹果蕉', 8.00, '广西小米蕉自然熟糯米蕉香蕉新鲜5斤当季水果大芭蕉皇帝蕉新鲜水果', 1, 'Bc6wP2zY', '500g', 17, '/upload/20211021231845pingguojiao.jpg');
INSERT INTO `good` VALUES (20, '排骨', 30.00, '密之蓝天猪排骨4斤装新鲜猪小排猪肋排小排骨精排骨生鲜肉类生鲜', 2, 'inRiMH5V', '500g', 0, '/upload/202110220205264945f703fbcc8895.jpg');
INSERT INTO `good` VALUES (21, '兔肉', 40.00, '新鲜现杀兔肉1只装2.5斤左右1250g白条兔肉去皮去内脏整只兔肉冷吃兔', 2, 'MBh3HN4V', '500g', 0, '/upload/20211022031621f0bbca622802bdd8.jpg');
INSERT INTO `good` VALUES (22, '洋葱', 9.00, '云南农家紫皮洋葱 新鲜洋葱头蔬菜红皮', 3, 'aueft15j', '500g', 0, '/upload/2021102222595180b4a32ab411c330.jpg');
INSERT INTO `good` VALUES (23, '枇杷', 15.00, '【现货】云南蒙自枇杷新鲜枇杷果 新鲜水果', 1, 'hfFQeWdY', '500g', 0, '/upload/20211022230051cb1e55af6d4f6c1f.jpg');
INSERT INTO `good` VALUES (24, '牛腿肉', 45.00, '绿之邦 原切牛腿肉 新鲜冷冻进口黄牛肉', 2, 'LXDnfEe1', '500g', 0, '/upload/2021102223013497b45b1dd401b92a.jpg');
INSERT INTO `good` VALUES (25, '南瓜', 10.00, '惠和一号贝贝南瓜正宗板栗味小南瓜日本种源真贝贝南瓜粉糯香甜宝宝辅食健康粗粮 ', 1, 'TMvzumAd', '500g', 200, '/upload/20211024153747第1页第1张.jpg');
INSERT INTO `good` VALUES (26, '西瓜', 10.00, '冰糖麒麟早佳西瓜农田阳台盆栽高产四季蔬果早熟脆甜', 2, 'sTCYqbpB', '500', 84, '/upload/20211121141405pic.jpg');

-- ----------------------------
-- Table structure for provider
-- ----------------------------
DROP TABLE IF EXISTS `provider`;
CREATE TABLE `provider`  (
  `providerid` int(50) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '供应商id',
  `pvename` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '供应商名称',
  `pvephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '供应商电话',
  `pveaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '供应商地址',
  PRIMARY KEY (`providerid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of provider
-- ----------------------------
INSERT INTO `provider` VALUES (1, '宏辉果蔬', '13750556677', '上海');
INSERT INTO `provider` VALUES (2, '傲农生物', '18559984863', '广东');
INSERT INTO `provider` VALUES (3, '敦煌种业', '17523596656', '宁夏');

-- ----------------------------
-- Table structure for refund
-- ----------------------------
DROP TABLE IF EXISTS `refund`;
CREATE TABLE `refund`  (
  `id` int(50) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '退货id',
  `commid` int(50) NULL DEFAULT NULL COMMENT '商品id',
  `rfmoney` double(255, 2) NULL DEFAULT NULL COMMENT '退货价格',
  `rfnumber` int(50) NULL DEFAULT NULL COMMENT '退货数量',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '退货备注',
  `reftime` datetime(0) NULL DEFAULT NULL COMMENT '退货时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of refund
-- ----------------------------
INSERT INTO `refund` VALUES (1, 3, 200.00, 20, 'ww', '2021-09-17 19:02:48');
INSERT INTO `refund` VALUES (2, 14, 60.00, 2, '涨价了', '2021-10-11 21:35:09');
INSERT INTO `refund` VALUES (3, 3, 2400.00, 80, NULL, '2021-10-13 00:26:57');
INSERT INTO `refund` VALUES (4, 3, 2400.00, 80, '22', '2021-10-15 21:55:56');

-- ----------------------------
-- Table structure for rtsale
-- ----------------------------
DROP TABLE IF EXISTS `rtsale`;
CREATE TABLE `rtsale`  (
  `id` int(60) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '销售退货id',
  `commid` int(60) NULL DEFAULT NULL COMMENT '销售退货商品',
  `rtsnumber` int(255) NULL DEFAULT NULL COMMENT '销售退货数量',
  `rtsmoney` int(255) NULL DEFAULT NULL COMMENT '销售退货总价',
  `rtsmark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '销售退货备注',
  `rtstime` datetime(0) NULL DEFAULT NULL COMMENT '销售退货时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rtsale
-- ----------------------------
INSERT INTO `rtsale` VALUES (1, 3, 20, 600, '', '2021-10-12 22:39:39');
INSERT INTO `rtsale` VALUES (2, 5, 25, 150, '贵了', '2021-09-17 20:17:23');

-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale`  (
  `id` int(50) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '销售id',
  `custid` int(255) NULL DEFAULT NULL COMMENT '客户id',
  `commid` int(255) NULL DEFAULT NULL COMMENT '商品id',
  `salemount` int(255) NULL DEFAULT NULL COMMENT '销售数量',
  `salemoney` int(255) NULL DEFAULT NULL COMMENT '销售金额',
  `allmoney` double(255, 2) NULL DEFAULT NULL COMMENT '销售总额',
  `saletime` datetime(0) NULL DEFAULT NULL COMMENT '销售时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale
-- ----------------------------
INSERT INTO `sale` VALUES (1, 4, 3, 30, 30, 900.00, '2021-10-12 19:53:37');
INSERT INTO `sale` VALUES (2, 5, 14, 10, 20, 3000.00, '2021-10-12 21:43:51');
INSERT INTO `sale` VALUES (28, 4, 3, 1, 5, 5.00, '2021-10-15 21:00:26');
INSERT INTO `sale` VALUES (29, 4, 3, 1, 5, 5.00, '2021-10-15 21:06:51');
INSERT INTO `sale` VALUES (30, 5, 3, 1, 5, 5.00, '2021-10-15 21:11:09');
INSERT INTO `sale` VALUES (31, 5, 3, 7, 5, 35.00, '2021-10-15 21:23:12');
INSERT INTO `sale` VALUES (32, 5, 3, 4, 5, 20.00, '2021-10-15 21:27:41');
INSERT INTO `sale` VALUES (33, 6, 3, 10, 20, 200.00, '2021-10-15 21:30:08');
INSERT INTO `sale` VALUES (34, 4, 3, 10, 10, 100.00, '2021-10-16 17:45:48');
INSERT INTO `sale` VALUES (35, 4, 3, 1, 5, 5.00, '2021-10-17 00:10:43');
INSERT INTO `sale` VALUES (36, 5, 17, 30, 5, 150.00, '2021-10-18 14:38:28');
INSERT INTO `sale` VALUES (37, 5, 9, 30, 7, 210.00, '2021-10-18 14:39:04');
INSERT INTO `sale` VALUES (38, 6, 8, 40, 8, 320.00, '2021-10-18 14:39:29');
INSERT INTO `sale` VALUES (39, 4, 15, 50, 6, 300.00, '2021-10-18 14:39:54');
INSERT INTO `sale` VALUES (40, 6, 3, 100, 3, 300.00, '2021-10-18 19:41:08');
INSERT INTO `sale` VALUES (41, 7, 5, 30, 5, 150.00, '2021-09-07 20:16:51');
INSERT INTO `sale` VALUES (42, 6, 5, 25, 6, 150.00, '2021-09-09 20:17:02');
INSERT INTO `sale` VALUES (43, 4, 9, 45, 8, 360.00, '2021-09-17 20:17:43');
INSERT INTO `sale` VALUES (44, 5, 15, 55, 7, 385.00, '2021-09-15 20:17:55');
INSERT INTO `sale` VALUES (45, 5, 8, 30, 15, 450.00, '2021-09-22 20:21:23');
INSERT INTO `sale` VALUES (46, 4, 4, 1, 3, 3.00, '2021-10-18 23:53:19');
INSERT INTO `sale` VALUES (47, 4, 3, 50, 5, 250.00, '2021-10-18 23:54:23');
INSERT INTO `sale` VALUES (48, 4, 19, 3, 8, 24.00, '2021-10-23 17:17:15');
INSERT INTO `sale` VALUES (49, 4, 18, 3, 3, 9.00, '2021-10-24 15:40:44');
INSERT INTO `sale` VALUES (50, 4, 26, 16, -10, -160.00, '2021-11-21 10:03:32');
INSERT INTO `sale` VALUES (51, 4, 18, 1, 3, 3.00, '2021-11-21 10:04:39');
INSERT INTO `sale` VALUES (52, 4, 5, 14, 3, 42.00, '2021-11-21 10:06:00');
INSERT INTO `sale` VALUES (53, 5, 3, 33, 8, 264.00, '2021-11-21 14:19:39');

-- ----------------------------
-- Table structure for sildeshow
-- ----------------------------
DROP TABLE IF EXISTS `sildeshow`;
CREATE TABLE `sildeshow`  (
  `id` int(50) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '轮播图id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标题',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '轮播图路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sildeshow
-- ----------------------------
INSERT INTO `sildeshow` VALUES (1, '第一张', '/upload/20211103203100part5.jpg');
INSERT INTO `sildeshow` VALUES (2, '第二张', '/upload/20211103203147v2-106dfb1020d2e578edfc762ed460fe0a_720w.jpg');
INSERT INTO `sildeshow` VALUES (8, '第三张', '/upload/20211103203132v2-ae9d6d076fe5a3976514bf917ac4f52a_720w.jpg');
INSERT INTO `sildeshow` VALUES (9, '第四张', '/upload/20211103203210v2-031c044a8ffffa14633a3f404a7cbda0_720w.jpg');

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock`  (
  `skid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '进货id',
  `commid` int(255) NULL DEFAULT NULL COMMENT '商品id获取名称 价格',
  `skmoney` double(255, 2) NULL DEFAULT NULL COMMENT '进货价格',
  `sknumber` int(255) NULL DEFAULT NULL COMMENT '进货数量',
  `totalprice` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '进货总价格',
  `skdate` datetime(0) NULL DEFAULT NULL COMMENT '进货时间',
  PRIMARY KEY (`skid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES (1, 3, 10.00, 300, '3000', '2021-10-02 23:27:54');
INSERT INTO `stock` VALUES (10, 3, 30.00, 80, '2400.0', '2021-10-10 12:02:15');
INSERT INTO `stock` VALUES (11, 14, 30.00, 15, '450.0', '2021-10-10 23:42:48');
INSERT INTO `stock` VALUES (12, 4, 30.00, 20, '600.0', '2021-10-12 19:22:06');
INSERT INTO `stock` VALUES (14, 5, 10.00, 300, '3000.0', '2021-10-15 21:38:49');
INSERT INTO `stock` VALUES (15, 8, 10.00, 300, '3000.0', '2021-10-15 21:39:41');
INSERT INTO `stock` VALUES (16, 17, 2.00, 300, '600.0', '2021-07-15 21:44:08');
INSERT INTO `stock` VALUES (17, 15, 3.00, 200, '600.0', '2021-08-12 21:48:05');
INSERT INTO `stock` VALUES (18, 9, 7.00, 150, '1050.0', '2021-09-18 21:54:00');
INSERT INTO `stock` VALUES (19, 3, 2.00, 20, '40.0', '2021-09-16 17:45:05');
INSERT INTO `stock` VALUES (20, 3, 2.00, 30, '60.0', '2021-08-12 17:47:28');
INSERT INTO `stock` VALUES (21, 5, 3.00, 300, '900.0', '2021-09-17 20:16:33');
INSERT INTO `stock` VALUES (22, 19, 3.00, 20, '60.0', '2021-10-21 23:10:44');
INSERT INTO `stock` VALUES (23, 18, 3.00, 500, '1500.0', '2021-10-21 23:11:35');
INSERT INTO `stock` VALUES (24, 25, 6.00, 200, '1200.0', '2021-10-24 15:38:09');
INSERT INTO `stock` VALUES (25, 26, -10.00, 100, '-1000.0', '2021-11-21 10:03:11');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '序号',
  `login_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登录名',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '密码',
  `sex` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '性别',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  `address` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'test1', 'test', 't123', '男', '3319382388@qq.com', '芜湖');
INSERT INTO `user` VALUES (12, 'rr', 'project', 'admin123', '男', '2967168206@qq.com', '开冲');
INSERT INTO `user` VALUES (4, 'lx', 'admin', 'admin123', '男', '1137601326@qq.com', '兴宁市');
INSERT INTO `user` VALUES (5, 'wr', '温柔', 'wr0925wr', '女', '1386864684@qq.com', '颐宁苑');
INSERT INTO `user` VALUES (6, 'zz', '张振杰', '123456', '男', '1134834684@qq.com', '五华');
INSERT INTO `user` VALUES (7, 'dwji', '张纪龙', '123456', '男', '18384836868@qq.com', '龙田');
INSERT INTO `user` VALUES (8, 'gwgw', '黄涛烽', '123456', '男', '3013770761@qq.com', '天庭');

SET FOREIGN_KEY_CHECKS = 1;
