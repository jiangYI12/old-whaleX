/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : whalex-sys

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 19/07/2020 20:57:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_route_conf
-- ----------------------------
DROP TABLE IF EXISTS `sys_route_conf`;
CREATE TABLE `sys_route_conf`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `route_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `route_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `predicates` json NULL COMMENT '断言',
  `filters` json NULL COMMENT '过滤器',
  `uri` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `order_num` int(2) NULL DEFAULT 0 COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '路由配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_route_conf
-- ----------------------------
INSERT INTO `sys_route_conf` VALUES (1, '认证中心', 'whale-auth', '[{\"args\": {\"_genkey_0\": \"/whale-auth/**\"}, \"name\": \"Path\"}]', '[]', 'lb://whale-auth', 0, '2019-10-16 16:44:41', '2020-07-14 21:59:41', '0');
INSERT INTO `sys_route_conf` VALUES (2, '用户中心', 'whale-user-centre', '[{\"args\": {\"_genkey_0\": \"/whale-user/**\"}, \"name\": \"Path\"}]', '[]', 'lb://whale-user-centre', 0, '2019-10-16 16:44:41', '2020-07-14 21:59:49', '0');
INSERT INTO `sys_route_conf` VALUES (3, '系统中心', 'whale-system-centre', '[{\"args\": {\"_genkey_0\": \"/whale-system/**\"}, \"name\": \"Path\"}]', '[]', 'lb://whale-system-centre', 0, '2019-10-16 16:44:41', '2020-07-14 21:59:55', '0');

SET FOREIGN_KEY_CHECKS = 1;
