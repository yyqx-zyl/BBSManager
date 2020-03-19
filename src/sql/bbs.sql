/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.22-log : Database - bbsdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bbsdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bbsdb`;

/*Table structure for table `bbs_category` */

DROP TABLE IF EXISTS `bbs_category`;

CREATE TABLE `bbs_category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `category` varchar(32) NOT NULL COMMENT '分类名',
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `bbs_category` */

insert  into `bbs_category`(`categoryId`,`category`) values (1,'收到回复还是对符合'),(2,'的发生大幅度'),(3,'第三方'),(4,' 发的'),(5,'广东省法规'),(6,'广大东方'),(7,'的富商大贾');

/*Table structure for table `bbs_follow` */

DROP TABLE IF EXISTS `bbs_follow`;

CREATE TABLE `bbs_follow` (
  `userId` varchar(32) NOT NULL COMMENT '关注者',
  `bUserId` varchar(32) NOT NULL COMMENT '被关注者',
  `followDate` datetime DEFAULT NULL COMMENT '关注的日期时间',
  PRIMARY KEY (`userId`,`bUserId`),
  KEY `bUserId` (`bUserId`),
  CONSTRAINT `bbs_follow_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `bbs_user` (`userId`),
  CONSTRAINT `bbs_follow_ibfk_2` FOREIGN KEY (`bUserId`) REFERENCES `bbs_user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bbs_follow` */

/*Table structure for table `bbs_invitation` */

DROP TABLE IF EXISTS `bbs_invitation`;

CREATE TABLE `bbs_invitation` (
  `invitationId` varchar(128) NOT NULL COMMENT '用户账户+系统日期时间(到秒)',
  `invitationMessage` varchar(2048) NOT NULL COMMENT '帖子信息',
  `userId` varchar(32) NOT NULL COMMENT '发帖用户ID',
  `plateId` int(11) NOT NULL COMMENT '所属板块',
  `categoryId` int(11) NOT NULL COMMENT '帖子分类',
  `isPass` int(11) NOT NULL DEFAULT '0' COMMENT '审核状态',
  `isEnable` int(11) NOT NULL DEFAULT '0' COMMENT '帖子是否被屏蔽',
  `isCream` int(11) NOT NULL DEFAULT '0' COMMENT '是否是精华帖',
  `invitationCreate` datetime DEFAULT NULL COMMENT '帖子发布时间',
  `invitationModify` datetime DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`invitationId`),
  KEY `userId` (`userId`),
  KEY `plateId` (`plateId`),
  KEY `categoryId` (`categoryId`),
  CONSTRAINT `bbs_invitation_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `bbs_user` (`userId`),
  CONSTRAINT `bbs_invitation_ibfk_2` FOREIGN KEY (`plateId`) REFERENCES `bbs_plate` (`plateId`),
  CONSTRAINT `bbs_invitation_ibfk_3` FOREIGN KEY (`categoryId`) REFERENCES `bbs_category` (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bbs_invitation` */

insert  into `bbs_invitation`(`invitationId`,`invitationMessage`,`userId`,`plateId`,`categoryId`,`isPass`,`isEnable`,`isCream`,`invitationCreate`,`invitationModify`) values ('1231232020-03-19 10:03:15','绝代风华赛迪是电脑','123123',3,2,0,0,0,'2020-03-19 11:33:20','2020-03-20 11:33:53'),('1231232020-03-19 11:38:57','尽快哈丝黛芬妮','123123',5,3,0,0,0,NULL,NULL),('于朦胧1550','vvugi','于朦胧',4,4,0,0,0,'2020-03-17 15:50:04','2020-03-20 11:33:59'),('喝点水发货','撒打发斯蒂芬','123123',2,3,0,0,0,'2020-03-14 11:33:23','2020-03-20 11:34:03');

/*Table structure for table `bbs_invitation_ans` */

DROP TABLE IF EXISTS `bbs_invitation_ans`;

CREATE TABLE `bbs_invitation_ans` (
  `ansId` varchar(128) NOT NULL COMMENT '对应的帖子ID_回复此贴账户_日期到秒',
  `ansMessage` varchar(512) NOT NULL COMMENT '回复的内容',
  `invitationId` varchar(128) NOT NULL COMMENT '回复的帖子',
  `userId` varchar(32) DEFAULT NULL COMMENT '回复的账户',
  `ansDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '回复的日期时间',
  KEY `invitationId` (`invitationId`),
  KEY `userId` (`userId`),
  CONSTRAINT `bbs_invitation_ans_ibfk_1` FOREIGN KEY (`invitationId`) REFERENCES `bbs_invitation` (`invitationId`),
  CONSTRAINT `bbs_invitation_ans_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `bbs_user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bbs_invitation_ans` */

/*Table structure for table `bbs_level` */

DROP TABLE IF EXISTS `bbs_level`;

CREATE TABLE `bbs_level` (
  `levelId` int(11) NOT NULL AUTO_INCREMENT,
  `levelMessage` varchar(8) NOT NULL,
  PRIMARY KEY (`levelId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `bbs_level` */

insert  into `bbs_level`(`levelId`,`levelMessage`) values (1,'初级会员'),(2,'中级会员'),(3,'高级会员');

/*Table structure for table `bbs_plate` */

DROP TABLE IF EXISTS `bbs_plate`;

CREATE TABLE `bbs_plate` (
  `plateId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `plateTitle` varchar(32) NOT NULL COMMENT '板块标题',
  `plateMessage` varchar(128) DEFAULT NULL COMMENT '板块描述',
  `isEnable` int(11) DEFAULT NULL COMMENT '板块是否被屏蔽',
  PRIMARY KEY (`plateId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `bbs_plate` */

insert  into `bbs_plate`(`plateId`,`plateTitle`,`plateMessage`,`isEnable`) values (2,'国际','国际信息',0),(3,'国内','国内信息',0),(4,'娱乐','娱乐新闻',0),(5,'军事','军事信息',0),(9,'农业','农业',0);

/*Table structure for table `bbs_store` */

DROP TABLE IF EXISTS `bbs_store`;

CREATE TABLE `bbs_store` (
  `userId` varchar(32) NOT NULL COMMENT '与invitationId构成联合主键',
  `invitationId` varchar(128) NOT NULL,
  `storeDate` datetime DEFAULT NULL COMMENT '收藏日期时间',
  PRIMARY KEY (`userId`,`invitationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bbs_store` */

/*Table structure for table `bbs_system_ans` */

DROP TABLE IF EXISTS `bbs_system_ans`;

CREATE TABLE `bbs_system_ans` (
  `systemId` varchar(128) NOT NULL COMMENT '采用Java的UUID自动生成',
  `userId` varchar(32) DEFAULT NULL COMMENT '接收此信息的账户id',
  `message` varchar(255) NOT NULL COMMENT '发送的消息信息',
  `isRead` int(11) DEFAULT '0' COMMENT '是否已读',
  `createDate` datetime DEFAULT NULL COMMENT '消息创建时间',
  PRIMARY KEY (`systemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bbs_system_ans` */

/*Table structure for table `bbs_user` */

DROP TABLE IF EXISTS `bbs_user`;

CREATE TABLE `bbs_user` (
  `userId` varchar(32) NOT NULL COMMENT '账户名',
  `userPsw` varchar(32) NOT NULL COMMENT '密码',
  `userEmail` varchar(64) NOT NULL COMMENT '邮箱',
  `userSex` varchar(1) DEFAULT '男' COMMENT '性别',
  `userPhoto` varchar(32) DEFAULT NULL COMMENT '头像',
  `userScore` double NOT NULL DEFAULT '0' COMMENT '积分',
  `userLevel` int(11) NOT NULL DEFAULT '1' COMMENT '等级',
  `levelDown` date DEFAULT NULL COMMENT '降级截止日期',
  `userLock` date DEFAULT NULL COMMENT '锁定截止日期',
  `userCreateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`userId`),
  KEY `userLevel` (`userLevel`),
  CONSTRAINT `bbs_user_ibfk_1` FOREIGN KEY (`userLevel`) REFERENCES `bbs_level` (`levelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bbs_user` */

insert  into `bbs_user`(`userId`,`userPsw`,`userEmail`,`userSex`,`userPhoto`,`userScore`,`userLevel`,`levelDown`,`userLock`,`userCreateDate`) values ('123123','123123','123@qq.com','男','10.jpg',0,1,NULL,NULL,'2020-03-16 12:08:30'),('789789','789789','111@163.com','男','图05.jpg',0,1,NULL,NULL,'2020-03-13 23:31:25'),('vsdfg','fddf','asda@qq.com','男',NULL,0,1,NULL,NULL,'2020-03-16 12:06:33'),('于朦胧','7788','7788@163.com','男','图05.jpg',0,1,'2020-03-15',NULL,'2020-03-16 10:51:42'),('易烊千玺','1128','yyqx@163.com','男',NULL,0,2,NULL,NULL,'2020-03-09 16:37:34'),('朱一龙','0416','zyl@163.com','男',NULL,0,3,NULL,NULL,'2020-03-09 16:36:32');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
