CREATE DATABASE  IF NOT EXISTS `receiving` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `receiving`;
-- MySQL dump 10.13  Distrib 8.0.11, for macos10.13 (x86_64)
--
-- Host: localhost    Database: receiving
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `factory`
--

DROP TABLE IF EXISTS `factory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `factory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `factoryno` varchar(45) DEFAULT NULL,
  `factoryname` varchar(45) DEFAULT NULL,
  `factorycontect` varchar(45) DEFAULT NULL,
  `factorytel` varchar(45) DEFAULT NULL,
  `factoryadds` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factory`
--

LOCK TABLES `factory` WRITE;
/*!40000 ALTER TABLE `factory` DISABLE KEYS */;
INSERT INTO `factory` VALUES (1,'F001','聯華食品','陳泰宏','09-1189-9649','彰化縣二水鄉過圳路53號'),(2,'F002','嘟嘟好食','鄭豐毅','02-2553-3235','台北市延平北路二段238-1號'),(3,'F003','大潤發','朱小姐','05-5966-508 ','雲林縣斗南鎮仁愛路16號'),(4,'F004','元金食品','Chiu','09-3370-2178','屏東縣'),(5,'F005','福義軒','張小姐','02-2381-0008','台北市萬華區和平西路3段396號'),(6,'F006','義美','何玉','03--377-7579','桃園縣八德市和平路112號'),(7,'F007','嘟嘟好食','李小姐','03-5509-966 ','新竹縣竹北市福興東路一段228號'),(8,'F008','川和食品','周明冠','02-2821-9756','北市北投區懷德街16號'),(9,'F009','元金食品','陳正雄','07-3520-062 ','高雄市大社區中山路215號'),(10,'F010','玉珍食品','王景楠','06-2053-360 ','台南市永康市信義二街43號'),(11,'F011','盛香珍','鄭小姐','06-2313-565 ','台南市永康區中山北路499巷22號之1'),(12,'F012','旺旺食品','珊淩','09-2277-3368','高雄市苓雅區三多二路33巷24號'),(13,'F013','明義肉鬆','吳小姐','02-2994-4629','新北市新莊區自信街45巷13號1樓');
/*!40000 ALTER TABLE `factory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-25 21:45:15
