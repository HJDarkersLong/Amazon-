/*
Navicat MySQL Data Transfer

Source Server         : m.uxuan.info
Source Server Version : 50530
Source Host           : m.uxuan.info:3306
Source Database       : cms

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2019-04-02 14:29:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT '' COMMENT '文章内容',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1.有效  2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='发布号作者表';

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('5', '莎士比亚', '2017-10-25 09:08:45', '2017-10-30 17:59:41', '1');
INSERT INTO `article` VALUES ('6', '亚里士多德', '2017-10-26 10:49:28', '2017-11-18 09:54:15', '1');
INSERT INTO `article` VALUES ('10', '亚历山大', '2017-10-26 14:57:45', '2017-11-08 13:28:52', '1');
INSERT INTO `article` VALUES ('11', '李白', '2017-10-26 15:23:42', '2017-10-26 15:23:42', '1');
INSERT INTO `article` VALUES ('19', '文章test2', '2017-11-18 13:37:07', '2017-11-18 13:37:11', '1');

-- ----------------------------
-- Table structure for goods_base_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_base_info`;
CREATE TABLE `goods_base_info` (
  `id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL COMMENT '商品名称',
  `cn_name` varchar(255) DEFAULT NULL COMMENT '中文名称',
  `en_name` varchar(255) DEFAULT NULL COMMENT '英文名称',
  `pcl_no` varchar(64) DEFAULT NULL COMMENT 'pcl商品编号',
  `sku_no` varchar(64) DEFAULT NULL COMMENT 'sku货品编号',
  `other_name` varchar(255) DEFAULT NULL COMMENT '别名',
  `cn_customs_name` varchar(255) DEFAULT NULL COMMENT '中文报关名称',
  `en_customs_name` varchar(255) DEFAULT NULL COMMENT '英文报关名称',
  `hs_code` varchar(64) DEFAULT NULL COMMENT '海关编码',
  `category_no` varchar(64) DEFAULT NULL COMMENT '分类编号',
  `tag_no` varchar(64) DEFAULT NULL COMMENT '标签编号',
  `brand_no` varchar(64) DEFAULT NULL COMMENT '品牌编号',
  `business_dev_user_no` varchar(64) DEFAULT NULL COMMENT '业务开发员',
  `buy_qus_user_no` varchar(64) DEFAULT NULL COMMENT '采购询价员',
  `buy_user_no` varchar(64) DEFAULT NULL COMMENT '采购员',
  `length` int(20) unsigned zerofill DEFAULT NULL COMMENT '长(cm)',
  `width` int(20) unsigned zerofill NOT NULL COMMENT '宽(cm)',
  `height` int(20) unsigned zerofill DEFAULT NULL COMMENT '高(cm)',
  `weight` int(20) unsigned zerofill DEFAULT NULL COMMENT '重量(kg)',
  `body_weight_5000` int(20) unsigned zerofill DEFAULT NULL COMMENT '材积重/5000(L*W*H))',
  `body_weight_6000` int(20) unsigned zerofill DEFAULT NULL COMMENT '材积重/6000(L*W*H))',
  `base_price` int(18) unsigned zerofill DEFAULT NULL COMMENT '成本价格(分)',
  `sale_price` int(18) unsigned zerofill DEFAULT NULL COMMENT '销售价格(分)',
  `pic_address` varchar(64) DEFAULT NULL COMMENT '图片地址',
  `description` varchar(255) DEFAULT NULL COMMENT '产品描述',
  `easy_discription` varchar(255) DEFAULT NULL COMMENT '产品简要描述',
  `key_code` varchar(255) DEFAULT NULL COMMENT '关键词',
  `status` tinyint(4) DEFAULT NULL COMMENT '商品状态',
  `create_by` varchar(64) DEFAULT NULL,
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL,
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL,
  `delete_status` varchar(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品基本信息表';

-- ----------------------------
-- Records of goods_base_info
-- ----------------------------
INSERT INTO `goods_base_info` VALUES ('03fed079-5128-11e9-b5a5-00163e0e9182', '撒爱上', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '00000000000000000001', '00000000000000000001', '00000000000000000001', '00000000000000000001', '00000000000000000001', '00000000000000000001', '000000000000000001', '000000000000000001', '/upload/20190401/1554089390911_679JZD06WDGYZSM.jpg', '1', '1', '1', '1', 'admin', '2019-03-28 02:06:30', 'admin', '2019-03-28 02:06:30', '1', '1');
INSERT INTO `goods_base_info` VALUES ('50c95c75-5064-11e9-b5a5-00163e0e9182', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '00000000000000000001', '00000000000000000001', '00000000000000000001', '00000000000000000001', '00000000000000000001', '00000000000000000001', '000000000000000001', '000000000000000001', '/upload/20190401/1554089390911_679JZD06WDGYZSM.jpg', '1', '1', '1', '1', 'admin', '2019-03-27 02:45:37', 'admin', '2019-03-27 02:45:37', '1', '1');
INSERT INTO `goods_base_info` VALUES ('701a4776-542e-11e9-b5a5-00163e0e9182', '22222', 'www', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '00000000000000000002', '00000000000000000002', '00000000000000000002', '00000000000000000002', '00000000000000000002', '00000000000000000002', '000000000000000002', '000000000000000002', '/upload/20190401/1554089390911_679JZD06WDGYZSM.jpg', '2', '2', '2', '4', '10003', '2019-03-31 22:30:01', '10003', '2019-03-31 22:30:01', '222', '1');
INSERT INTO `goods_base_info` VALUES ('bce8b74a-542f-11e9-b5a5-00163e0e9182', '汉字商品', '', '', '', 'wqewq', '', '', '', '', '', '', '111', '', '', '', '00000000000000000001', '00000000000000000004', '00000000000000000005', '00000000000000000045', '00000000000000000002', '00000000000000000003', '000000000000000011', '000000000000000005', '/upload/20190401/1554089915605_801H03K66SX3U39.jpg', '', '', '', '2', '10003', '2019-03-31 22:39:19', '', '2019-03-31 22:39:19', '', '0');
INSERT INTO `goods_base_info` VALUES ('f5d583d2-542e-11e9-b5a5-00163e0e9182', '33333', '33', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '00000000000000000003', '00000000000000000003', '00000000000000000003', '00000000000000000004', '00000000000000000003', '00000000000000000003', '000000000000000003', '000000000000000003', '/upload/20190402/1554175084638_510161436vnbazscih2xviusv.jpg', '3', '3', '3', '2', '10003', '2019-03-31 22:33:45', '10003', '2019-03-31 22:33:45', '3', '1');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '自定id,主要供前端展示权限列表分类排序使用.',
  `menu_code` varchar(255) DEFAULT '' COMMENT '归属菜单,前端判断并展示菜单使用,',
  `menu_name` varchar(255) DEFAULT '' COMMENT '菜单的中文释义',
  `permission_code` varchar(255) DEFAULT '' COMMENT '权限的代码/通配符,对应代码中@RequiresPermissions 的value',
  `permission_name` varchar(255) DEFAULT '' COMMENT '本权限的中文释义',
  `required_permission` tinyint(1) DEFAULT '2' COMMENT '是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='后台权限表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('101', 'article', '文章管理', 'article:list', '列表', '1');
INSERT INTO `sys_permission` VALUES ('102', 'article', '文章管理', 'article:add', '新增', '2');
INSERT INTO `sys_permission` VALUES ('103', 'article', '文章管理', 'article:update', '修改', '2');
INSERT INTO `sys_permission` VALUES ('201', 'goods', '商品管理', 'goods:list', '列表', '1');
INSERT INTO `sys_permission` VALUES ('202', 'goods', '商品管理', 'goods:add', '新增', '2');
INSERT INTO `sys_permission` VALUES ('203', 'goods', '商品管理', 'goods:update', '修改', '2');
INSERT INTO `sys_permission` VALUES ('601', 'user', '用户', 'user:list', '列表', '1');
INSERT INTO `sys_permission` VALUES ('602', 'user', '用户', 'user:add', '新增', '2');
INSERT INTO `sys_permission` VALUES ('603', 'user', '用户', 'user:update', '修改', '2');
INSERT INTO `sys_permission` VALUES ('701', 'role', '角色权限', 'role:list', '列表', '1');
INSERT INTO `sys_permission` VALUES ('702', 'role', '角色权限', 'role:add', '新增', '2');
INSERT INTO `sys_permission` VALUES ('703', 'role', '角色权限', 'role:update', '修改', '2');
INSERT INTO `sys_permission` VALUES ('704', 'role', '角色权限', 'role:delete', '删除', '2');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1有效  2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='后台角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '2017-11-22 16:24:34', '2017-11-22 16:24:52', '1');
INSERT INTO `sys_role` VALUES ('2', '作家', '2017-11-22 16:24:34', '2017-11-22 16:24:52', '1');
INSERT INTO `sys_role` VALUES ('3', '程序员', '2017-11-22 16:28:47', '2017-11-22 16:28:47', '1');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效 1有效     2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='角色-权限关联表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '2', '101', '2017-11-22 16:26:21', '2017-11-22 16:26:32', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '2', '102', '2017-11-22 16:26:21', '2017-11-22 16:26:32', '1');
INSERT INTO `sys_role_permission` VALUES ('5', '2', '602', '2017-11-22 16:28:28', '2017-11-22 16:28:28', '1');
INSERT INTO `sys_role_permission` VALUES ('6', '2', '601', '2017-11-22 16:28:28', '2017-11-22 16:28:28', '1');
INSERT INTO `sys_role_permission` VALUES ('7', '2', '603', '2017-11-22 16:28:28', '2017-11-22 16:28:28', '1');
INSERT INTO `sys_role_permission` VALUES ('8', '2', '703', '2017-11-22 16:28:28', '2017-11-22 16:28:28', '1');
INSERT INTO `sys_role_permission` VALUES ('9', '2', '701', '2017-11-22 16:28:28', '2017-11-22 16:28:28', '1');
INSERT INTO `sys_role_permission` VALUES ('10', '2', '702', '2017-11-22 16:28:28', '2017-11-22 16:28:28', '1');
INSERT INTO `sys_role_permission` VALUES ('11', '2', '704', '2017-11-22 16:28:31', '2017-11-22 16:28:31', '1');
INSERT INTO `sys_role_permission` VALUES ('12', '2', '103', '2017-11-22 16:28:31', '2017-11-22 16:28:31', '1');
INSERT INTO `sys_role_permission` VALUES ('13', '3', '601', '2017-11-22 16:28:47', '2017-11-22 16:28:47', '1');
INSERT INTO `sys_role_permission` VALUES ('14', '3', '701', '2017-11-22 16:28:47', '2017-11-22 16:28:47', '1');
INSERT INTO `sys_role_permission` VALUES ('15', '3', '702', '2017-11-22 16:35:01', '2017-11-22 16:35:01', '1');
INSERT INTO `sys_role_permission` VALUES ('16', '3', '704', '2017-11-22 16:35:01', '2017-11-22 16:35:01', '1');
INSERT INTO `sys_role_permission` VALUES ('17', '3', '102', '2017-11-22 16:35:01', '2017-11-22 16:35:01', '1');
INSERT INTO `sys_role_permission` VALUES ('18', '3', '101', '2017-11-22 16:35:01', '2017-11-22 16:35:01', '1');
INSERT INTO `sys_role_permission` VALUES ('19', '3', '603', '2017-11-22 16:35:01', '2017-11-22 16:35:01', '1');
INSERT INTO `sys_role_permission` VALUES ('20', '2', '201', '2019-03-27 10:29:29', null, '1');
INSERT INTO `sys_role_permission` VALUES ('21', '3', '201', '2019-03-27 11:45:21', null, '1');
INSERT INTO `sys_role_permission` VALUES ('22', '3', '202', '2019-03-27 11:45:21', null, '1');
INSERT INTO `sys_role_permission` VALUES ('23', '3', '203', '2019-03-27 11:45:21', null, '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `role_id` int(11) DEFAULT '0' COMMENT '角色ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1有效  2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10008 DEFAULT CHARSET=utf8 COMMENT='运营后台用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('10003', 'admin', '123456', '超级用户', '1', '2017-10-30 11:52:38', '2017-11-17 23:51:40', '1');
INSERT INTO `sys_user` VALUES ('10004', 'user', '123456', '莎士比亚', '2', '2017-10-30 16:13:02', '2017-11-18 02:48:24', '1');
INSERT INTO `sys_user` VALUES ('10005', 'aaa', '123456', 'abba', '1', '2017-11-15 14:02:56', '2017-11-17 23:51:42', '1');
INSERT INTO `sys_user` VALUES ('10007', 'test', '123456', '就看看列表', '3', '2017-11-22 16:29:41', '2017-11-22 16:29:41', '1');
