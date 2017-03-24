/*
Navicat MySQL Data Transfer

Source Server         : 192.168.30.3_test
Source Server Version : 50634
Source Host           : 192.168.30.3:3306
Source Database       : ddd

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-02-14 11:53:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_ddddemo_user_account
-- ----------------------------
DROP TABLE IF EXISTS `tb_ddddemo_user_account`;
CREATE TABLE `tb_ddddemo_user_account` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `CONCURRENCY_VERSION` int(11) DEFAULT NULL COMMENT '并发版本号',
  `ACCOUNT_ID` varchar(32) DEFAULT NULL,
  `USER_NAME` varchar(255) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `LOGIN_NUM` int(11) DEFAULT NULL,
  `CREATE_TIME` timestamp NULL DEFAULT NULL,
  `MODIFY_TIME` timestamp NULL DEFAULT NULL,
  `PROVINCE` varchar(50) DEFAULT NULL,
  `CITY` varchar(50) DEFAULT NULL,
  `AREA` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ddddemo_user_account
-- ----------------------------
