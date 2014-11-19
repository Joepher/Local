-- MySQL dump 10.13  Distrib 5.6.15, for Win64 (x86_64)
--
-- Host: localhost    Database: weibo
-- ------------------------------------------------------
-- Server version	5.6.15-enterprise-commercial-advanced-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `atme`
--

DROP TABLE IF EXISTS `atme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atme` (
  `amId` int(11) NOT NULL AUTO_INCREMENT,
  `atWho` varchar(12) NOT NULL,
  `profId` int(11) DEFAULT NULL,
  `comId` int(11) DEFAULT NULL,
  PRIMARY KEY (`amId`),
  KEY `FK_Reference_8` (`profId`),
  KEY `FK_Reference_9` (`comId`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`profId`) REFERENCES `profile` (`profId`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`comId`) REFERENCES `comment` (`comId`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atme`
--

LOCK TABLES `atme` WRITE;
/*!40000 ALTER TABLE `atme` DISABLE KEYS */;
INSERT INTO `atme` VALUES (158,'Joepher',208,NULL);
/*!40000 ALTER TABLE `atme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `comId` int(11) NOT NULL AUTO_INCREMENT,
  `profId` int(11) NOT NULL,
  `comTime` datetime NOT NULL,
  `comFrom` int(11) NOT NULL,
  `comContent` varchar(140) NOT NULL,
  `comComId` int(11) DEFAULT NULL,
  PRIMARY KEY (`comId`),
  KEY `FK_Reference_4` (`profId`),
  KEY `FK_Reference_5` (`comFrom`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`profId`) REFERENCES `profile` (`profId`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`comFrom`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (248,206,'2013-12-29 11:01:13',38,'随便起来不是人[哈哈]',0),(249,208,'2013-12-29 11:06:08',37,'[花心]必须的，搞起啊',0),(250,209,'2013-12-29 11:09:28',37,'[懒得理你]可耻',0);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `count`
--

DROP TABLE IF EXISTS `count`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `count` (
  `userId` int(11) NOT NULL,
  `fansCount` bigint(20) NOT NULL,
  `msgCount` bigint(20) NOT NULL,
  `atProfileCount` bigint(20) NOT NULL,
  `atCommentCount` bigint(20) NOT NULL,
  `noticeCount` bigint(20) NOT NULL,
  `commentCount` bigint(20) NOT NULL,
  PRIMARY KEY (`userId`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `count`
--

LOCK TABLES `count` WRITE;
/*!40000 ALTER TABLE `count` DISABLE KEYS */;
INSERT INTO `count` VALUES (37,6,2,1,0,2,0),(38,6,0,0,0,2,1),(39,6,0,0,0,2,0),(40,6,1,0,0,2,1),(41,6,3,0,0,2,1),(42,6,0,0,0,2,0),(43,0,0,0,0,1,0),(44,0,0,0,0,1,0),(45,0,0,0,0,1,0);
/*!40000 ALTER TABLE `count` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fans_manage`
--

DROP TABLE IF EXISTS `fans_manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fans_manage` (
  `fmId` int(11) NOT NULL AUTO_INCREMENT,
  `fansId` int(11) NOT NULL,
  `followId` int(11) NOT NULL,
  `groupId` int(11) NOT NULL,
  PRIMARY KEY (`fmId`)
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fans_manage`
--

LOCK TABLES `fans_manage` WRITE;
/*!40000 ALTER TABLE `fans_manage` DISABLE KEYS */;
INSERT INTO `fans_manage` VALUES (217,41,37,0),(218,42,37,0),(219,40,37,0),(220,39,37,0),(221,38,37,0),(222,37,38,0),(224,37,40,0),(225,37,42,0),(226,37,41,0),(227,37,39,0),(228,42,38,0),(229,42,39,0),(230,42,40,0),(231,42,41,0),(232,40,42,0),(233,40,38,0),(234,40,39,0),(235,40,41,0),(236,39,38,0),(237,39,40,0),(238,39,41,0),(239,39,42,0),(240,41,39,0),(241,41,40,0),(242,41,42,0),(243,41,38,0),(244,38,41,0),(245,38,39,0),(246,38,40,0),(247,38,42,0),(254,43,37,0),(255,43,38,0),(256,43,39,0),(257,43,40,0),(258,43,41,0),(259,43,42,0),(260,37,43,0);
/*!40000 ALTER TABLE `fans_manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follow_group`
--

DROP TABLE IF EXISTS `follow_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `follow_group` (
  `groupId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `groupName` varchar(1000) NOT NULL,
  PRIMARY KEY (`groupId`),
  KEY `FK_Reference_3` (`userId`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow_group`
--

LOCK TABLES `follow_group` WRITE;
/*!40000 ALTER TABLE `follow_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `follow_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `loginName` varchar(12) NOT NULL,
  `password` varchar(12) NOT NULL,
  `loginType` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`loginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('admin','admin',1),('baiyandong','123456',0),('feizhenkun','19900327',0),('Joepher','154844799',0),('lanxianyun','123456',0),('likeqiang','123456',0),('xiaowen_z','123456',0),('xidada','123456',0),('yangxin','123456',0),('zhuoxiaoyan','123456',0);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `msg_notice`
--

DROP TABLE IF EXISTS `msg_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `msg_notice` (
  `msgId` int(11) NOT NULL AUTO_INCREMENT,
  `msgTime` datetime NOT NULL,
  `msgFrom` int(11) NOT NULL,
  `msgTo` int(11) NOT NULL,
  `msgContent` varchar(500) NOT NULL,
  `msgType` tinyint(4) NOT NULL,
  `msgRead` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`msgId`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msg_notice`
--

LOCK TABLES `msg_notice` WRITE;
/*!40000 ALTER TABLE `msg_notice` DISABLE KEYS */;
INSERT INTO `msg_notice` VALUES (105,'2013-12-28 21:51:16',0,37,'欢迎您加入我们的微博大家庭，祝您越V越开心，越V越漂亮',5,1),(106,'2013-12-28 21:52:08',0,38,'欢迎您加入我们的微博大家庭，祝您越V越开心，越V越漂亮',5,1),(107,'2013-12-28 21:53:27',0,39,'欢迎您加入我们的微博大家庭，祝您越V越开心，越V越漂亮',5,1),(108,'2013-12-28 21:54:45',0,40,'欢迎您加入我们的微博大家庭，祝您越V越开心，越V越漂亮',5,1),(109,'2013-12-28 21:55:57',0,41,'欢迎您加入我们的微博大家庭，祝您越V越开心，越V越漂亮',5,1),(110,'2013-12-28 21:56:56',0,42,'欢迎您加入我们的微博大家庭，祝您越V越开心，越V越漂亮',5,1),(111,'2013-12-28 21:58:13',41,37,'我就是传说中的蓝大爷，哈哈哈<img src=\"/Weibo/Images/emotions/laugh.gif\" title=\"哈哈\">',0,1),(112,'2013-12-28 22:00:59',37,41,'哈哈你个大傻屌<img src=\"/Weibo/Images/emotions/otm.gif\" title=\"奥特曼\">',0,1),(147,'2013-12-29 10:58:54',40,37,'找个时间大家一起去玩一玩啊<img src=\"/Weibo/Images/emotions/laugh.gif\" title=\"哈哈\"><img src=\"/Weibo/Images/emotions/laugh.gif\" title=\"哈哈\"><img src=\"/Weibo/Images/emotions/laugh.gif\" title=\"哈哈\">',0,1),(148,'2013-12-29 10:59:15',40,41,'蓝大爷<img src=\"/Weibo/Images/emotions/laugh.gif\" title=\"哈哈\"><img src=\"/Weibo/Images/emotions/laugh.gif\" title=\"哈哈\"><img src=\"/Weibo/Images/emotions/laugh.gif\" title=\"哈哈\">',0,1),(149,'2013-12-29 11:06:50',37,40,'这个可以有，等汇报完了就可以',0,1),(150,'2013-12-29 11:07:54',37,41,'哈哈，大傻逼<img src=\"/Weibo/Images/emotions/laugh.gif\" title=\"哈哈\"><img src=\"/Weibo/Images/emotions/laugh.gif\" title=\"哈哈\"><img src=\"/Weibo/Images/emotions/laugh.gif\" title=\"哈哈\">',0,1),(151,'2013-12-29 11:26:48',0,0,'请不要发送敏感信息，不然我们会请您来喝茶的',5,1),(152,'2013-12-29 13:13:31',0,43,'欢迎您加入我们的微博大家庭，祝您越V越开心，越V越漂亮',5,1),(153,'2013-12-29 13:18:14',37,43,'哈哈<img src=\"/Weibo/Images/emotions/laugh.gif\" title=\"哈哈\">',0,1),(154,'2013-12-29 14:21:56',0,44,'欢迎您加入我们的微博大家庭，祝您越V越开心，越V越漂亮',5,1),(155,'2013-12-29 14:28:15',0,45,'欢迎您加入我们的微博大家庭，祝您越V越开心，越V越漂亮',5,1);
/*!40000 ALTER TABLE `msg_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profile` (
  `profId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `profContent` varchar(300) DEFAULT NULL,
  `profTime` datetime NOT NULL,
  `tcId` int(11) DEFAULT NULL,
  `ImageRef` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`profId`),
  KEY `FK_Reference_1` (`userId`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES (198,37,'这是我的第一条微博[给力][给力][给力]','2013-12-28 22:02:56',0,NULL),(199,42,'发现了一个好平台，大家快来啊[哈哈][哈哈][哈哈]','2013-12-28 22:05:19',0,NULL),(200,40,'Merry X\'mas[围观]','2013-12-28 22:05:59',0,NULL),(201,39,'广州的冬天也还是比较冷阿[伤心][伤心][伤心]','2013-12-28 22:07:21',0,NULL),(202,41,'我就是蓝大爷[哈哈][哈哈][哈哈]','2013-12-28 22:10:01',0,NULL),(203,41,'陈老师给高分啊！！！！！[哈哈][哈哈][哈哈]','2013-12-28 22:22:00',0,NULL),(204,37,'明天就要验收汇报了，今天抓紧测试啊[奥特曼][奥特曼][奥特曼]','2013-12-29 10:35:52',0,NULL),(205,37,'刷屏刷屏刷屏刷屏刷屏[哈哈][哈哈][哈哈]','2013-12-29 10:40:39',0,NULL),(206,41,'随便啦','2013-12-29 10:52:11',0,NULL),(207,40,'今天天气很好，最适合郊游神马的[奥特曼][奥特曼]','2013-12-29 10:56:09',0,NULL),(208,40,'[给力]加油啊，最后一天完了好好庆祝一下','2013-12-29 10:57:17',190,NULL),(209,38,'其实我比较羞涩，不爱发微博[嘿嘿][嘿嘿][嘿嘿]','2013-12-29 11:00:50',0,NULL),(212,38,'                   ','2013-12-29 11:24:31',0,NULL),(213,43,'说句话试试能不能用','2013-12-29 13:14:41',0,NULL),(214,39,'哇 界面好漂亮呢','2013-12-29 14:02:37',0,NULL),(215,44,'同志们辛苦啦[围观]','2013-12-29 14:26:50',0,NULL),(216,45,'要继续采取有效措施，增加普通商品住房供应。要继续坚持搞好房地产市场调控，巩固调控成果。让保障房违规者付出高代价。[给力]','2013-12-29 14:35:23',0,NULL);
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transmit_collection`
--

DROP TABLE IF EXISTS `transmit_collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transmit_collection` (
  `tcId` int(11) NOT NULL AUTO_INCREMENT,
  `tcTime` datetime NOT NULL,
  `tcProfId` int(11) NOT NULL,
  `tcFrom` int(11) NOT NULL,
  `tcOriginal` int(11) DEFAULT NULL,
  PRIMARY KEY (`tcId`),
  KEY `FK_Reference_6` (`tcProfId`),
  KEY `FK_Reference_7` (`tcFrom`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`tcProfId`) REFERENCES `profile` (`profId`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`tcFrom`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=192 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transmit_collection`
--

LOCK TABLES `transmit_collection` WRITE;
/*!40000 ALTER TABLE `transmit_collection` DISABLE KEYS */;
INSERT INTO `transmit_collection` VALUES (89,'2011-12-01 00:05:39',94,14,55),(181,'2011-12-20 19:49:41',130,32,114),(190,'2013-12-29 10:57:17',204,40,204),(191,'2013-12-29 14:15:21',214,37,0);
/*!40000 ALTER TABLE `transmit_collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfo` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(12) NOT NULL,
  `nickName` varchar(12) NOT NULL,
  `trueName` varchar(8) DEFAULT NULL,
  `Province` varchar(12) NOT NULL,
  `City` varchar(12) NOT NULL,
  `Sex` varchar(3) NOT NULL,
  `Birthday` date DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `QQ` varchar(12) DEFAULT NULL,
  `MSN` varchar(12) DEFAULT NULL,
  `introduce` varchar(20) DEFAULT NULL,
  `identifier` varchar(20) DEFAULT NULL,
  `schoolType` bigint(20) DEFAULT NULL,
  `schoolName` varchar(20) DEFAULT NULL,
  `college` varchar(20) DEFAULT NULL,
  `schoolTime` bigint(20) DEFAULT NULL,
  `workProv` varchar(12) DEFAULT NULL,
  `workCity` varchar(12) DEFAULT NULL,
  `workplace` varchar(20) DEFAULT NULL,
  `workTimeFrom` bigint(20) DEFAULT NULL,
  `workTimeTo` bigint(20) DEFAULT NULL,
  `department` varchar(12) DEFAULT NULL,
  `tag` varchar(50) DEFAULT NULL,
  `comPower` tinyint(1) DEFAULT NULL,
  `msgPower` tinyint(1) DEFAULT NULL,
  `searchPower` tinyint(1) DEFAULT NULL,
  `blacklist` varchar(50) DEFAULT NULL,
  `myFace` varchar(30) DEFAULT NULL,
  `regTime` datetime NOT NULL,
  PRIMARY KEY (`userId`),
  KEY `FK_Reference_2` (`loginName`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`loginName`) REFERENCES `login` (`loginName`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (37,'Joepher','Joepher','熊峰','广东','广州','1','1991-11-09','Joepher@163.com','405419227',NULL,'牛逼的人生不需要解释','421127199111093015',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/Weibo/Images/Faces/37.jpg','2013-12-28 21:51:16'),(38,'baiyandong','byd',NULL,'广东','广州','1',NULL,NULL,NULL,NULL,NULL,'340824197104154595',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/Weibo/Images/Faces/38.jpg','2013-12-28 21:52:08'),(39,'yangxin','小昕昕',NULL,'江西','赣州','2',NULL,NULL,NULL,NULL,NULL,'340824198905164376',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/Weibo/Images/Faces/39.jpg','2013-12-28 21:53:27'),(40,'xiaowen_z','蚊子哟','','直辖市','北京','2','2013-12-29','','',NULL,'','34082419720119955X',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/Weibo/Images/Faces/40.jpg','2013-12-28 21:54:44'),(41,'lanxianyun','我是你蓝大爷',NULL,'江西','赣州','1',NULL,NULL,NULL,NULL,NULL,'340824197109226893',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/Weibo/Images/Faces/41.jpg','2013-12-28 21:55:57'),(42,'zhuoxiaoyan','蒜尾',NULL,'广东','潮州','2',NULL,NULL,NULL,NULL,NULL,'340824198209182538',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/Weibo/Images/Faces/42.jpg','2013-12-28 21:56:55'),(43,'feizhenkun','feizhenkun',NULL,'广东','广州','1',NULL,NULL,NULL,NULL,NULL,'412728199003270051',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/Weibo/Images/Faces/boy.gif','2013-12-29 13:13:31'),(44,'xidada','我是习大大','习大大','直辖市','北京','1','2013-12-29','','',NULL,'我是主席习大大','511301198005285595',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/Weibo/Images/Faces/44.jpg','2013-12-29 14:21:55'),(45,'likeqiang','我是强强哥','李强强','直辖市','北京','1','2013-12-29','','',NULL,'我是总理李强强','511301198005285595',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/Weibo/Images/Faces/45.jpg','2013-12-29 14:28:15');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-29 18:50:21
