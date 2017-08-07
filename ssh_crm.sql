/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50045
Source Host           : localhost:3306
Source Database       : ssh_crm

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2017-08-07 21:34:59
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_customer`
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `cid` int(11) NOT NULL auto_increment,
  `custName` varchar(255) default NULL,
  `custSource` varchar(255) default NULL,
  `custLinkman` varchar(255) default NULL,
  `custPhone` varchar(255) default NULL,
  `custMobile` varchar(255) default NULL,
  `custAddress` varchar(255) default NULL,
  `custZip` varchar(255) default NULL,
  `custFax` varchar(255) default NULL,
  `custWebsite` varchar(255) default NULL,
  `cdid` varchar(255) default NULL,
  PRIMARY KEY  (`cid`),
  KEY `FK7oxubiqfhi4qtg5wy8pbc3rt2` (`cdid`),
  CONSTRAINT `FK7oxubiqfhi4qtg5wy8pbc3rt2` FOREIGN KEY (`cdid`) REFERENCES `t_dict` (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO t_customer VALUES ('1', '阿里巴巴', '网络', '', '110', '111', '', '', '', '', '1');
INSERT INTO t_customer VALUES ('3', '百度', '报纸', '', '22211', '333311', '', '', '', '', '2');
INSERT INTO t_customer VALUES ('4', '小米', '电视', null, '123', '3231', null, null, null, null, '3');
INSERT INTO t_customer VALUES ('5', '华为', '电视', null, '8888', '6666', null, null, null, null, '3');
INSERT INTO t_customer VALUES ('6', '360', '网络', null, '6969', '798', null, null, null, null, '2');
INSERT INTO t_customer VALUES ('7', '新浪', '报纸', null, '6556', '8531', null, null, null, null, '1');
INSERT INTO t_customer VALUES ('8', '搜狐', '网络', null, '1111', '000', null, null, null, null, '1');
INSERT INTO t_customer VALUES ('9', '123', '网络', '33', '11', '22', '', '', '', '', '2');

-- ----------------------------
-- Table structure for `t_dict`
-- ----------------------------
DROP TABLE IF EXISTS `t_dict`;
CREATE TABLE `t_dict` (
  `did` varchar(255) NOT NULL,
  `dictName` varchar(255) default NULL,
  PRIMARY KEY  (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dict
-- ----------------------------
INSERT INTO t_dict VALUES ('1', 'VIP客户');
INSERT INTO t_dict VALUES ('2', '普通客户');
INSERT INTO t_dict VALUES ('3', '超级客户');

-- ----------------------------
-- Table structure for `t_linkman`
-- ----------------------------
DROP TABLE IF EXISTS `t_linkman`;
CREATE TABLE `t_linkman` (
  `lid` int(11) NOT NULL auto_increment,
  `lkmName` varchar(255) default NULL,
  `lkmGender` varchar(255) default NULL,
  `lkmPhone` varchar(255) default NULL,
  `lkmMobile` varchar(255) default NULL,
  `clid` int(11) default NULL,
  PRIMARY KEY  (`lid`),
  KEY `FKjtgu0oocf35ij4fmulu123vwk` (`clid`),
  CONSTRAINT `FKjtgu0oocf35ij4fmulu123vwk` FOREIGN KEY (`clid`) REFERENCES `t_customer` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_linkman
-- ----------------------------
INSERT INTO t_linkman VALUES ('2', '小李', '1', '1', '1', '4');
INSERT INTO t_linkman VALUES ('3', '3', '1', '3', '3', '3');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `did` int(11) NOT NULL auto_increment,
  `userName` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  PRIMARY KEY  (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO t_user VALUES ('1', 'lz', '123', '洛阳');
INSERT INTO t_user VALUES ('2', '11', '123', '北京');
INSERT INTO t_user VALUES ('3', '22', '123', '上海');
INSERT INTO t_user VALUES ('4', '33', '123', '广州');

-- ----------------------------
-- Table structure for `t_visit`
-- ----------------------------
DROP TABLE IF EXISTS `t_visit`;
CREATE TABLE `t_visit` (
  `vid` int(11) NOT NULL auto_increment,
  `vaddress` varchar(255) default NULL,
  `vcontent` varchar(255) default NULL,
  `uvid` int(11) default NULL,
  `cvid` int(11) default NULL,
  PRIMARY KEY  (`vid`),
  KEY `FKnbsiiqbdcpvtugygwe4vj42s0` (`uvid`),
  KEY `FKfq1vs5t876wufr6l5tctnopps` (`cvid`),
  CONSTRAINT `FKfq1vs5t876wufr6l5tctnopps` FOREIGN KEY (`cvid`) REFERENCES `t_customer` (`cid`),
  CONSTRAINT `FKnbsiiqbdcpvtugygwe4vj42s0` FOREIGN KEY (`uvid`) REFERENCES `t_user` (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_visit
-- ----------------------------
INSERT INTO t_visit VALUES ('1', '中国', '工作', '1', '4');
