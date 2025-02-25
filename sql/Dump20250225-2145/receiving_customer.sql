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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerno` varchar(45) DEFAULT NULL,
  `customername` varchar(45) DEFAULT NULL,
  `customertel` varchar(45) DEFAULT NULL,
  `customeradds` varchar(45) DEFAULT NULL,
  `customernote` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (26,'C001','台北中山北店','02-2536-1350','台北市中山區中山北路二段33號2樓','送上3樓'),(27,'C002','台北南京東店','02-8770-7989','台北市松山區南京東路四段169號2樓','備註'),(28,'C003','台北光復南店','02-2325-3478','台北市大安區光復南路612號2樓','備註'),(29,'C004','台北和平東店','02-2393-4689','台北市大安和平東路一段177號','備註'),(30,'C005','板橋文化店','02-2272-2016','新北市板橋區文化路一段71號','備註'),(31,'C006','台北永和店','02-8660-6006','新北市永和區永和路一段228號','備註'),(32,'C007','新竹北大店','03-525-3236','新竹市北區北大路346號2樓','備註'),(33,'C008','中壢延平店','03-425-9009','中壢市延平路552號2樓','備註'),(34,'C009','桃園中山店','03-339-1650','桃園市中山路546號','備註'),(35,'C010','台中五權店','04-2201-2012','台中市西區五權路131號','備註'),(36,'C011','台中文心店','04-2313-6430','台中市西屯區寧夏路233號','備註'),(37,'C012','台中台灣大道店','04-2355-3155','台中市西屯區台灣大道四段771號2樓','備註'),(38,'C013','上海洋樓','07- 767-7539 ','高雄市三民區文濱路55號','upupup');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
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
