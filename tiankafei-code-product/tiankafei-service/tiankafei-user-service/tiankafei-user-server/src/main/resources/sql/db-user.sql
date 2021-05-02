/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : db-user

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 24/10/2020 00:12:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dept_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_info`;
CREATE TABLE `sys_dept_info`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '主键id',
  `dept_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门代码',
  `dept_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门名称',
  `parent_id` int(0) NULL DEFAULT NULL COMMENT '父部门',
  `serial_number` int(0) NULL DEFAULT NULL COMMENT '序号',
  `level` int(0) NULL DEFAULT NULL COMMENT '当前部门所处的层级(在第几级)',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '部门职责',
  `version` int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
  `delete_mark` int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(0) NULL DEFAULT NULL COMMENT '部门创建用户ID',
  `update_user_id` bigint(0) NULL DEFAULT NULL COMMENT '部门修改用户ID',
  `tenant_id` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_dept_code`(`dept_code`) USING BTREE COMMENT '按照部门代码查询部门信息'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统部门表信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept_info
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_info`;
CREATE TABLE `sys_dict_info`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '主键id',
  `dict_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典代码',
  `dict_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典名称',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '状态：0设计中，1启用，2停用',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '描述',
  `remarks` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `data_table` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '数据表',
  `version` int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
  `delete_mark` int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `create_user_id` bigint(0) NULL DEFAULT NULL COMMENT '创建用户ID',
  `update_user_id` bigint(0) NULL DEFAULT NULL COMMENT '修改用户ID',
  `tenant_id` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_dict_code`(`dict_code`) USING BTREE COMMENT '根据字典代码查询字典详细信息'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统数据字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_info
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict_table
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_table`;
CREATE TABLE `sys_dict_table`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '主键id',
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '代码',
  `name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '描述',
  `remarks` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `parent_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父id',
  `all_parent_id` varchar(2100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所有父id，用逗号分隔',
  `serial_number` int(0) NULL DEFAULT NULL COMMENT '序号',
  `level` int(0) NULL DEFAULT NULL COMMENT '所在层级',
  `unit1` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '计量单位1',
  `unit2` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '计量单位2',
  `unit3` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '计量单位3',
  `unit4` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '计量单位4',
  `unit5` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '计量单位5',
  `unit6` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '计量单位6',
  `version` int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
  `delete_mark` int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `create_user_id` bigint(0) NULL DEFAULT NULL COMMENT '创建用户ID',
  `update_user_id` bigint(0) NULL DEFAULT NULL COMMENT '修改用户ID',
  `tenant_id` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_code`(`code`) USING BTREE COMMENT '按照代码查询详细信息'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统数据字典的数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_table
-- ----------------------------

-- ----------------------------
-- Table structure for sys_links_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_links_info`;
CREATE TABLE `sys_links_info`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '链接名称',
  `links` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '链接地址',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态：是否启用，1启用，2停用',
  `serial_number` int(0) NULL DEFAULT NULL COMMENT '序号',
  `version` int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
  `delete_mark` int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(0) NULL DEFAULT NULL COMMENT '创建用户ID',
  `update_user_id` bigint(0) NULL DEFAULT NULL COMMENT '修改用户ID',
  `tenant_id` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统的友情链接' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_links_info
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_info`;
CREATE TABLE `sys_menu_info`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '主键id',
  `menu_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '功能代码',
  `menu_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '功能名称',
  `icon` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图标的名称',
  `menu_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '1' COMMENT '菜单类型：1目录，2菜单，3按钮',
  `open_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '打开方式：1页签，2新窗口',
  `path` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '功能的url路径',
  `is_outside_url` tinyint(1) NULL DEFAULT NULL COMMENT '是否外部链接：1是，0否',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '状态：1启用，0停用',
  `keys` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限关键字标识',
  `parent_id` int(0) NULL DEFAULT NULL COMMENT '父id',
  `serial_number` int(0) NULL DEFAULT NULL COMMENT '顺序',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '描述',
  `version` int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
  `delete_mark` int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `create_user_id` bigint(0) NULL DEFAULT NULL COMMENT '创建用户ID',
  `update_user_id` bigint(0) NULL DEFAULT NULL COMMENT '修改用户ID',
  `tenant_id` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_feature_code`(`menu_code`) USING BTREE COMMENT '按照功能代码进行查询'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统功能菜单信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu_info
-- ----------------------------
INSERT INTO `sys_menu_info` VALUES (1, 'system-manager', '系统管理', 'system', '1', '1', NULL, 0, 1, NULL, NULL, 1, NULL, NULL, NULL, '2020-07-26 10:57:56', '2020-07-26 10:57:56', NULL, NULL, NULL);
INSERT INTO `sys_menu_info` VALUES (100, 'user-manager', '用户管理', 'user', '2', '1', NULL, 0, 1, NULL, 1, 1, NULL, NULL, NULL, '2020-07-26 10:58:01', '2020-07-26 10:58:01', NULL, NULL, NULL);
INSERT INTO `sys_menu_info` VALUES (101, 'role-manager', '角色管理', 'peoples', '2', '1', NULL, 0, 1, NULL, 1, 2, NULL, NULL, NULL, '2020-07-26 10:58:02', '2020-07-26 10:58:02', NULL, NULL, NULL);
INSERT INTO `sys_menu_info` VALUES (102, 'menu-manager', '菜单管理', 'tree-table', '2', '1', NULL, 0, 1, NULL, 1, 3, NULL, NULL, NULL, '2020-07-26 10:58:10', '2020-07-26 10:58:10', NULL, NULL, NULL);
INSERT INTO `sys_menu_info` VALUES (103, 'department-manager', '部门管理', 'tree', '2', '1', NULL, 0, 1, NULL, 1, 4, NULL, NULL, NULL, '2020-07-26 10:58:15', '2020-07-26 10:58:15', NULL, NULL, NULL);
INSERT INTO `sys_menu_info` VALUES (104, 'dict-manager', '字典管理', 'dict', '2', '1', NULL, 0, 1, NULL, 1, 5, NULL, NULL, NULL, '2020-07-26 10:58:21', '2020-07-26 10:58:21', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_role_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_info`;
CREATE TABLE `sys_role_info`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '主键id',
  `role_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色代码',
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名称',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '角色状态:1启用，0停用',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '描述',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `version` int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
  `delete_mark` int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `create_user_id` bigint(0) NULL DEFAULT NULL COMMENT '创建用户ID',
  `update_user_id` bigint(0) NULL DEFAULT NULL COMMENT '修改用户ID',
  `tenant_id` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_role_code`(`role_code`) USING BTREE COMMENT '按照索引代码进行查询'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_info
-- ----------------------------
INSERT INTO `sys_role_info` VALUES (1, 'admin', '管理员角色', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_role_info` VALUES (2, 'common', '普通角色', 1, NULL, NULL, NULL, NULL, '2020-07-26 10:09:15', '2020-07-26 10:09:15', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '主键id',
  `role_id` int(0) NOT NULL COMMENT '角色id',
  `menu_id` int(0) NOT NULL COMMENT '菜单id',
  `tenant_id` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_role_id`(`role_id`) USING BTREE COMMENT '根据角色id查询其配置的功能菜单'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统角色对应的功能配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1, NULL);
INSERT INTO `sys_role_menu` VALUES (2, 1, 100, NULL);
INSERT INTO `sys_role_menu` VALUES (3, 1, 101, NULL);
INSERT INTO `sys_role_menu` VALUES (4, 1, 102, NULL);
INSERT INTO `sys_role_menu` VALUES (5, 1, 103, NULL);
INSERT INTO `sys_role_menu` VALUES (6, 1, 104, NULL);
INSERT INTO `sys_role_menu` VALUES (7, 2, 1, NULL);
INSERT INTO `sys_role_menu` VALUES (8, 2, 100, NULL);
INSERT INTO `sys_role_menu` VALUES (9, 2, 101, NULL);
INSERT INTO `sys_role_menu` VALUES (10, 2, 102, NULL);
INSERT INTO `sys_role_menu` VALUES (11, 2, 103, NULL);
INSERT INTO `sys_role_menu` VALUES (12, 2, 104, NULL);

-- ----------------------------
-- Table structure for sys_user_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '主键',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称，中文名',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `telephone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号码',
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别：1男，2女，3未知',
  `born_time` timestamp(0) NULL DEFAULT NULL COMMENT '出生日期',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `user_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户类型',
  `dept_id` int(0) NULL DEFAULT NULL COMMENT '部门id',
  `version` int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
  `delete_mark` int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `create_user_id` bigint(0) NULL DEFAULT NULL COMMENT '创建用户ID',
  `update_user_id` bigint(0) NULL DEFAULT NULL COMMENT '修改用户ID',
  `tenant_id` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_username`(`username`) USING BTREE COMMENT '按用户名查询或登录',
  UNIQUE INDEX `idx_email`(`email`) USING BTREE COMMENT '按电子邮件查询或登录',
  UNIQUE INDEX `idx_phone`(`telephone`) USING BTREE COMMENT '按手机号码查询或登录'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户基本信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_info
-- ----------------------------
INSERT INTO `sys_user_info` VALUES (1285547947985457153, 'tiankafei', '甜咖啡', '798971170@qq.com', '18500195219', '1', NULL, '', '1', '1', 0, NULL, 0, '2020-08-14 08:57:28', '2020-08-14 08:57:28', 0, 0, NULL);
INSERT INTO `sys_user_info` VALUES (1286986461696372738, 'admin', '', '614470410@qq.com', '18519346836', '1', NULL, '', '', '1', 0, NULL, 0, '2020-08-14 08:57:29', '2020-08-14 08:57:29', 0, 0, NULL);

-- ----------------------------
-- Table structure for sys_user_login
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_login`;
CREATE TABLE `sys_user_login`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '主键',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `telephone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号码',
  `password` char(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态：1正常，2停用，3指定有效期',
  `version` int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
  `delete_mark` int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
  `expiration_date` timestamp(0) NULL DEFAULT NULL COMMENT '有效期截至时间',
  `tenant_id` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_username`(`username`) USING BTREE COMMENT '按用户名查询或登录',
  UNIQUE INDEX `idx_email`(`email`) USING BTREE COMMENT '按电子邮件查询或登录',
  UNIQUE INDEX `idx_phone`(`telephone`) USING BTREE COMMENT '按手机号码查询或登录'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户登录信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_login
-- ----------------------------
INSERT INTO `sys_user_login` VALUES (1285547947985457153, 'tiankafei', '798971170@qq.com', '18500195219', '796b0ef943abedf4943e656d435c144c', '1', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_login` VALUES (1286986461696372738, 'admin', '614470410@qq.com', '18519346836', '0192023a7bbd73250516f069df18b500', '1', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '主键id',
  `user_id` bigint(0) NOT NULL COMMENT '用户id',
  `role_id` int(0) NOT NULL COMMENT '角色id',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态：1在用，0停用',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_user_id` bigint(0) NULL DEFAULT NULL COMMENT '创建用户ID',
  `update_user_id` bigint(0) NULL DEFAULT NULL COMMENT '修改用户ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE COMMENT '根据用户id查询所拥有的所有角色',
  INDEX `idx_role_id`(`role_id`) USING BTREE COMMENT '根据角色id查询所有拥有该角色的用户'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户拥有的角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1286986461696372738, 1, 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (2, 1285547947985457153, 2, 1, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_test
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_test`;
CREATE TABLE `sys_user_test`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '主键',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称，中文名',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `telephone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号码',
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别：1男，2女，3未知',
  `born_time` timestamp(0) NULL DEFAULT NULL COMMENT '出生日期',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `user_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户类型',
  `version` int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
  `delete_mark` int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
  `department_id` int(0) NULL DEFAULT NULL COMMENT '部门id',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `create_user_id` bigint(0) NULL DEFAULT NULL COMMENT '创建用户ID',
  `update_user_id` bigint(0) NULL DEFAULT NULL COMMENT '修改用户ID',
  `tenant_id` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_username`(`username`) USING BTREE COMMENT '按用户名查询或登录',
  UNIQUE INDEX `idx_email`(`email`) USING BTREE COMMENT '按电子邮件查询或登录',
  UNIQUE INDEX `idx_phone`(`telephone`) USING BTREE COMMENT '按手机号码查询或登录'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户基本信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_test
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
