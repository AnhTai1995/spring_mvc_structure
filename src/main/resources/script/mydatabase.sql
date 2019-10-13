/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : mydatabase

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 05/09/2019 18:04:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for articles
-- ----------------------------
DROP TABLE IF EXISTS `articles`;
CREATE TABLE `articles`  (
  `article_id` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `category` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `user_id` int(8) NULL DEFAULT NULL,
  PRIMARY KEY (`article_id`) USING BTREE,
  INDEX `fk1_article`(`user_id`) USING BTREE,
  CONSTRAINT `fk1_article` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of articles
-- ----------------------------
INSERT INTO `articles` VALUES (1, 'Java Concurrency', 'Java', 1);
INSERT INTO `articles` VALUES (2, 'Hibernate HQL ', 'Hibernate', 1);
INSERT INTO `articles` VALUES (3, 'Spring MVC with Hibernate', 'Spring', 2);
INSERT INTO `articles` VALUES (10, '1', 'test', 2);
INSERT INTO `articles` VALUES (11, '1', 'test', 2);
INSERT INTO `articles` VALUES (12, 'Java Concurrency 1', 'Java', 1);
INSERT INTO `articles` VALUES (13, 'Hibernate HQL  1', 'Hibernate', 1);
INSERT INTO `articles` VALUES (14, 'Spring MVC with Hibernate 1', 'Spring', 2);
INSERT INTO `articles` VALUES (15, 'Java Concurrency 2', 'Java', 2);
INSERT INTO `articles` VALUES (16, 'Hibernate HQL  2', 'Hibernate', 2);
INSERT INTO `articles` VALUES (17, 'Spring MVC with Hibernate 2', 'Spring', 1);
INSERT INTO `articles` VALUES (18, 'Java Concurrency 3', 'Java', 1);
INSERT INTO `articles` VALUES (19, 'Hibernate HQL  3', 'Hibernate', 2);
INSERT INTO `articles` VALUES (20, 'Spring MVC with Hibernate 3', 'Spring', 2);
INSERT INTO `articles` VALUES (21, 'Java Concurrency 4', 'Java', 2);
INSERT INTO `articles` VALUES (22, 'Hibernate HQL  4', 'Hibernate', 1);
INSERT INTO `articles` VALUES (23, 'Spring MVC with Hibernate 4', 'Spring', 1);
INSERT INTO `articles` VALUES (24, 'Java Concurrency 5', 'Java', 2);
INSERT INTO `articles` VALUES (25, 'Hibernate HQL  5', 'Hibernate', 2);
INSERT INTO `articles` VALUES (26, 'Spring MVC with Hibernate 5', 'Spring', 2);
INSERT INTO `articles` VALUES (27, 'Java Concurrency 6', 'Java', 1);
INSERT INTO `articles` VALUES (28, 'Hibernate HQL  6', 'Hibernate', 1);
INSERT INTO `articles` VALUES (29, 'Spring MVC with Hibernate 6', 'Spring', 2);
INSERT INTO `articles` VALUES (30, 'Java Concurrency 7', 'Java', 2);
INSERT INTO `articles` VALUES (31, 'Hibernate HQL  7', 'Hibernate', 2);
INSERT INTO `articles` VALUES (32, 'Spring MVC with Hibernate 7', 'Spring', 1);
INSERT INTO `articles` VALUES (33, 'Java Concurrency 8', 'Java', 1);
INSERT INTO `articles` VALUES (34, 'Hibernate HQL  8', 'Hibernate', 2);
INSERT INTO `articles` VALUES (35, 'Spring MVC with Hibernate 8', 'Spring', 2);
INSERT INTO `articles` VALUES (36, 'Java Concurrency 9', 'Java', 2);
INSERT INTO `articles` VALUES (37, 'Hibernate HQL  9', 'Hibernate', 1);
INSERT INTO `articles` VALUES (38, 'Spring MVC with Hibernate 9', 'Spring', 1);
INSERT INTO `articles` VALUES (39, 'Java Concurrency 10', 'Java', 2);
INSERT INTO `articles` VALUES (40, 'Hibernate HQL  10', 'Hibernate', 2);
INSERT INTO `articles` VALUES (41, 'Spring MVC with Hibernate 10', 'Spring', 2);
INSERT INTO `articles` VALUES (42, 'Java Concurrency 11', 'Java', 1);
INSERT INTO `articles` VALUES (43, 'Hibernate HQL  11', 'Hibernate', 1);
INSERT INTO `articles` VALUES (44, 'Spring MVC with Hibernate 11', 'Spring', 2);
INSERT INTO `articles` VALUES (45, 'Java Concurrency 12', 'Java', 2);
INSERT INTO `articles` VALUES (46, 'Hibernate HQL  12', 'Hibernate', 2);
INSERT INTO `articles` VALUES (47, 'Spring MVC with Hibernate 12', 'Spring', 1);
INSERT INTO `articles` VALUES (48, 'Java Concurrency 13', 'Java', 1);
INSERT INTO `articles` VALUES (49, 'Hibernate HQL  13', 'Hibernate', 2);
INSERT INTO `articles` VALUES (50, 'Spring MVC with Hibernate 13', 'Spring', 2);
INSERT INTO `articles` VALUES (51, 'Java Concurrency 14', 'Java', 2);
INSERT INTO `articles` VALUES (52, 'Hibernate HQL  14', 'Hibernate', 1);
INSERT INTO `articles` VALUES (53, 'Spring MVC with Hibernate 14', 'Spring', 1);
INSERT INTO `articles` VALUES (54, 'Java Concurrency 15', 'Java', 2);
INSERT INTO `articles` VALUES (55, 'Hibernate HQL  15', 'Hibernate', 2);
INSERT INTO `articles` VALUES (56, 'Spring MVC with Hibernate 15', 'Spring', 2);
INSERT INTO `articles` VALUES (57, 'Java Concurrency 16', 'Java', 1);
INSERT INTO `articles` VALUES (58, 'Hibernate HQL  16', 'Hibernate', 1);
INSERT INTO `articles` VALUES (59, 'Spring MVC with Hibernate 16', 'Spring', 2);
INSERT INTO `articles` VALUES (60, 'Java Concurrency 17', 'Java', 2);
INSERT INTO `articles` VALUES (61, 'Hibernate HQL  17', 'Hibernate', 2);
INSERT INTO `articles` VALUES (62, 'Spring MVC with Hibernate 17', 'Spring', 1);
INSERT INTO `articles` VALUES (63, 'Java Concurrency 18', 'Java', 1);
INSERT INTO `articles` VALUES (64, 'Hibernate HQL  18', 'Hibernate', 2);
INSERT INTO `articles` VALUES (65, 'Spring MVC with Hibernate 18', 'Spring', 2);
INSERT INTO `articles` VALUES (66, 'Java Concurrency 19', 'Java', 2);
INSERT INTO `articles` VALUES (67, 'Hibernate HQL  19', 'Hibernate', 1);
INSERT INTO `articles` VALUES (68, 'Spring MVC with Hibernate 19', 'Spring', 1);
INSERT INTO `articles` VALUES (69, 'Java Concurrency 20', 'Java', 2);
INSERT INTO `articles` VALUES (70, 'Hibernate HQL  20', 'Hibernate', 2);
INSERT INTO `articles` VALUES (71, 'Spring MVC with Hibernate 20', 'Spring', 2);
INSERT INTO `articles` VALUES (72, 'Java Concurrency 21', 'Java', 1);
INSERT INTO `articles` VALUES (73, 'Hibernate HQL  21', 'Hibernate', 1);
INSERT INTO `articles` VALUES (74, 'Spring MVC with Hibernate 21', 'Spring', 2);
INSERT INTO `articles` VALUES (75, 'Java Concurrency 22', 'Java', 2);
INSERT INTO `articles` VALUES (76, 'Hibernate HQL  22', 'Hibernate', 2);
INSERT INTO `articles` VALUES (77, 'Spring MVC with Hibernate 22', 'Spring', 1);
INSERT INTO `articles` VALUES (78, 'Java Concurrency 23', 'Java', 1);
INSERT INTO `articles` VALUES (79, 'Hibernate HQL  23', 'Hibernate', 2);
INSERT INTO `articles` VALUES (80, 'Spring MVC with Hibernate 23', 'Spring', 2);
INSERT INTO `articles` VALUES (81, 'Java Concurrency 24', 'Java', 2);
INSERT INTO `articles` VALUES (82, 'Hibernate HQL  24', 'Hibernate', 1);
INSERT INTO `articles` VALUES (83, 'Spring MVC with Hibernate 24', 'Spring', 1);
INSERT INTO `articles` VALUES (84, 'Java Concurrency 25', 'Java', 2);
INSERT INTO `articles` VALUES (85, 'Hibernate HQL  25', 'Hibernate', 2);
INSERT INTO `articles` VALUES (86, 'Spring MVC with Hibernate 25', 'Spring', 2);
INSERT INTO `articles` VALUES (87, 'Java Concurrency 26', 'Java', 1);
INSERT INTO `articles` VALUES (88, 'Hibernate HQL  26', 'Hibernate', 1);
INSERT INTO `articles` VALUES (89, 'Spring MVC with Hibernate 26', 'Spring', 2);
INSERT INTO `articles` VALUES (90, 'Java Concurrency 27', 'Java', 2);
INSERT INTO `articles` VALUES (91, 'Hibernate HQL  27', 'Hibernate', 2);
INSERT INTO `articles` VALUES (92, 'Spring MVC with Hibernate 27', 'Spring', 1);
INSERT INTO `articles` VALUES (93, 'Java Concurrency 28', 'Java', 1);
INSERT INTO `articles` VALUES (94, 'Hibernate HQL  28', 'Hibernate', 2);
INSERT INTO `articles` VALUES (95, 'Spring MVC with Hibernate 28', 'Spring', 2);
INSERT INTO `articles` VALUES (96, 'Java Concurrency 29', 'Java', 2);
INSERT INTO `articles` VALUES (97, 'Hibernate HQL  29', 'Hibernate', 1);
INSERT INTO `articles` VALUES (98, 'Spring MVC with Hibernate 29', 'Spring', 1);
INSERT INTO `articles` VALUES (99, 'Java Concurrency 30', 'Java', 2);
INSERT INTO `articles` VALUES (100, 'Hibernate HQL  30', 'Hibernate', 2);
INSERT INTO `articles` VALUES (101, 'Spring MVC with Hibernate 30', 'Spring', 2);
INSERT INTO `articles` VALUES (102, 'Java Concurrency 31', 'Java', 1);
INSERT INTO `articles` VALUES (103, 'Hibernate HQL  31', 'Hibernate', 1);
INSERT INTO `articles` VALUES (104, 'Spring MVC with Hibernate 31', 'Spring', 2);
INSERT INTO `articles` VALUES (105, 'Java Concurrency 32', 'Java', 2);
INSERT INTO `articles` VALUES (106, 'Hibernate HQL  32', 'Hibernate', 2);
INSERT INTO `articles` VALUES (107, 'Spring MVC with Hibernate 32', 'Spring', 1);
INSERT INTO `articles` VALUES (108, 'Java Concurrency 33', 'Java', 1);
INSERT INTO `articles` VALUES (109, 'Hibernate HQL  33', 'Hibernate', 2);
INSERT INTO `articles` VALUES (110, 'Spring MVC with Hibernate 33', 'Spring', 2);
INSERT INTO `articles` VALUES (111, 'Java Concurrency 34', 'Java', 2);
INSERT INTO `articles` VALUES (112, 'Hibernate HQL  34', 'Hibernate', 1);
INSERT INTO `articles` VALUES (113, 'Spring MVC with Hibernate 34', 'Spring', 1);
INSERT INTO `articles` VALUES (114, 'Java Concurrency 35', 'Java', 2);
INSERT INTO `articles` VALUES (115, 'Hibernate HQL  35', 'Hibernate', 2);
INSERT INTO `articles` VALUES (116, 'Spring MVC with Hibernate 35', 'Spring', 2);
INSERT INTO `articles` VALUES (117, 'Java Concurrency 36', 'Java', 1);
INSERT INTO `articles` VALUES (118, 'Hibernate HQL  36', 'Hibernate', 1);
INSERT INTO `articles` VALUES (119, 'Spring MVC with Hibernate 36', 'Spring', 2);
INSERT INTO `articles` VALUES (120, 'Java Concurrency 37', 'Java', 2);

-- ----------------------------
-- Table structure for bank_account
-- ----------------------------
DROP TABLE IF EXISTS `bank_account`;
CREATE TABLE `bank_account`  (
  `ID` bigint(20) NOT NULL,
  `FULL_NAME` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `BALANCE` double NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bank_account
-- ----------------------------
INSERT INTO `bank_account` VALUES (1, 'Tom', 1000);
INSERT INTO `bank_account` VALUES (2, 'Jerry', 2000);
INSERT INTO `bank_account` VALUES (3, 'Donald', 3000);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(8) NOT NULL,
  `user_id` int(8) NOT NULL,
  `article_id` int(8) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk1`(`user_id`) USING BTREE,
  INDEX `fk2`(`article_id`) USING BTREE,
  CONSTRAINT `fk1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk2` FOREIGN KEY (`article_id`) REFERENCES `articles` (`article_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, 1, 'abc');
INSERT INTO `comment` VALUES (2, 1, 2, 'bcs');

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_UNIQUE`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES (21, 'Contact 1', 'contact1@email.com', '(111) 111-1111');
INSERT INTO `contact` VALUES (22, 'Contact 2', 'contact2@email.com', '(111) 111-1111');
INSERT INTO `contact` VALUES (23, 'Contact 3', 'contact3@email.com', '(111) 111-1111');
INSERT INTO `contact` VALUES (24, 'Contact 4', 'contact4@email.com', '(111) 111-1111');
INSERT INTO `contact` VALUES (25, 'Contact 5', 'contact5@email.com', '(111) 111-1111');
INSERT INTO `contact` VALUES (26, 'Contact 6', 'contact6@email.com', '(111) 111-1111');
INSERT INTO `contact` VALUES (27, 'Contact 7', 'contact7@email.com', '(111) 111-1111');
INSERT INTO `contact` VALUES (28, 'Contact 8', 'contact8@email.com', '(111) 111-1111');
INSERT INTO `contact` VALUES (29, 'Contact 9', 'contact9@email.com', '(111) 111-1111');
INSERT INTO `contact` VALUES (30, 'Contact 10', 'contact10@email.com', '(111) 111-1111');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int(3) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Tu', 16);
INSERT INTO `user` VALUES (2, 'Tua', 17);

SET FOREIGN_KEY_CHECKS = 1;
