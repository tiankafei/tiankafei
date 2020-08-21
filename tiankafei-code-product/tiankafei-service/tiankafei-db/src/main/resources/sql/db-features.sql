/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : db-features

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 21/08/2020 22:25:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_attributes_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_attributes_info`;
CREATE TABLE `sys_attributes_info`  (
  `id` bigint(0) NOT NULL COMMENT '主键id',
  `features_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '功能代码',
  `attributes_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '属性代码',
  `attributes_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '属性名称',
  `data_type` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '数据类型',
  `data_length` int(0) NULL DEFAULT NULL COMMENT '数据长度',
  `data_precision` tinyint(0) NULL DEFAULT NULL COMMENT '数据精度',
  `is_null` tinyint(1) NULL DEFAULT NULL COMMENT '是否允许为空',
  `default_value` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '默认值',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '功能描述',
  `version` int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
  `delete_mark` int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(0) NULL DEFAULT NULL COMMENT '创建用户ID',
  `update_user_id` bigint(0) NULL DEFAULT NULL COMMENT '修改用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '功能的属性注册表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_attributes_info
-- ----------------------------

-- ----------------------------
-- Table structure for sys_features_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_features_info`;
CREATE TABLE `sys_features_info`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `features_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '功能代码',
  `features_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '功能名称',
  `features_table_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '功能的数据表',
  `serial_number` int(0) NULL DEFAULT NULL COMMENT '序号',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '功能描述',
  `version` int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
  `delete_mark` int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(0) NULL DEFAULT NULL COMMENT '创建用户ID',
  `update_user_id` bigint(0) NULL DEFAULT NULL COMMENT '修改用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '功能注册表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_features_info
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
