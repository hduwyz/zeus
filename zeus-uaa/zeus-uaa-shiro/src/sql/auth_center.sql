/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.200
Source Server Version : 80019
Source Host           : 192.168.1.200:3306
Source Database       : auth_center

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-04-24 11:06:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资源路径 如：/userinfo/list',
  `permission` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限字符串：anon、logout、authc',
  `sort` int DEFAULT NULL COMMENT '权限排序',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '/static/**', 'anon', '1', '静态资源');
INSERT INTO `permission` VALUES ('2', '/submitLogin', 'anon', '2', '登入');
INSERT INTO `permission` VALUES ('3', '/logout', 'anon', '3', '退出');
INSERT INTO `permission` VALUES ('4', '/add', 'perms[权限添加]', '4', '添加用户');
INSERT INTO `permission` VALUES ('6', '/kickout', 'anon', '2', '踢出');
INSERT INTO `permission` VALUES ('8', '/user/**', 'perms[user:config]', '4', '用户配置');
INSERT INTO `permission` VALUES ('9', '/role/**', 'perms[role:config]', '4', '角色配置');
INSERT INTO `permission` VALUES ('10', '/permission/**', 'perms[permission:config]', '4', '权限配置');
INSERT INTO `permission` VALUES ('11', '/**', 'authc', '5', '其他所有');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `available` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '是否可用0可用  1不可用',
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色标识程序中判断使用,如"admin"',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色描述,UI界面显示使用',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `role` (`role`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '1', 'adminL1', '一级管理员');
INSERT INTO `role` VALUES ('2', '1', 'adminL2', '二级管理员');
INSERT INTO `role` VALUES ('3', '1', 'user', '普通用户');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` int NOT NULL COMMENT '角色id',
  `permission_id` int NOT NULL COMMENT '权限id',
  PRIMARY KEY (`role_id`,`permission_id`) USING BTREE,
  KEY `role_id` (`role_id`) USING BTREE,
  KEY `permission_id` (`permission_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '8');
INSERT INTO `role_permission` VALUES ('1', '9');
INSERT INTO `role_permission` VALUES ('1', '10');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户真实姓名',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码盐',
  `phone_num` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户手机号',
  `id_card_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户身份证号',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `last_login_time` date DEFAULT NULL COMMENT '最后登入时间',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '用户状态：0:正常状态,1：用户被锁定',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `id_card_num` (`id_card_num`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', 'kk', 'ac8b7602b52e2cf6f2d89f653b33cfb8', '大白', '1df771ef72aafb3239de56e650a48378', '13577777777', null, null, null, '0');
INSERT INTO `user` VALUES ('4', 'mm', '56654a31c395d985a66baddb5fd03a36', '大白', '993791a9fbdc2037e07987271709d66c', '13577777777', null, null, '2020-04-23', '0');
INSERT INTO `user` VALUES ('5', 'cc', '513f7022741ecbb74fecb13092c5baec', '大白', 'cc844820bce7ce282f8674cb3cfcf753', '13577777777', null, null, '2020-04-23', '0');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int NOT NULL COMMENT '用户id',
  `role_id` int NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`,`role_id`) USING BTREE,
  KEY `uid` (`user_id`) USING BTREE,
  KEY `role_id` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('2', '2');
INSERT INTO `user_role` VALUES ('4', '1');
INSERT INTO `user_role` VALUES ('5', '3');
