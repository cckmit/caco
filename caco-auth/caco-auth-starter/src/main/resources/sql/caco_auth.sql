/*
 Navicat Premium Data Transfer

 Source Server         : test-192.168.200.28
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 192.168.200.28:3306
 Source Schema         : caco_auth

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 30/05/2019 10:18:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `sys_oauth_client_details`;
CREATE TABLE `sys_oauth_client_details`  (
  `client_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
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
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oauth_client_details
-- ----------------------------
INSERT INTO `sys_oauth_client_details` VALUES ('op', NULL, '$2a$10$0GH5XMN1v97rdLFKAwqAU.iAK1cG6ZBHzVbACuvhdo/DX6pm5VAyG', 'server', 'password,refresh_token,implicit,authorization_code,mobile,username', NULL, NULL, 604800, 604800, NULL, 'true');
INSERT INTO `sys_oauth_client_details` VALUES ('zuul', NULL, '$2a$10$0GH5XMN1v97rdLFKAwqAU.iAK1cG6ZBHzVbACuvhdo/DX6pm5VAyG', 'server', 'password,refresh_token,implicit,authorization_code,mobile', NULL, NULL, NULL, NULL, NULL, 'true');

SET FOREIGN_KEY_CHECKS = 1;
