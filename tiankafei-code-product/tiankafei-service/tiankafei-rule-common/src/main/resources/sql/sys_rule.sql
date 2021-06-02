/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : db-ry-cloud

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 02/06/2021 23:46:05
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_rule_data_alias
-- ----------------------------
DROP TABLE IF EXISTS `sys_rule_data_alias`;
CREATE TABLE `sys_rule_data_alias`
(
    `id`                               bigint(0) UNSIGNED NOT NULL COMMENT '主键',
    `dataset_unique_identifier`        varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '数据集的唯一标识符',
    `alias_name`                       varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '数据的别名',
    `source_dataset_unique_identifier` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '来源的数据集唯一标识符',
    `source_data_unique_identifier`    varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '来源的数据唯一标识符',
    `row_unique_identifier`            varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '行的唯一标识',
    `col_unique_identifier`            varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '列的唯一标识',
    `catalog_id`                       varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '二维挂目录时的目录id',
    `catalog_item`                     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '二维挂目录时的目录项id',
    `version`                          int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
    `delete_mark`                      int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
    `create_time`                      timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT '创建时间',
    `update_time`                      timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT '修改时间',
    `create_user_id`                   bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '创建用户ID',
    `update_user_id`                   bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '修改用户ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '规则中用到的数据的别名' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_rule_data_alias
-- ----------------------------

-- ----------------------------
-- Table structure for sys_rule_dataset_alias
-- ----------------------------
DROP TABLE IF EXISTS `sys_rule_dataset_alias`;
CREATE TABLE `sys_rule_dataset_alias`
(
    `id`                             bigint(0) UNSIGNED NOT NULL COMMENT '规则id',
    `cur_dataset_unique_identifier`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '当前数据集的唯一标识符',
    `step_dataset_unique_identifier` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '要跨的数据集的唯一标识符',
    `alias_name`                     varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '数据的别名',
    `version`                        int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
    `delete_mark`                    int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
    `create_time`                    timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT '创建时间',
    `update_time`                    timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT '修改时间',
    `create_user_id`                 bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '创建用户ID',
    `update_user_id`                 bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '修改用户ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '规则数据集的别名' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_rule_dataset_alias
-- ----------------------------

-- ----------------------------
-- Table structure for sys_rule_design
-- ----------------------------
DROP TABLE IF EXISTS `sys_rule_design`;
CREATE TABLE `sys_rule_design`
(
    `id`                          bigint(0) UNSIGNED NOT NULL COMMENT '规则id',
    `dataset_unique_identifier`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '数据集的唯一标识符',
    `code`                        varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '规则代码',
    `name`                        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '规则名称',
    `type`                        tinyint(0) NULL DEFAULT NULL COMMENT '规则类型：1审核规则，2计算规则，3跳转规则',
    `status`                      tinyint(1) NULL DEFAULT 1 COMMENT '状态：0停用，1启用',
    `offline`                     tinyint(1) NULL DEFAULT NULL COMMENT '是否支持离线审核',
    `expression`                  text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '规则表达式',
    `compile_error_message`       text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '编译不通过时的错误提示消息',
    `error_expression`            text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '错误规则表达式',
    `error_compile_error_message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '错误表达式编译不通过时的错误提示消息',
    `target_expression`           text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '目标表达式',
    `lock_expression`             text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '要锁的规则表达式',
    `version`                     int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
    `delete_mark`                 int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
    `create_time`                 timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT '创建时间',
    `update_time`                 timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT '修改时间',
    `create_user_id`              bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '创建用户ID',
    `update_user_id`              bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '修改用户ID',
    `tenant_id`                   bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '租户ID',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX                         `idx_code`(`code`) USING BTREE COMMENT '规则代码查询条件',
    INDEX                         `idx_status`(`status`, `type`) USING BTREE COMMENT '规则状态和规则类型查询条件',
    INDEX                         `idx_dataset`(`dataset_unique_identifier`) USING BTREE COMMENT '数据集唯一标识查询条件'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '规则设计表达式用户新增的对象' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_rule_design
-- ----------------------------

-- ----------------------------
-- Table structure for sys_rule_execute
-- ----------------------------
DROP TABLE IF EXISTS `sys_rule_execute`;
CREATE TABLE `sys_rule_execute`
(
    `id`                          bigint(0) UNSIGNED NOT NULL COMMENT '主键',
    `dataset_unique_identifier`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '数据集的唯一标识符',
    `rule_design_id`              bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '用户书写的规则id',
    `code`                        varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '规则代码',
    `name`                        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '规则名称',
    `type`                        tinyint(0) NULL DEFAULT NULL COMMENT '规则类型：1审核规则，2计算规则，3跳转规则',
    `status`                      tinyint(1) NULL DEFAULT 1 COMMENT '状态：0停用，1启用',
    `expression`                  text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '规则表达式',
    `javascript`                  text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '规则表达式生成的javascript的脚本',
    `expression_dto`              text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '规则表达式生成的规则解析对象',
    `compile_error_message`       text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '编译不通过时的错误提示消息',
    `error_expression`            text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '错误规则表达式',
    `error_javascript_list`       text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '错误规则表达式生成的javascript的脚本',
    `error_expression_list`       text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '错误规则表达式生成的规则解析对象集合',
    `error_compile_error_message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '错误表达式编译不通过时的错误提示消息',
    `target_expression`           text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '目标表达式',
    `target_expression_dto`       text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '目标规则表达式生成的规则解析对象',
    `lock_expression`             text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '要锁的规则表达式',
    `lock_expression_dto`         text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '要锁的规则表达式生成的规则解析对象',
    `version`                     int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
    `delete_mark`                 int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
    `create_time`                 timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT '创建时间',
    `update_time`                 timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT '修改时间',
    `create_user_id`              bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '创建用户ID',
    `update_user_id`              bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '修改用户ID',
    `tenant_id`                   bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '租户ID',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX                         `idx_status`(`status`, `type`) USING BTREE COMMENT '规则状态和规则类型查询条件',
    INDEX                         `idx_code`(`code`) USING BTREE COMMENT '规则代码查询条件',
    INDEX                         `idx_view_rule_id`(`rule_design_id`) USING BTREE COMMENT '用户书写的规则id查询条件'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '规则设计执行的对象' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_rule_execute
-- ----------------------------

-- ----------------------------
-- Table structure for sys_rule_jump
-- ----------------------------
DROP TABLE IF EXISTS `sys_rule_jump`;
CREATE TABLE `sys_rule_jump`
(
    `id`                          bigint(0) UNSIGNED NOT NULL COMMENT '规则id',
    `dataset_unique_identifier`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '数据集的唯一标识符',
    `data_unique_identifier`      varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '数据的唯一标识符',
    `rule_execute_id`             bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '规则的执行id',
    `reporting_period`            text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '报告期',
    `data_unique_identifier_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '数据的唯一标识符类型：1表达式中的数据，2要锁的表达式中的数据',
    `clear_flag`                  tinyint(1) NULL DEFAULT NULL COMMENT '是否需要清空格子的值：true清空，false不清空',
    `alias_name`                  varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '数据的别名',
    `version`                     int(0) NULL DEFAULT NULL COMMENT '乐观锁版本',
    `delete_mark`                 int(0) NULL DEFAULT 0 COMMENT '逻辑删除字段',
    `create_time`                 timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT '创建时间',
    `update_time`                 timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT '修改时间',
    `create_user_id`              bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '创建用户ID',
    `update_user_id`              bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '修改用户ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '跳转规则记录的数据唯一标识' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_rule_jump
-- ----------------------------

SET
FOREIGN_KEY_CHECKS = 1;
