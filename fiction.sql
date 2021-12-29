-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: localhost    Database: fiction
-- ------------------------------------------------------
-- Server version	5.7.24-log

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
-- Table structure for table `c_fiction`
--

DROP TABLE IF EXISTS `c_fiction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `c_fiction` (
  `categoryId` int(11) NOT NULL DEFAULT '0',
  `fictionId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`categoryId`,`fictionId`) USING BTREE,
  KEY `fk8` (`fictionId`) USING BTREE,
  CONSTRAINT `fk7` FOREIGN KEY (`categoryId`) REFERENCES `category` (`categoryId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk8` FOREIGN KEY (`fictionId`) REFERENCES `fiction` (`fictionId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `c_fiction`
--

LOCK TABLES `c_fiction` WRITE;
/*!40000 ALTER TABLE `c_fiction` DISABLE KEYS */;
INSERT INTO `c_fiction` VALUES (1,1),(1,2),(2,3),(5,5);
/*!40000 ALTER TABLE `c_fiction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(32) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `desc` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`categoryId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'古典名著','2021-07-16 10:47:01','收录有关古典名著'),(2,'现代文学','2021-07-26 17:39:12','有关现代文学'),(3,'西方文学','2021-07-13 18:15:26','有关西方文学'),(4,'科幻文学','2021-07-06 18:15:50','有关科幻文学'),(5,'言情小说','2021-03-11 18:16:19','言情系列的小说');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chapter`
--

DROP TABLE IF EXISTS `chapter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chapter` (
  `chapterId` int(11) NOT NULL AUTO_INCREMENT,
  `chapterName` varchar(32) DEFAULT NULL,
  `chapterPath` varchar(32) DEFAULT 'C:/path',
  `fictionId` int(11) DEFAULT NULL,
  PRIMARY KEY (`chapterId`) USING BTREE,
  KEY `fk21` (`fictionId`) USING BTREE,
  CONSTRAINT `fk21` FOREIGN KEY (`fictionId`) REFERENCES `fiction` (`fictionId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chapter`
--

LOCK TABLES `chapter` WRITE;
/*!40000 ALTER TABLE `chapter` DISABLE KEYS */;
INSERT INTO `chapter` VALUES (1,'hlm_ch1','C:/path',1),(2,'hlm_ch2','C:/path',1),(3,'st_01','C:/path',3),(4,'st_02','C:/path',3),(5,'xyj_01','C:/path',2);
/*!40000 ALTER TABLE `chapter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collect`
--

DROP TABLE IF EXISTS `collect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collect` (
  `userId` int(10) NOT NULL,
  `fictionId` int(11) NOT NULL,
  `collectTime` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`userId`,`fictionId`) USING BTREE,
  KEY `fk4` (`fictionId`) USING BTREE,
  CONSTRAINT `fk3` FOREIGN KEY (`userId`) REFERENCES `fictionuser` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk4` FOREIGN KEY (`fictionId`) REFERENCES `fiction` (`fictionId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collect`
--

LOCK TABLES `collect` WRITE;
/*!40000 ALTER TABLE `collect` DISABLE KEYS */;
INSERT INTO `collect` VALUES (1,3,'2021'),(11,2,'1658'),(11,3,'2015');
/*!40000 ALTER TABLE `collect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fiction`
--

DROP TABLE IF EXISTS `fiction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fiction` (
  `fictionId` int(11) NOT NULL AUTO_INCREMENT,
  `fictionName` varchar(32) DEFAULT NULL,
  `author` varchar(32) DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `createTime` varchar(32) DEFAULT NULL,
  `descriptions` varchar(32) DEFAULT NULL,
  `isMember` varchar(32) DEFAULT NULL,
  `isputaway` varchar(32) DEFAULT NULL,
  `putawayTime` varchar(32) DEFAULT NULL,
  `fictionimg` blob,
  PRIMARY KEY (`fictionId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fiction`
--

LOCK TABLES `fiction` WRITE;
/*!40000 ALTER TABLE `fiction` DISABLE KEYS */;
INSERT INTO `fiction` VALUES (1,'红楼梦','曹雪芹',522,'1665-02-06 00:00:00','四大名著','Y','Y','1856-06-09 00:00:00',NULL),(2,'西游记','吴承恩',852,'1666-08-06 00:00:00','四大名著','Y','Y','1858-06-09 00:00:00',NULL),(3,'三体上','刘欣慈',365,'2015-06-08 00:00:00','非常棒的科幻小说','Y','Y','2016-08-09 00:00:00',NULL),(5,'测试2','你好',1234,'1999-09-09 00:00:00','hello','Y','Y','1954-05-06 00:00:00',NULL);
/*!40000 ALTER TABLE `fiction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fictionuser`
--

DROP TABLE IF EXISTS `fictionuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fictionuser` (
  `userId` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) DEFAULT NULL,
  `userPassword` varchar(200) NOT NULL,
  `userFullName` varchar(32) DEFAULT NULL,
  `movephone` varchar(32) DEFAULT NULL,
  `memberdayCount` varchar(32) DEFAULT '0',
  PRIMARY KEY (`userId`) USING BTREE,
  UNIQUE KEY `uk2` (`userName`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fictionuser`
--

LOCK TABLES `fictionuser` WRITE;
/*!40000 ALTER TABLE `fictionuser` DISABLE KEYS */;
INSERT INTO `fictionuser` VALUES (1,'tom','123465','tommer','1584796325','30'),(2,'李四','abc123','lisi','110','200'),(9,'jack','123456','jackker','1666584425','15'),(10,'rom','123456','rommy','1548494962','1'),(11,'小明','654321','尼古拉 小明','1999666582','999'),(14,'小红','abc123','xiao ming','110120','20');
/*!40000 ALTER TABLE `fictionuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `managerinfo`
--

DROP TABLE IF EXISTS `managerinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `managerinfo` (
  `managerId` int(10) NOT NULL AUTO_INCREMENT,
  `manageruserName` varchar(64) DEFAULT NULL,
  `managerPassword` varchar(200) NOT NULL,
  `managerfullname` varchar(64) DEFAULT NULL,
  `createTime` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`managerId`) USING BTREE,
  UNIQUE KEY `uk1` (`manageruserName`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managerinfo`
--

LOCK TABLES `managerinfo` WRITE;
/*!40000 ALTER TABLE `managerinfo` DISABLE KEYS */;
INSERT INTO `managerinfo` VALUES (1,'张三','123456','张珊珊','2020-1-1'),(2,'李四','654321','李思思','2021-5-6'),(3,'王五','123456','王呜呜','1965-5-5'),(4,'赵六','123456','赵琉馏','2014-5-6'),(5,'赵丝丝','1234567','赵丝丝','2021-7-26'),(6,'莉莉','123456','lili','2021'),(12,'莉莉1','123456','lili','2021');
/*!40000 ALTER TABLE `managerinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `noticeId` int(10) NOT NULL AUTO_INCREMENT,
  `createTime` varchar(32) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `managerId` int(10) DEFAULT NULL,
  PRIMARY KEY (`noticeId`) USING BTREE,
  KEY `fk11` (`managerId`) USING BTREE,
  CONSTRAINT `fk11` FOREIGN KEY (`managerId`) REFERENCES `managerinfo` (`managerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (1,'2016','121212',2),(5,'2018','hello',2),(6,'2020','world',1);
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `noticeuser`
--

DROP TABLE IF EXISTS `noticeuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `noticeuser` (
  `noticeId` int(10) NOT NULL,
  `userId` int(10) NOT NULL,
  PRIMARY KEY (`noticeId`,`userId`) USING BTREE,
  KEY `fk2` (`userId`) USING BTREE,
  CONSTRAINT `fk1` FOREIGN KEY (`noticeId`) REFERENCES `notice` (`noticeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`userId`) REFERENCES `fictionuser` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noticeuser`
--

LOCK TABLES `noticeuser` WRITE;
/*!40000 ALTER TABLE `noticeuser` DISABLE KEYS */;
INSERT INTO `noticeuser` VALUES (1,1),(6,11);
/*!40000 ALTER TABLE `noticeuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payinfo`
--

DROP TABLE IF EXISTS `payinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payinfo` (
  `payId` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(10) DEFAULT NULL,
  `payTime` varchar(32) DEFAULT NULL,
  `payMoney` varchar(32) DEFAULT NULL,
  `addDays` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`payId`) USING BTREE,
  KEY `fk12` (`userId`) USING BTREE,
  CONSTRAINT `fk12` FOREIGN KEY (`userId`) REFERENCES `fictionuser` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payinfo`
--

LOCK TABLES `payinfo` WRITE;
/*!40000 ALTER TABLE `payinfo` DISABLE KEYS */;
INSERT INTO `payinfo` VALUES (1,1,'2020','500','10'),(3,10,'2021','600','20'),(4,11,'1999','300','15');
/*!40000 ALTER TABLE `payinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reading`
--

DROP TABLE IF EXISTS `reading`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reading` (
  `userId` int(10) NOT NULL,
  `fictionId` int(10) NOT NULL,
  `startTime` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`userId`,`fictionId`) USING BTREE,
  KEY `fk6` (`fictionId`) USING BTREE,
  CONSTRAINT `fk5` FOREIGN KEY (`userId`) REFERENCES `fictionuser` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk6` FOREIGN KEY (`fictionId`) REFERENCES `fiction` (`fictionId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reading`
--

LOCK TABLES `reading` WRITE;
/*!40000 ALTER TABLE `reading` DISABLE KEYS */;
INSERT INTO `reading` VALUES (1,1,'2021'),(9,3,'1956'),(10,3,'2020');
/*!40000 ALTER TABLE `reading` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'fiction'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-29 10:25:16
