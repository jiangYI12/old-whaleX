/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : whalex-customer

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 09/08/2020 22:46:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_customer
-- ----------------------------
DROP TABLE IF EXISTS `sys_customer`;
CREATE TABLE `sys_customer`  (
  `id` bigint(64) NOT NULL,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `tenant_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '租户号',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '头像',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT 1 COMMENT '0停用 1启用',
  `is_delete` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '0未删除 1删除',
  `create_user` bigint(64) NULL DEFAULT NULL,
  `update_user` bigint(64) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `select_account`(`tenant_code`, `account`) USING BTREE,
  INDEX `select_password`(`tenant_code`, `phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_customer
-- ----------------------------
INSERT INTO `sys_customer` VALUES (1, 'sdad23307216', 'Ai', '$2a$10$GABJlqwObPVT3coK2I3gleUfiURBgvDtw0wX//lWAWDNwIFPFZVtS', '0', '13202361544', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2091711702,2468700162&fm=11&gp=0.jpg', '2020-07-11 17:53:00', NULL, 1, '0', NULL, NULL);
INSERT INTO `sys_customer` VALUES (1286956233114275841, 'sdad23307211', '游客账户', '$2a$10$7uY6gaA8U9aF0Ik4GSoQJe9pXtQtMSXNzhnjwf1wtaqzAdySMTzO6', '0', '13202361544', '', '2020-07-25 17:27:31', NULL, 1, '1', NULL, NULL);

-- ----------------------------
-- Table structure for sys_customer_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_customer_role`;
CREATE TABLE `sys_customer_role`  (
  `id` bigint(64) NULL DEFAULT NULL,
  `customer_id` bigint(64) NULL DEFAULT NULL,
  `role_id` bigint(64) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_customer_role
-- ----------------------------
INSERT INTO `sys_customer_role` VALUES (1, 1, 1);
INSERT INTO `sys_customer_role` VALUES (1286956233152024578, 1286956233114275841, 2);
INSERT INTO `sys_customer_role` VALUES (1286956233160413186, 1286956233114275841, 1286294220004405249);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(64) NOT NULL,
  `permission_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限编码',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路径',
  `tenant_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `is_delete` int(2) NULL DEFAULT 0 COMMENT '是否删除 0未删除 1删除',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '0开启 1关闭',
  `create_user` bigint(64) NULL DEFAULT NULL,
  `update_user` bigint(64) NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单名',
  `parent_id` bigint(64) NULL DEFAULT NULL COMMENT '父类ID',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标志',
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 'permissions', '/permissions', '0', '2020-07-31 12:35:12', '2020-07-01 12:35:16', 0, '0', NULL, NULL, '权限管理', -1, NULL, '1');
INSERT INTO `sys_menu` VALUES (2, 'role', '/permissions/role/index', '0', '2020-07-25 14:13:10', NULL, 0, '0', NULL, NULL, '角色管理', 1, NULL, '1');
INSERT INTO `sys_menu` VALUES (3, 'permission', '/permissions/permission/index', '0', '2020-07-25 14:15:06', NULL, 0, '0', NULL, NULL, '菜单管理', 1, NULL, '2');
INSERT INTO `sys_menu` VALUES (1287231767190740993, 'userManager', '/userManager/index', '0', '2020-07-26 11:42:24', NULL, 0, '0', NULL, NULL, '用户管理', -1, '', '0');

-- ----------------------------
-- Table structure for sys_oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `sys_oauth_client_details`;
CREATE TABLE `sys_oauth_client_details`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `client_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `resource_ids` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `client_secret` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authorized_grant_types` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authorities` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `access_token_validity` int(11) NULL DEFAULT NULL,
  `refresh_token_validity` int(11) NULL DEFAULT NULL,
  `additional_information` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `autoapprove` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `tenant_code` int(11) NOT NULL DEFAULT 0 COMMENT '所属租户',
  `is_delete` int(2) NULL DEFAULT NULL COMMENT '0未删除 删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '终端信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oauth_client_details
-- ----------------------------
INSERT INTO `sys_oauth_client_details` VALUES (1, 'app', NULL, '$2a$10$oNHRKmhfN0VG4ndFOSmZOOUFY8oKrdxkdz4i0AGh8Tx/hcGCBHz8K', 'server', 'password,refresh_token,authorization_code,client_credentials,implicit', NULL, NULL, 43200, 2592001, NULL, 'true', 0, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(64) NOT NULL,
  `tenant_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名中文',
  `role_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色英文名',
  `role_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `is_delete` int(2) NULL DEFAULT 0 COMMENT '是否删除 0未删除 1删除',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT 1,
  `create_user` bigint(64) NULL DEFAULT NULL,
  `update_user` bigint(64) NULL DEFAULT NULL,
  `sort` int(10) NULL DEFAULT NULL COMMENT '排序',
  `keepAlive` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路由缓冲',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '0', '管理员', 'admin', '管理员', 0, '2020-07-11 17:53:00', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role` VALUES (2, '0', '普通用户', 'user', '普通用户', 0, '2020-07-21 20:45:34', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role` VALUES (1286294220004405249, '0', '体验用户', 'anonymous', '体验用户', 0, '2020-07-23 21:36:55', NULL, 1, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(64) NOT NULL,
  `role_id` bigint(64) NULL DEFAULT NULL,
  `menu_id` bigint(64) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1287043740317265921, 1, 1);
INSERT INTO `sys_role_menu` VALUES (1287255336972996609, 2, 3);

-- ----------------------------
-- Table structure for sys_tenant
-- ----------------------------
DROP TABLE IF EXISTS `sys_tenant`;
CREATE TABLE `sys_tenant`  (
  `id` bigint(64) NOT NULL,
  `componey_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公司名',
  `tenant_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租户号',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `status` int(255) NOT NULL DEFAULT 1 COMMENT '0 关闭 1开启',
  `create_user` bigint(64) NULL DEFAULT NULL,
  `updateUser` bigint(64) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '租户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_tenant
-- ----------------------------
INSERT INTO `sys_tenant` VALUES (1, '顺德路炒股养家', '0', '2020-07-11 17:53:00', NULL, 1, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
