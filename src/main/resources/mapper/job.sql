-- MySQL dump 10.13  Distrib 5.7.34, for Linux (x86_64)
--
-- Host: localhost    Database: job-center
-- ------------------------------------------------------
-- Server version	5.7.34

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
-- Table structure for table `alarm_info`
--

DROP TABLE IF EXISTS `alarm_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alarm_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `IP` varchar(255) DEFAULT NULL,
  `ALAM_INFO` varchar(255) DEFAULT NULL,
  `ALAM_TIME` datetime DEFAULT NULL,
  `UP_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alarm_info`
--

LOCK TABLES `alarm_info` WRITE;
/*!40000 ALTER TABLE `alarm_info` DISABLE KEYS */;
INSERT INTO `alarm_info` VALUES (16,'127.0.0.1','设备负载超过极限','2021-07-16 02:15:07','2021-07-16 09:17:54'),(17,'127.0.0.1','设备负载超过极限','1970-01-01 08:00:00','2021-07-16 09:18:38'),(18,'127.0.0.1','设备负载超过极限','1970-01-08 08:00:00','2021-07-16 09:19:45'),(19,'127.0.0.1','网络不通','2021-07-16 04:43:17','2021-07-16 09:20:38'),(20,'127.0.0.1','网络不通','2021-07-16 09:20:38','2021-07-16 09:59:15'),(21,'127.0.0.1','网络不通','2021-07-16 09:20:38','2021-07-16 09:59:19'),(22,'127.0.0.1','网络不通','2021-05-18 09:15:07','2021-07-16 09:59:20');
/*!40000 ALTER TABLE `alarm_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_info`
--

DROP TABLE IF EXISTS `data_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_info` (
  `DATA_TYPE` varchar(255) DEFAULT NULL,
  `NUMBER` bigint(20) DEFAULT NULL,
  `VOLUME` bigint(20) DEFAULT NULL,
  `PROCESS` varchar(255) DEFAULT NULL,
  `COLL_TIME` datetime DEFAULT NULL,
  `UP_TIME` datetime DEFAULT NULL,
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_info`
--

LOCK TABLES `data_info` WRITE;
/*!40000 ALTER TABLE `data_info` DISABLE KEYS */;
INSERT INTO `data_info` VALUES ('成品稿件',2222,29181,'com.getdata.running','2021-07-16 14:33:23','2021-07-21 14:33:27',1),('成品稿件',1112222,29181,'com.getdata.running','2021-07-16 14:33:23','2021-07-16 14:46:44',3),('成品稿件',1112222,29181,'com.getdata.running','2021-07-16 14:33:23','2021-07-16 14:47:20',4),('成品稿件',1112222,29181,'com.getdata.running','2021-07-16 14:33:23','2021-07-16 14:47:22',5),('成品稿件',1112222,29181,'com.getdata.running','2021-07-16 14:33:23','2021-07-16 14:49:24',6),('成品稿件',1112222,29181,'com.getdata.tacking','2021-07-16 14:33:23','2021-07-16 14:49:24',7);
/*!40000 ALTER TABLE `data_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resources_info`
--

DROP TABLE IF EXISTS `resources_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resources_info` (
  `IP` varchar(255) DEFAULT NULL,
  `CPU_RATE` float DEFAULT NULL,
  `MEM_RATE` float DEFAULT NULL,
  `DISK_RATE` float DEFAULT NULL,
  `COLL_TIME` datetime DEFAULT NULL,
  `UP_TIME` datetime DEFAULT NULL,
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resources_info`
--

LOCK TABLES `resources_info` WRITE;
/*!40000 ALTER TABLE `resources_info` DISABLE KEYS */;
INSERT INTO `resources_info` VALUES ('127.0.0.1',0.22,1.1,0.11,'2021-07-16 11:20:51','2021-07-16 11:20:54',1),('127.0.0.5',0,0,0,'2021-07-16 11:20:51','2021-07-16 11:52:04',15),('127.0.0.5',0.22,1.1,0.11,'2021-07-16 11:20:51','2021-07-16 11:52:46',16),('127.0.0.5',0.22,3.1,3.11,'2021-07-16 11:20:51','2021-07-16 11:52:56',17),('127.0.0.4',0.22,3.1,3.11,'2021-07-16 11:20:51','2021-07-16 11:53:02',18),('127.0.0.3',0.22,3.1,3.11,'2021-07-16 11:20:51','2021-07-16 11:53:04',19),('127.0.0.2',0.22,3.1,3.11,'2021-07-16 11:20:51','2021-07-16 11:53:07',20);
/*!40000 ALTER TABLE `resources_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `server_state`
--

DROP TABLE IF EXISTS `server_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `server_state` (
  `PROGRAM` varchar(255) DEFAULT NULL,
  `FUN_DES` varchar(255) DEFAULT NULL,
  `RUN_STATE` varchar(255) DEFAULT NULL,
  `DETAILS` varchar(255) DEFAULT NULL,
  `IP` varchar(255) DEFAULT NULL,
  `PROCESS` varchar(255) DEFAULT NULL,
  `COLL_TIME` datetime DEFAULT NULL,
  `UP_TIME` datetime DEFAULT NULL,
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `server_state`
--

LOCK TABLES `server_state` WRITE;
/*!40000 ALTER TABLE `server_state` DISABLE KEYS */;
INSERT INTO `server_state` VALUES ('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.1','com.getdata.running','2021-07-16 14:07:12','2021-07-16 14:07:15',1),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.1','com.getdata.running',NULL,NULL,2),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.2','com.getdata.running',NULL,NULL,3),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.2','com.getdata.running',NULL,NULL,4),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.2','com.getdata.running',NULL,NULL,5),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.2','com.getdata.running',NULL,NULL,6),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.2','com.getdata.running',NULL,NULL,7),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.2','com.getdata.running',NULL,NULL,8),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.3','com.getdata.running',NULL,NULL,9),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.3','com.getdata.running',NULL,NULL,10),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.5','com.getdata.running',NULL,NULL,11),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.5','com.getdata.running',NULL,NULL,12),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.5','com.getdata.running',NULL,NULL,13),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.5','com.getdata.running',NULL,NULL,14),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.5','com.getdata.running',NULL,NULL,15),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.5','com.getdata.running',NULL,NULL,16),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.5','com.getdata.running',NULL,NULL,17),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.5','com.getdata.running',NULL,NULL,18),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.5','com.getdata.running',NULL,NULL,19),('NMC数据采集','采集NMC向平台传输的数据','1','资源紧张','127.0.0.4','com.getdata.running',NULL,NULL,20);
/*!40000 ALTER TABLE `server_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `web_info`
--

DROP TABLE IF EXISTS `web_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `web_info` (
  `PAGE` varchar(255) DEFAULT NULL,
  `API_NAME` varchar(255) DEFAULT NULL,
  `API_URL` varchar(255) DEFAULT NULL,
  `NUMBER` bigint(20) DEFAULT NULL,
  `COLL_TIME` datetime DEFAULT NULL,
  `UP_TIME` datetime DEFAULT NULL,
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `web_info`
--

LOCK TABLES `web_info` WRITE;
/*!40000 ALTER TABLE `web_info` DISABLE KEYS */;
INSERT INTO `web_info` VALUES ('融媒体平台','图片裁剪服务器','/ROM/share/image/',291,'2021-07-16 15:06:54','2021-07-16 15:06:58',1),('融媒体平台','图片裁剪服务器','/ROM/share/image/',291,NULL,'2021-07-16 15:34:39',8),('融媒体平台','图片裁剪服务器','/ROM/share/image/',291,NULL,'2021-07-16 15:34:50',9),('融媒体平台','图片裁剪服务器','/ROM/share/image/',291,'2021-07-16 15:06:54','2021-07-16 15:35:05',10),('融媒体平台','图片裁剪服务器','/ROM/share/image/',291,'2021-07-16 15:06:54','2021-07-16 15:35:11',11),('融媒体平台','图片裁剪服务器','/ROM/share/image/',291,'2021-07-16 15:06:54','2021-07-16 15:35:14',12);
/*!40000 ALTER TABLE `web_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-16  8:11:46
