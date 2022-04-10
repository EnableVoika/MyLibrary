/*
 Navicat Premium Data Transfer

 Source Server         : ETMysql
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : evemovieghy

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 31/12/2021 18:12:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for movies
-- ----------------------------
DROP TABLE IF EXISTS `movies`;
CREATE TABLE `movies`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `direct` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `protagonist` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `region` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `language` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `release_date_str` datetime(0) NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movies
-- ----------------------------
INSERT INTO `movies` VALUES (1, '无双', '庄文强', '周润发/郭富城/张静初/冯文娟', '剧情/犯罪/动作/悬疑/', '中国大陆/中国香港', '汉语普通话/粤语/英语/吐火罗语', '2018-09-30 00:00:00', '上架', 1, 'http://localhost:8080/ks/files/c59289088dc5446ea6a6d4985e35b288.jpg/');
INSERT INTO `movies` VALUES (2, '天下有贼', '郭德纲', '张学友/刘德华/葛优', '剧情/动作/悬疑/犯罪', '中国大陆/中国香港', '汉语普通话/粤语/英语', '2019-07-27 00:00:00', '上架', 1, 'http://localhost:8080/ks/files/c59289088dc5446ea6a6d4985e35b288.jpg/');
INSERT INTO `movies` VALUES (3, 'safasd', '他', '我', '犯罪/剧情/动作/', 'asfasdfa', 'sfasd', '2021-12-14 00:00:00', '上架', 1, 'http://localhost:8080/ks//files/5734b2cd94984f8393a2ec8112dda8ce.jpg');
INSERT INTO `movies` VALUES (4, '哎呦我烤', '德玛西亚', '老蒋/老毛/老周', '犯罪/剧情/动作/', '中国大陆', '吐火罗', '2021-12-14 00:00:00', '上架', 1, 'http://localhost:8080/ks//files/5734b2cd94984f8393a2ec8112dda8ce.jpg');
INSERT INTO `movies` VALUES (5, '破局', '王宝强', '5v/林正英/希乐', '剧情/犯罪/动作/悬疑/', '中国大陆/中国香港', '汉语普通话/粤语/英语', '2018-09-30 00:00:00', '上架', 1, 'http://localhost:8080/ks//files/da185a00a5cd417780a5c8b3b8492f42.jpg');
INSERT INTO `movies` VALUES (6, 'sdafergebe', 'dfgbdrthrtvwaeew', 'dqwfgrt', '犯罪/剧情/动作/动画/奇幻/', 'hberberbr', 'vwevtrehrtjyt', '2021-12-08 00:00:00', '上架', 1, 'http://localhost:8080/ks//files/3bd3096ed4fd4b2fb9a30ad7f5fc8e97.jpg');
INSERT INTO `movies` VALUES (7, '21314123412', 'asdfasd', 'safads', '犯罪/剧情/动作/动画/奇幻/悬疑/', 'facas', 'cdasfdafsdfa', '2021-12-08 00:00:00', '上架', 1, 'http://localhost:8080/ks//files/14ac534276f840cfa476ed59e5a8b375.jpg');
INSERT INTO `movies` VALUES (8, 'f f', '2131', 'd', '剧情/', 'e', 'w', '2021-12-27 00:00:00', '上架', 1, 'http://localhost:8080/ks//files/36c71272a05d47b1beb020d676f0f157.jpg');
INSERT INTO `movies` VALUES (9, 'sss', 'ss', 'ds', '剧情/动作/', 'ds', 'dds', '2021-12-27 00:00:00', '上架', 1, 'http://localhost:8080/ks//files/01a4eb159e8a47799d573b0ad078821c.jpg');
INSERT INTO `movies` VALUES (10, 'd13', 'we', 'e', '剧情/动作/悬疑/犯罪/', 'e', 'e', '2021-12-22 00:00:00', '上架', 1, 'http://localhost:8080/ks//files/59e409967330463e98fba45eefee1f90.jpg');
INSERT INTO `movies` VALUES (11, 'sadfa', '上的分歧无法完全', '2', '剧情/', '2', '2', '2021-12-28 00:00:00', '上架', 1, 'http://localhost:8080/ks//files/5e6209fb2dd8422d838cce9ef0360d9c.jpg');
INSERT INTO `movies` VALUES (12, '123', '321', '123', '剧情/惊悚/奇幻/悬疑/动作/动画/犯罪/', '321', '123', '2021-12-21 00:00:00', '上架', 1, 'http://localhost:8080/ks//files/9a67379f709248dfad67e7e9a0a800e4.jpg');
INSERT INTO `movies` VALUES (13, '心理罪：原罪', '邓超', '邓超/蒋中正/', '', '西班牙', '甲骨文', '2021-12-08 00:00:00', '上架', 1, 'http://localhost:8080/ks//files/afc6618d3a3f41399071d7627883f32f.jpg');

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `mid` int(0) NULL DEFAULT NULL COMMENT '电影id',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `ftime_str` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userid`(`user_id`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE,
  CONSTRAINT `userid` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `mid` FOREIGN KEY (`mid`) REFERENCES `movies` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES (1, 1, 1, '2021-12-16 14:31:15', '哎呦我了个去');
INSERT INTO `review` VALUES (2, 2, 2, '2000-06-22 14:54:04', '不错不错');
INSERT INTO `review` VALUES (3, 2, 1, '2021-12-31 15:26:50', 'fsdafewfw');
INSERT INTO `review` VALUES (4, 2, 1, '2021-12-31 15:27:34', 'fasdewfwqa');
INSERT INTO `review` VALUES (5, 2, 1, '2021-12-31 15:27:55', 'frewvsewvee');
INSERT INTO `review` VALUES (6, 2, 1, '2021-12-31 15:29:06', 'fwefw3egwegwerg');
INSERT INTO `review` VALUES (7, 2, 1, '2021-12-31 15:29:59', 'erwfwegewgwefew');
INSERT INTO `review` VALUES (8, 2, 1, '2021-12-31 15:30:53', 'fasdfasfewf');
INSERT INTO `review` VALUES (9, 2, 1, '2021-12-31 15:33:21', 'sdagretgews');
INSERT INTO `review` VALUES (10, 1, 1, '2021-12-31 15:33:26', '');
INSERT INTO `review` VALUES (11, 1, 1, '2021-12-31 15:33:30', 'sdfgasga');
INSERT INTO `review` VALUES (12, 3, 1, '2021-12-31 15:33:37', 'dqwfqwefw');
INSERT INTO `review` VALUES (13, 1, 2, '2021-12-31 15:44:40', 'fwefwfafweqadd');
INSERT INTO `review` VALUES (14, 2, 2, '2021-12-31 16:00:22', 'asdgsrtegfgerfgvdgsdv ');
INSERT INTO `review` VALUES (15, 1, 1, '2021-12-31 17:05:01', 'vsafas');
INSERT INTO `review` VALUES (16, 1, 1, '2021-12-31 17:14:58', 'dwe');
INSERT INTO `review` VALUES (17, 1, 1, '2021-12-31 17:15:18', 'asda');
INSERT INTO `review` VALUES (18, 1, 1, '2021-12-31 17:15:21', 'asfasd');
INSERT INTO `review` VALUES (19, 1, 1, '2021-12-31 17:15:26', 'sdwedw');
INSERT INTO `review` VALUES (20, 1, 1, '2021-12-31 17:15:33', 'sdwedw');
INSERT INTO `review` VALUES (21, 1, 1, '2021-12-31 17:15:49', '41234231421423');
INSERT INTO `review` VALUES (22, 1, 1, '2021-12-31 17:15:59', '41234231421423');
INSERT INTO `review` VALUES (23, 1, 1, '2021-12-31 17:16:39', 'efwqre');
INSERT INTO `review` VALUES (24, 1, 1, '2021-12-31 17:17:29', 'sdqwdq');
INSERT INTO `review` VALUES (25, 1, 1, '2021-12-31 17:35:10', '');
INSERT INTO `review` VALUES (26, 1, 1, '2021-12-31 17:35:42', 'fr');
INSERT INTO `review` VALUES (27, 1, 1, '2021-12-31 17:35:43', '');
INSERT INTO `review` VALUES (28, 3, 1, '2021-12-31 17:41:28', '发生发生');
INSERT INTO `review` VALUES (29, 13, 2, '2021-12-31 18:05:43', '卧槽，这个好看');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `index_unique_name`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'qwe', 'qwe', 0);
INSERT INTO `t_user` VALUES (2, 'user', '123', 1);
INSERT INTO `t_user` VALUES (4, 'xxx', 'e10adc3949ba59abbe56e057f20f883e', NULL);
INSERT INTO `t_user` VALUES (11, 'gdfgsdg', 'e10adc3949ba59abbe56e057f20f883e', NULL);
INSERT INTO `t_user` VALUES (12, 'å¼ ä¸feng', 'e10adc3949ba59abbe56e057f20f883e', NULL);
INSERT INTO `t_user` VALUES (13, 'vb dhsfrg yuidsg uyiades', 'e10adc3949ba59abbe56e057f20f883e', NULL);
INSERT INTO `t_user` VALUES (14, 'vbdhades', 'e10adc3949ba59abbe56e057f20f883e', NULL);
INSERT INTO `t_user` VALUES (16, 'vbdh', 'e10adc3949ba59abbe56e057f20f883e', NULL);
INSERT INTO `t_user` VALUES (17, 'vb48944685h', 'e10adc3949ba59abbe56e057f20f883e', NULL);
INSERT INTO `t_user` VALUES (19, 'zqsl', 'e10adc3949ba59abbe56e057f20f883e', NULL);
INSERT INTO `t_user` VALUES (24, 'z21314', 'e10adc3949ba59abbe56e057f20f883e', NULL);
INSERT INTO `t_user` VALUES (25, 'zwzw', '202cb962ac59075b964b07152d234b70', NULL);
INSERT INTO `t_user` VALUES (26, 'fccw', '202cb962ac59075b964b07152d234b70', NULL);
INSERT INTO `t_user` VALUES (30, 'jshy', '202cb962ac59075b964b07152d234b70', NULL);
INSERT INTO `t_user` VALUES (31, 'wokao', NULL, NULL);
INSERT INTO `t_user` VALUES (32, 'zs', 'e10adc3949ba59abbe56e057f20f883e', NULL);
INSERT INTO `t_user` VALUES (34, '9527', NULL, NULL);
INSERT INTO `t_user` VALUES (35, '8526', NULL, NULL);
INSERT INTO `t_user` VALUES (36, '5555', NULL, NULL);
INSERT INTO `t_user` VALUES (37, '86555919', NULL, NULL);
INSERT INTO `t_user` VALUES (39, '563165456', NULL, NULL);
INSERT INTO `t_user` VALUES (40, 'dsadaa', NULL, NULL);
INSERT INTO `t_user` VALUES (41, '123433wef', NULL, NULL);
INSERT INTO `t_user` VALUES (43, 'zs2222', NULL, NULL);
INSERT INTO `t_user` VALUES (44, 'w8gz', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
