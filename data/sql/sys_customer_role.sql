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

 Date: 30/06/2020 22:31:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_customer_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_customer_role`;
CREATE TABLE `sys_customer_role`  (
  `id` bigint(64) NULL DEFAULT NULL,
  `customer_id` bigint(64) NULL DEFAULT NULL,
  `role_id` bigint(64) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
