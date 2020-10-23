/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : db-blog

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 23/10/2020 14:53:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_blog_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_blog_info`;
CREATE TABLE `sys_blog_info`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '主键id',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `content` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '文章内容，text：bai65535和字符，MEDIUMTEXT ：16777215个字符，LONGTEXT ：4294967295个字符',
  `type` varbinary(100) NULL DEFAULT NULL COMMENT '文章分类(only one)，字典表的code长度最大是100，故在此使用100',
  `label` varchar(240) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签(more)，一篇文章可以有多个标签：存储标签id，多个用逗号分隔',
  `is_top` tinyint(1) NULL DEFAULT NULL COMMENT '是否置顶，1是，0否',
  `custom_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '自定义访问路径的名称，默认使用id',
  `access_permission` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '访问权限：1功能开，2仅登录用户，3仅自己可见',
  `password` char(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码保护',
  `is_discuss` tinyint(1) NULL DEFAULT NULL COMMENT '是否开启评论，1是，0否',
  `is_subscription` tinyint(1) NULL DEFAULT NULL COMMENT '是否允许订阅',
  `release_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发布状态：1草稿，2已发布',
  `version` int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
  `delete_mark` int(0) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除字段',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `release_time` timestamp(0) NULL DEFAULT NULL COMMENT '发布时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(0) NULL DEFAULT NULL COMMENT '创建用户ID',
  `update_user_id` bigint(0) NULL DEFAULT NULL COMMENT '修改用户ID',
  `tenant_id` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_title`(`title`) USING BTREE COMMENT '按照标题查询博客',
  INDEX `idx_type`(`type`) USING BTREE COMMENT '按照分类查找博客'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统的博客数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_blog_info
-- ----------------------------
INSERT INTO `sys_blog_info` VALUES (1289742331580715010, '1111111', '', '', '', 1, '', '', '', 1, 1, '', NULL, 0, NULL, NULL, NULL, 0, 0, NULL);
INSERT INTO `sys_blog_info` VALUES (1289744459229499393, '1111111', '', '', '', 1, '', '', '', 1, 1, '', NULL, 0, NULL, NULL, NULL, 0, 0, NULL);
INSERT INTO `sys_blog_info` VALUES (1289744699152076802, '1111111', '', '', '', 1, '', '', '', 1, 1, '', NULL, 0, NULL, NULL, NULL, 0, 0, NULL);
INSERT INTO `sys_blog_info` VALUES (1289744702356525058, '1111111', '', '', '', 1, '', '', '', 1, 1, '', NULL, 0, NULL, NULL, NULL, 0, 0, NULL);
INSERT INTO `sys_blog_info` VALUES (1289744704793415682, '1111111', '', '', '', 1, '', '', '', 1, 1, '', NULL, 0, NULL, NULL, NULL, 0, 0, NULL);
INSERT INTO `sys_blog_info` VALUES (1289745878972010498, '1111111', '', '', '', 1, '', '', '', 1, 1, '', NULL, 0, NULL, NULL, NULL, 0, 0, NULL);
INSERT INTO `sys_blog_info` VALUES (1289745996555128834, '1111111', '', '', '', 1, '', '', '', 1, 1, '', NULL, 0, NULL, NULL, NULL, 0, 0, NULL);

-- ----------------------------
-- Table structure for sys_diary_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_diary_info`;
CREATE TABLE `sys_diary_info`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '主键id',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '日记内容，text：bai65535和字符，MEDIUMTEXT ：16777215个字符，LONGTEXT ：4294967295个字符',
  `custom_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '自定义访问路径的名称，默认使用id',
  `password` char(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码保护',
  `version` int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
  `delete_mark` int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(0) NULL DEFAULT NULL COMMENT '创建用户ID',
  `update_user_id` bigint(0) NULL DEFAULT NULL COMMENT '修改用户ID',
  `tenant_id` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_title`(`title`) USING BTREE COMMENT '按照日记标题查询日记'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统的博客日记' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_diary_info
-- ----------------------------

-- ----------------------------
-- Table structure for sys_global_setting
-- ----------------------------
DROP TABLE IF EXISTS `sys_global_setting`;
CREATE TABLE `sys_global_setting`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '主键id',
  `set_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '选项名称',
  `set_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '选项值',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '描述',
  `version` int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
  `delete_mark` int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '设置时间',
  `create_user_id` bigint(0) NULL DEFAULT NULL COMMENT '创建用户ID',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(0) NULL DEFAULT NULL COMMENT '修改用户ID',
  `tenant_id` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_create_user_id`(`create_user_id`) USING BTREE COMMENT '按照用户id查询当前用户的设置'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统的博客选项设置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_global_setting
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
