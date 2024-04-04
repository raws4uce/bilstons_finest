-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: csmathapp
-- ------------------------------------------------------
-- Server version	8.0.34
               create database csmathapp;
               use csmathapp;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adde`
--

DROP TABLE IF EXISTS `adde`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adde` (
  `idadde` int NOT NULL AUTO_INCREMENT,
  `qText` varchar(45) DEFAULT NULL,
  `qAnswer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idadde`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adde`
--

LOCK TABLES `adde` WRITE;
/*!40000 ALTER TABLE `adde` DISABLE KEYS */;
INSERT INTO `adde` VALUES (1,'What is 2 + 3?','5'),(2,'What is 10 + 4?','14'),(3,'What is 8 + 2?','10'),(4,'What is 5 + 15?','20'),(5,'What is 17 + 30?','47'),(6,'What is 9 + 11?','20'),(7,'What is 4 + 42?','46'),(8,'What is 15 + 9?','24'),(9,'What is 4 + 13?','17'),(10,'What is 2 + 41?','43'),(11,'What is 12 + 6?','18'),(12,'What is 38 + 19?','57');
/*!40000 ALTER TABLE `adde` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addh`
--

DROP TABLE IF EXISTS `addh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addh` (
  `idaddh` int NOT NULL AUTO_INCREMENT,
  `qtext` varchar(45) DEFAULT NULL,
  `qanswer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idaddh`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addh`
--

LOCK TABLES `addh` WRITE;
/*!40000 ALTER TABLE `addh` DISABLE KEYS */;
INSERT INTO `addh` VALUES (1,'What is 237 + 468?','705'),(2,'What is 891 + 654?','1545'),(3,'What is 426 + 789?','1215'),(4,'What is 345 + 678?','1023'),(5,'What is 912 + 543?','1455'),(6,'What is 789 + 876?','1665'),(7,'What is 654 + 321?','975'),(8,'What is 567 + 432?','999'),(9,'What is 345 + 561?','905'),(10,'What is 651 + 213?','874'),(11,'What is 894 + 134?','1028'),(12,'What is 112 + 451?','563');
/*!40000 ALTER TABLE `addh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addm`
--

DROP TABLE IF EXISTS `addm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addm` (
  `idaddm` int NOT NULL AUTO_INCREMENT,
  `qtext` varchar(45) DEFAULT NULL,
  `qanswer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idaddm`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addm`
--

LOCK TABLES `addm` WRITE;
/*!40000 ALTER TABLE `addm` DISABLE KEYS */;
INSERT INTO `addm` VALUES (1,'What is 13 + 7?','20'),(2,'What is 25 + 14?','39'),(3,'What is 18 + 22?','40'),(4,'What is 36 + 19?','55'),(5,'What is 42 + 28?','70'),(6,'What is 56 + 34?','90'),(7,'What is 47 + 23?','70'),(8,'What is 31 + 19?','50'),(9,'What is 94 + 13?','107'),(10,'What is 12 + 41?','53'),(11,'What is 25 + 14?','39'),(12,'What is 72 + 48?','120');
/*!40000 ALTER TABLE `addm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dive`
--

DROP TABLE IF EXISTS `dive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dive` (
  `iddive` int NOT NULL AUTO_INCREMENT,
  `qtext` varchar(45) DEFAULT NULL,
  `qanswer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iddive`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dive`
--

LOCK TABLES `dive` WRITE;
/*!40000 ALTER TABLE `dive` DISABLE KEYS */;
INSERT INTO `dive` VALUES (1,'What is 10 ÷ 2?','5'),(2,'What is 20 ÷ 4?','5'),(3,'What is 30 ÷ 5?','6'),(4,'What is 40 ÷ 8?','5'),(5,'What is 50 ÷ 10?','5'),(6,'What is 60 ÷ 12?','5'),(7,'What is 70 ÷ 7?','10'),(8,'What is 80 ÷ 8?','10'),(9,'What is 90 ÷ 9?','10'),(10,'What is 100 ÷ 10?','10'),(11,'What is 15 ÷ 3?','5'),(12,'What is 48 ÷ 6?','8');
/*!40000 ALTER TABLE `dive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `divh`
--

DROP TABLE IF EXISTS `divh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `divh` (
  `iddivh` int NOT NULL AUTO_INCREMENT,
  `qtext` varchar(45) DEFAULT NULL,
  `qanswer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iddivh`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `divh`
--

LOCK TABLES `divh` WRITE;
/*!40000 ALTER TABLE `divh` DISABLE KEYS */;
INSERT INTO `divh` VALUES (1,'What is 1764 ÷ 28?','63'),(2,'What is 2025 ÷ 45?','45'),(3,'What is 2916 ÷ 54?','54'),(4,'What is 3844 ÷ 62?','62'),(5,'What is 4900 ÷ 70?','70'),(6,'What is 6084 ÷ 84?','72'),(7,'What is 7396 ÷ 86?','86'),(8,'What is 8836 ÷ 92?','96'),(9,'What is 10201 ÷ 101?','101'),(10,'What is 11664 ÷ 108?','108'),(11,'What is 144 ÷ 12?','12'),(12,'What is 300 ÷ 15?','20');
/*!40000 ALTER TABLE `divh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `divm`
--

DROP TABLE IF EXISTS `divm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `divm` (
  `iddivm` int NOT NULL AUTO_INCREMENT,
  `qtext` varchar(45) DEFAULT NULL,
  `qanswer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iddivm`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `divm`
--

LOCK TABLES `divm` WRITE;
/*!40000 ALTER TABLE `divm` DISABLE KEYS */;
INSERT INTO `divm` VALUES (1,'What is 144 ÷ 12?','12'),(2,'What is 225 ÷ 15?','15'),(3,'What is 336 ÷ 14?','24'),(4,'What is 441 ÷ 21?','21'),(5,'What is 528 ÷ 22?','24'),(6,'What is 625 ÷ 25?','25'),(7,'What is 729 ÷ 27?','27'),(8,'What is 864 ÷ 24?','36'),(9,'What is 961 ÷ 31?','31'),(10,'What is 1024 ÷ 32?','32'),(11,'What is 24 ÷ 4?','6'),(12,'What is 72 ÷ 8?','9');
/*!40000 ALTER TABLE `divm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hints`
--

DROP TABLE IF EXISTS `hints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hints` (
  `idhints` int NOT NULL AUTO_INCREMENT,
  `hint` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idhints`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hints`
--

LOCK TABLES `hints` WRITE;
/*!40000 ALTER TABLE `hints` DISABLE KEYS */;
INSERT INTO `hints` VALUES (1,'Use long division or other advanced division techniques to find the answer.'),(2,'Use the bus stop method.'),(3,'Try using addition or multiplication to find the answer indirectly.'),(4,'Try using addition to check your subtraction.'),(5,'Subtract by counting backward.'),(6,'Count on from the larger number.'),(7,'Look for patterns in the numbers that make them easier to add.'),(8,'Remember to carry the one.'),(9,'Try using your fingers to count.'),(10,'Break down the problem into smaller, easier-to-solve parts.'),(11,'Just add the first number, the second number amount of times.'),(12,'Grab a pen and paper for multiplication.');
/*!40000 ALTER TABLE `hints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mule`
--

DROP TABLE IF EXISTS `mule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mule` (
  `idmule` int NOT NULL AUTO_INCREMENT,
  `qtext` varchar(45) DEFAULT NULL,
  `qanswer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmule`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mule`
--

LOCK TABLES `mule` WRITE;
/*!40000 ALTER TABLE `mule` DISABLE KEYS */;
INSERT INTO `mule` VALUES (1,'What is 2 × 3?','6'),(2,'What is 4 × 5?','20'),(3,'What is 6 × 6?','36'),(4,'What is 7 × 8?','56'),(5,'What is 9 × 9?','81'),(6,'What is 10 × 10?','100'),(7,'What is 11 × 4?','44'),(8,'What is 12 × 2?','24'),(9,'What is 13 × 3?','39'),(10,'What is 14 × 7?','98'),(11,'What is 6 × 4?','24'),(12,'What is 8 × 9?','72');
/*!40000 ALTER TABLE `mule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mulh`
--

DROP TABLE IF EXISTS `mulh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mulh` (
  `idmulh` int NOT NULL AUTO_INCREMENT,
  `qtext` varchar(45) DEFAULT NULL,
  `qanswer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmulh`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mulh`
--

LOCK TABLES `mulh` WRITE;
/*!40000 ALTER TABLE `mulh` DISABLE KEYS */;
INSERT INTO `mulh` VALUES (1,'What is 27 * 48?','1296'),(2,'What is 39 * 64?','2496'),(3,'What is 45 * 72?','3240'),(4,'What is 56 * 81?','4536'),(5,'What is 62 * 93?','5766'),(6,'What is 78 * 107?','8346'),(7,'What is 89 * 122?','10858'),(8,'What is 95 * 138?','13110'),(9,'What is 107 * 151?','16157'),(10,'What is 114 * 167?','19038'),(11,'What is 17 × 13?','221'),(12,'What is 20 × 15?','300');
/*!40000 ALTER TABLE `mulh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mulm`
--

DROP TABLE IF EXISTS `mulm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mulm` (
  `idmulm` int NOT NULL AUTO_INCREMENT,
  `qtext` varchar(45) DEFAULT NULL,
  `qanswer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmulm`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mulm`
--

LOCK TABLES `mulm` WRITE;
/*!40000 ALTER TABLE `mulm` DISABLE KEYS */;
INSERT INTO `mulm` VALUES (1,'What is 15 × 9?','135'),(2,'What is 16 × 8?','128'),(3,'What is 17 × 7?','119'),(4,'What is 18 × 6?','108'),(5,'What is 19 × 5?','95'),(6,'What is 20 × 11?','220'),(7,'What is 21 × 4?','84'),(8,'What is 22 × 3?','66'),(9,'What is 23 × 7?','161'),(10,'What is 24 × 8?','192'),(11,'What is 5 × 7?','35'),(12,'What is 15 × 6?','90');
/*!40000 ALTER TABLE `mulm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `results`
--

DROP TABLE IF EXISTS `results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `results` (
  `idresults` int NOT NULL AUTO_INCREMENT,
  `idStudent` int NOT NULL,
  `sAnswer` varchar(45) NOT NULL,
  `correct` varchar(45) NOT NULL,
  `date` date DEFAULT NULL,
  `time` varchar(45) NOT NULL,
  `difficulty` varchar(45) NOT NULL,
  `topic` varchar(45) NOT NULL,
  `questionid` int NOT NULL,
  `hintID` int DEFAULT NULL,
  `rating` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idresults`),
  KEY `student_idx` (`idStudent`),
  KEY `hint_idx` (`hintID`),
  CONSTRAINT `hint` FOREIGN KEY (`hintID`) REFERENCES `hints` (`idhints`),
  CONSTRAINT `student` FOREIGN KEY (`idStudent`) REFERENCES `students` (`idstudents`)
) ENGINE=InnoDB AUTO_INCREMENT=630 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `results`
--

LOCK TABLES `results` WRITE;
/*!40000 ALTER TABLE `results` DISABLE KEYS */;
INSERT INTO `results` VALUES (284,1,'1','0',NULL,'23','EASY','add',1,1,'N'),(285,1,'13','0',NULL,'6','EASY','add',2,2,'N'),(286,1,'6','0',NULL,'8','EASY','add',3,3,'N'),(287,1,'6','0',NULL,'7','EASY','add',4,4,'N'),(288,1,'14','0',NULL,'12','EASY','add',5,5,'N'),(289,1,'1','0',NULL,'9','EASY','add',6,6,'Y'),(290,1,'0','0',NULL,'34','EASY','add',7,7,'Y'),(291,1,'4','0',NULL,'15','EASY','add',8,8,'Y'),(292,1,'1','0',NULL,'12','EASY','add',9,9,'Y'),(293,1,'1','0',NULL,'9','EASY','add',10,10,'Y'),(294,1,'2','0',NULL,'26','EASY','add',11,11,'N'),(295,1,'37','0',NULL,'10','EASY','add',12,12,'N'),(296,1,'6','0',NULL,'8','MEDIUM','add',1,1,'N'),(297,1,'20','0',NULL,'7','MEDIUM','add',2,2,'N'),(298,1,'24','0',NULL,'7','MEDIUM','add',3,3,'N'),(299,1,'9','0',NULL,'7','MEDIUM','add',4,4,'N'),(300,1,'51','0',NULL,'8','MEDIUM','add',5,5,'N'),(301,1,'41','0',NULL,'8','MEDIUM','add',6,6,'Y'),(302,1,'24','0',NULL,'7','MEDIUM','add',7,7,'Y'),(303,1,'2','0',NULL,'9','MEDIUM','add',8,8,'Y'),(304,1,'91','0',NULL,'7','MEDIUM','add',9,9,'Y'),(305,1,'109','0',NULL,'11','MEDIUM','add',10,10,'Y'),(306,1,'26','0',NULL,'7','MEDIUM','add',11,11,'N'),(307,1,'107','0',NULL,'6','MEDIUM','add',12,12,'N'),(308,1,'1','0',NULL,'12','EASY','add',1,1,'N'),(309,1,'2','0',NULL,'26','EASY','add',2,2,'N'),(310,1,'113','0',NULL,'7','EASY','add',3,3,'N'),(311,1,'15','0',NULL,'7','EASY','add',4,4,'N'),(312,1,'104','0',NULL,'15','HARD','add',1,1,'N'),(313,1,'425','0',NULL,'11','HARD','add',2,2,'N'),(314,1,'505','0',NULL,'9','HARD','add',3,3,'N'),(315,1,'77','0',NULL,'9','HARD','add',4,4,'N'),(316,1,'315','0',NULL,'13','HARD','add',5,5,'N'),(317,1,'65','0',NULL,'9','HARD','add',6,6,'Y'),(318,1,'629','0',NULL,'10','HARD','add',7,7,'Y'),(319,1,'1','0',NULL,'11','HARD','add',8,8,'Y'),(320,1,'715','0',NULL,'8','HARD','add',9,9,'Y'),(321,1,'529','0',NULL,'7','HARD','add',10,10,'Y'),(322,1,'626','0',NULL,'7','HARD','add',11,11,'N'),(323,1,'402','0',NULL,'8','HARD','add',12,12,'N'),(324,1,'1','0',NULL,'8','EASY','sub',1,1,'N'),(325,1,'9','0',NULL,'7','EASY','sub',2,2,'N'),(326,1,'37','0',NULL,'7','EASY','sub',3,3,'N'),(327,1,'1','0',NULL,'9','EASY','sub',4,4,'Y'),(328,1,'12','0',NULL,'6','EASY','sub',5,5,'Y'),(329,1,'4','0',NULL,'9','EASY','sub',6,6,'N'),(330,1,'7','0',NULL,'6','EASY','sub',7,7,'N'),(331,1,'11','0',NULL,'8','EASY','sub',8,8,'N'),(332,1,'13','0',NULL,'6','EASY','sub',9,9,'N'),(333,1,'16','0',NULL,'6','EASY','sub',10,10,'Y'),(334,1,'11','0',NULL,'6','EASY','sub',11,11,'N'),(335,1,'3','0',NULL,'13','EASY','sub',12,12,'N'),(336,1,'5','0',NULL,'6','MEDIUM','sub',1,1,'N'),(337,1,'19','0',NULL,'10','MEDIUM','sub',2,2,'N'),(338,1,'21','0',NULL,'7','MEDIUM','sub',3,3,'N'),(339,1,'3','0',NULL,'7','MEDIUM','sub',4,4,'Y'),(340,1,'18','0',NULL,'8','MEDIUM','sub',5,5,'Y'),(341,1,'402','0',NULL,'7','MEDIUM','sub',6,6,'Y'),(342,1,'56','0',NULL,'11','MEDIUM','sub',7,7,'N'),(343,1,'96','0',NULL,'8','MEDIUM','sub',8,8,'N'),(344,1,'100','0',NULL,'6','MEDIUM','sub',9,9,'N'),(345,1,'105','0',NULL,'6','MEDIUM','sub',10,10,'Y'),(346,1,'145','0',NULL,'9','MEDIUM','sub',11,11,'N'),(347,1,'1','0',NULL,'10','MEDIUM','sub',12,12,'N'),(348,1,'40','0',NULL,'13','HARD','sub',1,1,'N'),(349,1,'33','0',NULL,'12','HARD','sub',2,2,'N'),(350,1,'18','0',NULL,'9','HARD','sub',3,3,'N'),(351,1,'22','0',NULL,'8','HARD','sub',4,4,'Y'),(352,1,'372','0',NULL,'8','HARD','sub',5,5,'Y'),(353,1,'23','0',NULL,'7','HARD','sub',6,6,'Y'),(354,1,'21','0',NULL,'9','HARD','sub',1,1,'N'),(355,1,'383','0',NULL,'7','HARD','sub',2,2,'N'),(356,1,'69','0',NULL,'6','HARD','sub',3,3,'N'),(357,1,'385','0',NULL,'7','HARD','sub',4,4,'Y'),(358,1,'20','0',NULL,'7','HARD','sub',5,5,'Y'),(359,1,'47','0',NULL,'9','HARD','sub',6,6,'Y'),(360,1,'38','0',NULL,'7','HARD','sub',7,7,'N'),(361,1,'56','0',NULL,'7','HARD','sub',8,8,'N'),(362,1,'28','0',NULL,'7','HARD','sub',9,9,'N'),(363,1,'32','0',NULL,'6','HARD','sub',10,10,'Y'),(364,1,'4','0',NULL,'6','HARD','sub',11,11,'N'),(365,1,'22','0',NULL,'7','HARD','sub',12,12,'N'),(366,1,'38','0',NULL,'6','MEDIUM','sub',1,1,'N'),(367,1,'3','0',NULL,'42','EASY','mul',1,1,'N'),(368,1,'1','0',NULL,'8','EASY','mul',2,2,'N'),(369,1,'28','0',NULL,'7','EASY','mul',3,3,'N'),(370,1,'2','0',NULL,'17','EASY','mul',4,4,'N'),(371,1,'16','0',NULL,'7','EASY','mul',5,5,'N'),(372,1,'55','0',NULL,'6','EASY','mul',6,6,'N'),(373,1,'32','0',NULL,'9','EASY','mul',7,7,'N'),(374,1,'8','0',NULL,'7','EASY','mul',8,8,'N'),(375,1,'6','0',NULL,'6','EASY','mul',9,9,'N'),(376,1,'0','0',NULL,'6','EASY','mul',10,10,'Y'),(377,1,'70','0',NULL,'10','EASY','mul',11,11,'Y'),(378,1,'24','0',NULL,'7','EASY','mul',12,12,'Y'),(379,1,'79','0',NULL,'7','MEDIUM','mul',1,1,'N'),(380,1,'330','0',NULL,'7','MEDIUM','mul',2,2,'N'),(381,1,'104','0',NULL,'6','MEDIUM','mul',3,3,'N'),(382,1,'47','0',NULL,'7','MEDIUM','mul',4,4,'N'),(383,1,'61','0',NULL,'7','MEDIUM','mul',5,5,'N'),(384,1,'5049','0',NULL,'12','MEDIUM','mul',6,6,'N'),(385,1,'477','0',NULL,'7','MEDIUM','mul',7,7,'N'),(386,1,'51','0',NULL,'7','MEDIUM','mul',8,8,'N'),(387,1,'100','0',NULL,'7','MEDIUM','mul',9,9,'N'),(388,1,'27','0',NULL,'7','MEDIUM','mul',10,10,'Y'),(389,1,'16','0',NULL,'6','MEDIUM','mul',11,11,'Y'),(390,1,'29','0',NULL,'6','MEDIUM','mul',12,12,'Y'),(391,1,'1131','0',NULL,'6','HARD','mul',1,1,'N'),(392,1,'1982','0',NULL,'10','HARD','mul',2,2,'N'),(393,1,'3179','0',NULL,'6','HARD','mul',3,3,'N'),(394,1,'3915','0',NULL,'7','HARD','mul',4,4,'N'),(395,1,'5151','0',NULL,'6','HARD','mul',5,5,'N'),(396,1,'7701','0',NULL,'9','HARD','mul',6,6,'N'),(397,1,'10693','0',NULL,'7','HARD','mul',7,7,'N'),(398,1,'13059','0',NULL,'6','HARD','mul',8,8,'N'),(399,1,'16001','0',NULL,'7','HARD','mul',9,9,'N'),(400,1,'18982','0',NULL,'6','HARD','mul',10,10,'Y'),(401,1,'206','0',NULL,'6','HARD','mul',11,11,'Y'),(402,1,'69','0',NULL,'6','HARD','mul',12,12,'Y'),(403,1,'1','0',NULL,'14','EASY','div',1,1,'Y'),(404,1,'7','0',NULL,'7','EASY','div',2,2,'Y'),(405,1,'117','0',NULL,'7','EASY','div',3,3,'Y'),(406,1,'127','0',NULL,'6','EASY','div',4,4,'N'),(407,1,'208','0',NULL,'7','EASY','div',5,5,'N'),(408,1,'7','0',NULL,'6','EASY','div',6,6,'N'),(409,1,'8','0',NULL,'6','EASY','div',7,7,'N'),(410,1,'122','0',NULL,'6','EASY','div',8,8,'N'),(411,1,'2','0',NULL,'8','EASY','div',9,9,'N'),(412,1,'122','0',NULL,'6','EASY','div',10,10,'Y'),(413,1,'118','0',NULL,'6','EASY','div',11,11,'N'),(414,1,'23','0',NULL,'7','EASY','div',12,12,'N'),(415,1,'1','0',NULL,'7','MEDIUM','div',1,1,'Y'),(416,1,'6','0',NULL,'6','MEDIUM','div',2,2,'Y'),(417,1,'288','0',NULL,'7','MEDIUM','div',3,3,'Y'),(418,1,'102','0',NULL,'6','MEDIUM','div',4,4,'N'),(419,1,'3','0',NULL,'6','MEDIUM','div',5,5,'N'),(420,1,'4','0',NULL,'6','MEDIUM','div',6,6,'N'),(421,1,'294','0',NULL,'6','MEDIUM','div',7,7,'N'),(422,1,'285','0',NULL,'7','MEDIUM','div',8,8,'N'),(423,1,'200','0',NULL,'6','MEDIUM','div',9,9,'N'),(424,1,'26','0',NULL,'11','EASY','div',1,1,'Y'),(425,1,'3','0',NULL,'31','EASY','div',2,2,'Y'),(426,1,'59','0',NULL,'6','EASY','div',3,3,'Y'),(427,1,'46','0',NULL,'6','EASY','div',4,4,'N'),(428,1,'60','0',NULL,'6','EASY','div',5,5,'N'),(429,1,'60','0',NULL,'6','EASY','div',6,6,'N'),(430,1,'55','0',NULL,'6','EASY','div',7,7,'N'),(431,1,'55','0',NULL,'6','EASY','div',8,8,'N'),(432,1,'55','0',NULL,'6','EASY','div',9,9,'N'),(433,1,'55','0',NULL,'7','EASY','div',10,10,'Y'),(434,1,'0','0',NULL,'6','EASY','div',11,11,'N'),(435,1,'57','0',NULL,'8','EASY','div',12,12,'N'),(436,1,'53','0',NULL,'7','MEDIUM','div',1,1,'Y'),(437,1,'1','0',NULL,'13','MEDIUM','div',1,1,'Y'),(438,1,'0','0',NULL,'6','MEDIUM','div',2,2,'Y'),(439,1,'8','0',NULL,'6','MEDIUM','div',3,3,'Y'),(440,1,'210','0',NULL,'6','MEDIUM','div',4,4,'N'),(441,1,'8','0',NULL,'6','MEDIUM','div',5,5,'N'),(442,1,'7','0',NULL,'6','MEDIUM','div',6,6,'N'),(443,1,'5','0',NULL,'6','MEDIUM','div',7,7,'N'),(444,1,'4','0',NULL,'6','MEDIUM','div',8,8,'N'),(445,1,'1','0',NULL,'6','MEDIUM','div',9,9,'N'),(446,1,'29','0',NULL,'6','MEDIUM','div',10,10,'Y'),(447,1,'4','0',NULL,'6','MEDIUM','div',11,11,'N'),(448,1,'14','0',NULL,'6','MEDIUM','div',12,12,'N'),(449,1,'31','0',NULL,'7','HARD','div',1,1,'Y'),(450,1,'22','0',NULL,'6','HARD','div',2,2,'Y'),(451,1,'22','0',NULL,'6','HARD','div',3,3,'Y'),(452,1,'30','0',NULL,'7','HARD','div',4,4,'N'),(453,1,'38','0',NULL,'6','HARD','div',5,5,'N'),(454,1,'40','0',NULL,'6','HARD','div',6,6,'N'),(455,1,'54','0',NULL,'6','HARD','div',7,7,'N'),(456,1,'64','0',NULL,'6','HARD','div',8,8,'N'),(457,1,'69','0',NULL,'6','HARD','div',9,9,'N'),(458,1,'76','0',NULL,'7','HARD','div',10,10,'N'),(459,1,'20','0',NULL,'6','HARD','div',11,11,'N'),(460,1,'12','0',NULL,'8','HARD','div',12,12,'N'),(461,1,'5','0',NULL,'9','EASY','mul',1,1,'N'),(462,1,'19','0',NULL,'6','EASY','mul',2,2,'N'),(463,1,'35','0',NULL,'6','EASY','mul',3,3,'N'),(464,1,'55','0',NULL,'6','EASY','mul',4,4,'N'),(465,1,'80','0',NULL,'6','EASY','mul',5,5,'N'),(466,1,'99','0',NULL,'6','EASY','mul',6,6,'N'),(467,1,'43','0',NULL,'6','EASY','mul',7,7,'N'),(468,1,'23','0',NULL,'6','EASY','mul',8,8,'N'),(469,1,'38','0',NULL,'6','EASY','mul',9,9,'N'),(470,1,'97','0',NULL,'6','EASY','mul',10,10,'Y'),(471,1,'23','0',NULL,'6','EASY','mul',11,11,'Y'),(472,1,'71','0',NULL,'6','EASY','mul',12,12,'Y'),(473,1,'134','0',NULL,'6','MEDIUM','mul',1,1,'N'),(474,1,'127','0',NULL,'6','MEDIUM','mul',2,2,'N'),(475,1,'118','0',NULL,'6','MEDIUM','mul',3,3,'N'),(476,1,'107','0',NULL,'6','MEDIUM','mul',4,4,'N'),(477,1,'94','0',NULL,'6','MEDIUM','mul',5,5,'N'),(478,1,'219','0',NULL,'6','MEDIUM','mul',6,6,'N'),(479,1,'83','0',NULL,'6','MEDIUM','mul',7,7,'Y'),(480,1,'1295','0',NULL,'9','HARD','mul',1,1,'N'),(481,1,'2495','0',NULL,'6','HARD','mul',2,2,'N'),(482,1,'3239','0',NULL,'6','HARD','mul',3,3,'N'),(483,1,'4535','0',NULL,'6','HARD','mul',4,4,'N'),(484,1,'5765','0',NULL,'6','HARD','mul',5,5,'N'),(485,1,'8345','0',NULL,'6','HARD','mul',6,6,'N'),(486,1,'10857','0',NULL,'6','HARD','mul',7,7,'N'),(487,1,'13109','0',NULL,'6','HARD','mul',8,8,'N'),(488,1,'16156','0',NULL,'6','HARD','mul',9,9,'N'),(489,1,'19037','0',NULL,'6','HARD','mul',10,10,'Y'),(490,1,'220','0',NULL,'6','HARD','mul',11,11,'Y'),(491,1,'299','0',NULL,'6','HARD','mul',12,12,'Y'),(492,1,'134','0',NULL,'6','MEDIUM','mul',1,1,'N'),(493,1,'127','0',NULL,'6','MEDIUM','mul',2,2,'N'),(494,1,'118','0',NULL,'6','MEDIUM','mul',3,3,'N'),(495,1,'107','0',NULL,'6','MEDIUM','mul',4,4,'N'),(496,1,'94','0',NULL,'6','MEDIUM','mul',5,5,'N'),(497,1,'219','0',NULL,'6','MEDIUM','mul',6,6,'N'),(498,1,'83','0',NULL,'6','MEDIUM','mul',7,7,'N'),(499,1,'65','0',NULL,'6','MEDIUM','mul',8,8,'N'),(500,1,'160','0',NULL,'7','MEDIUM','mul',9,9,'N'),(501,1,'191','0',NULL,'6','MEDIUM','mul',10,10,'Y'),(502,1,'34','0',NULL,'6','MEDIUM','mul',11,11,'Y'),(503,1,'89','0',NULL,'6','MEDIUM','mul',12,12,'Y'),(504,1,'62','0',NULL,'9','HARD','div',1,1,'Y'),(505,1,'44','0',NULL,'6','HARD','div',2,2,'Y'),(506,1,'53','0',NULL,'6','HARD','div',3,3,'Y'),(507,1,'61','0',NULL,'6','HARD','div',4,4,'N'),(508,1,'69','0',NULL,'6','HARD','div',5,5,'N'),(509,1,'71','0',NULL,'6','HARD','div',6,6,'N'),(510,1,'85','0',NULL,'8','HARD','div',7,7,'N'),(511,1,'95','0',NULL,'6','HARD','div',8,8,'N'),(512,1,'100','0',NULL,'6','HARD','div',9,9,'N'),(513,1,'107','0',NULL,'6','HARD','div',10,10,'Y'),(514,1,'11','0',NULL,'6','HARD','div',11,11,'N'),(515,1,'19','0',NULL,'6','HARD','div',12,12,'N'),(516,1,'11','0',NULL,'6','MEDIUM','div',1,1,'Y'),(517,1,'14','0',NULL,'6','MEDIUM','div',2,2,'Y'),(518,1,'23','0',NULL,'6','MEDIUM','div',3,3,'Y'),(519,1,'20','0',NULL,'6','MEDIUM','div',4,4,'N'),(520,1,'23','0',NULL,'6','MEDIUM','div',5,5,'N'),(521,1,'24','0',NULL,'6','MEDIUM','div',6,6,'N'),(522,1,'26','0',NULL,'6','MEDIUM','div',7,7,'N'),(523,1,'35','0',NULL,'6','MEDIUM','div',8,8,'N'),(524,1,'30','0',NULL,'6','MEDIUM','div',9,9,'Y'),(525,1,'31','0',NULL,'6','MEDIUM','div',10,10,'Y'),(526,1,'5','0',NULL,'6','MEDIUM','div',11,11,'N'),(527,1,'8','0',NULL,'6','MEDIUM','div',12,12,'N'),(528,4,'25','0',NULL,'2','MEDIUM','div',4,NULL,NULL),(529,4,'21','1',NULL,'4','MEDIUM','div',4,NULL,NULL),(530,4,'17','0',NULL,'4','MEDIUM','mul',3,NULL,NULL),(531,4,'3','0',NULL,'2','MEDIUM','mul',3,NULL,NULL),(532,4,'5','0',NULL,'3','MEDIUM','mul',5,NULL,NULL),(533,4,'941','0',NULL,'4','MEDIUM','mul',5,NULL,NULL),(534,4,'95','1',NULL,'5','MEDIUM','mul',5,NULL,NULL),(535,4,'24','1',NULL,'3','MEDIUM','div',5,NULL,NULL),(536,4,'19','0',NULL,'6','MEDIUM','add',1,NULL,NULL),(537,4,'123','0',NULL,'4','MEDIUM','div',1,NULL,NULL),(538,4,'10','0',NULL,'3','MEDIUM','add',7,NULL,NULL),(539,4,'12','0',NULL,'5','MEDIUM','add',7,NULL,NULL),(540,4,'1020','0',NULL,'5','MEDIUM','mul',6,NULL,NULL),(541,4,'220','1',NULL,'2','MEDIUM','mul',6,NULL,NULL),(542,4,'20','1',NULL,'5','MEDIUM','add',1,NULL,NULL),(543,4,'25','0',NULL,'3','MEDIUM','div',2,NULL,NULL),(544,4,'15','1',NULL,'3','MEDIUM','div',2,NULL,NULL),(545,4,'161','1',NULL,'5','MEDIUM','mul',9,NULL,NULL),(546,4,'545','0',NULL,'7','MEDIUM','add',5,NULL,NULL),(547,4,'36','1',NULL,'3','MEDIUM','div',8,NULL,NULL),(548,4,'49','0',NULL,'5','MEDIUM','add',8,NULL,NULL),(549,4,'46','0',NULL,'13','MEDIUM','add',8,NULL,NULL),(550,4,'98','0',NULL,'4','MEDIUM','add',6,NULL,NULL),(551,4,'90','1',NULL,'6','MEDIUM','add',6,NULL,NULL),(552,4,'39','1',NULL,'5','MEDIUM','add',2,NULL,NULL),(553,4,'25','0',NULL,'8','MEDIUM','div',7,NULL,NULL),(554,4,'27','1',NULL,'5','MEDIUM','div',7,NULL,NULL),(555,4,'10','0',NULL,'3','MEDIUM','mul',4,NULL,NULL),(556,4,'108','1',NULL,'13','MEDIUM','mul',4,NULL,NULL),(557,4,'12','0',NULL,'7','MEDIUM','add',9,NULL,NULL),(558,4,'107','1',NULL,'5','MEDIUM','add',9,NULL,NULL),(559,4,'15','0',NULL,'4','MEDIUM','mul',9,NULL,NULL),(560,4,'16','0',NULL,'6','MEDIUM','div',3,NULL,NULL),(561,4,'24','1',NULL,'26','MEDIUM','div',3,NULL,NULL),(562,4,'24','1',NULL,'4','MEDIUM','div',3,NULL,NULL),(563,4,'6','0',NULL,'3','MEDIUM','mul',7,NULL,NULL),(564,4,'21','1',NULL,'4','MEDIUM','div',4,NULL,NULL),(565,4,'56','0',NULL,'4','MEDIUM','sub',6,NULL,NULL),(566,4,'59','1',NULL,'7','MEDIUM','sub',6,NULL,NULL),(567,4,'59','1',NULL,'3','MEDIUM','sub',6,NULL,NULL),(568,4,'68','0',NULL,'4','MEDIUM','sub',7,NULL,NULL),(569,4,'66','1',NULL,'7','MEDIUM','sub',7,NULL,NULL),(570,4,'2','0',NULL,'3','MEDIUM','add',4,NULL,NULL),(571,4,'16','0',NULL,'7','MEDIUM','div',1,NULL,NULL),(572,4,'12','1',NULL,'3','MEDIUM','div',1,NULL,NULL),(573,4,'6','0',NULL,'2','MEDIUM','sub',1,NULL,NULL),(574,4,'107','1',NULL,'7','MEDIUM','add',9,NULL,NULL),(575,4,'10','0',NULL,'5','MEDIUM','mul',3,NULL,NULL),(576,4,'10','0',NULL,'6','MEDIUM','mul',2,NULL,NULL),(577,4,'10','0',NULL,'3','MEDIUM','mul',2,NULL,NULL),(578,4,'44','1','2024-03-17','12','EASY','mul',7,NULL,NULL),(579,4,'5','1','2024-03-17','3','EASY','sub',1,NULL,NULL),(580,4,'10','1','2024-03-17','4','EASY','div',7,NULL,NULL),(581,4,'6','1','2024-03-17','3','EASY','mul',1,NULL,NULL),(582,4,'26','1','2024-03-17','5','EASY','sub',9,NULL,NULL),(583,4,'20','1','2024-03-17','2','EASY','mul',2,NULL,NULL),(584,4,'5','1','2024-03-17','2','EASY','div',5,NULL,NULL),(585,4,'14','1','2024-03-17','9','EASY','add',2,NULL,NULL),(586,4,'2','0','2024-03-17','4','EASY','mul',3,NULL,NULL),(587,4,'3','0','2024-03-17','6','EASY','mul',3,NULL,NULL),(588,4,'100','1','2024-03-17','4','EASY','mul',6,NULL,NULL),(589,4,'1','0','2024-03-17','5','EASY','sub',7,NULL,NULL),(590,4,'45','0','2024-03-17','6','EASY','add',8,NULL,NULL),(591,4,'24','1','2024-03-17','14','EASY','add',8,NULL,NULL),(592,4,'5','0','2024-03-17','3','EASY','sub',2,NULL,NULL),(593,4,'7','1','2024-03-17','27','EASY','sub',2,NULL,NULL),(594,4,'10','1','2024-03-17','9','EASY','div',9,NULL,NULL),(595,4,'6','0','2024-03-17','4','EASY','div',4,NULL,NULL),(596,4,'54','0','2024-03-17','6','EASY','div',6,NULL,NULL),(597,4,'2','0','2024-03-17','4','EASY','div',6,NULL,NULL),(598,4,'10','1','2024-03-17','4','EASY','add',3,NULL,NULL),(599,4,'81','1','2024-03-17','4','EASY','mul',5,NULL,NULL),(600,4,'51','0','2024-03-17','3','EASY','sub',6,NULL,NULL),(601,4,'17','1','2024-03-17','37','EASY','sub',6,NULL,NULL),(602,4,'5','0','2024-03-17','3','EASY','div',3,NULL,NULL),(603,4,'4','0','2024-03-17','5','EASY','div',3,NULL,NULL),(604,4,'48','0','2024-03-17','5','EASY','add',7,NULL,NULL),(605,4,'46','1','2024-03-17','4','EASY','add',7,NULL,NULL),(606,4,'43','0','2024-03-17','4','EASY','add',7,NULL,NULL),(607,4,'46','1','2024-03-17','14','EASY','add',7,NULL,NULL),(608,4,'5','1','2024-03-17','3','EASY','div',4,NULL,NULL),(609,4,'20','1','2024-03-17','3','EASY','sub',7,NULL,NULL),(610,4,'36','0','2024-03-17','3','EASY','mul',9,NULL,NULL),(611,4,'39','1','2024-03-17','2','EASY','mul',9,NULL,NULL),(612,4,'17','1','2024-03-17','4','EASY','sub',6,NULL,NULL),(613,4,'5','1','2024-03-17','3','EASY','div',6,NULL,NULL),(614,4,'72','0','2024-03-17','3','EASY','add',8,NULL,NULL),(615,4,'72','0','2024-03-17','2','EASY','add',8,NULL,NULL),(616,4,'7','0','2024-03-17','2','EASY','div',4,NULL,NULL),(617,4,'7','0','2024-03-17','2','EASY','div',4,NULL,NULL),(618,4,'7','0','2024-03-17','4','EASY','div',4,NULL,NULL),(619,4,'10','1','2024-03-19','3','EASY','div',8,NULL,NULL),(620,4,'55','0','2024-03-19','2','EASY','add',9,NULL,NULL),(621,4,'55','0','2024-03-19','3','EASY','add',9,NULL,NULL),(622,4,'5','0','2024-03-19','5','EASY','add',9,NULL,NULL),(623,4,'10','1','2024-03-19','6','EASY','div',7,NULL,NULL),(624,4,'5','0','2024-03-19','2','EASY','mul',8,NULL,NULL),(625,4,'24','1','2024-03-19','6','EASY','mul',8,NULL,NULL),(626,4,'20','0','2024-03-19','3','EASY','div',5,NULL,NULL),(627,4,'5','1','2024-03-19','4','EASY','div',5,NULL,NULL),(628,4,'90','1','2024-03-20','8','MEDIUM','add',6,NULL,NULL),(629,4,'65','1','2024-03-24','13','MEDIUM','sub',8,NULL,NULL);
/*!40000 ALTER TABLE `results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `idstudents` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `school` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `class` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idstudents`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'17mahays','2QWERTY@q','q','S@S','9'),(2,'17mg','$2a$10$theSaltValue123456789ulWOIdF/rSU1ybwcpEJY5b6IVb9aRhJy','q','@','9'),(3,'loon','$2a$10$theSaltValue123456789u3ZePL0DgGFHrvnREjDxiTWvsI5cuDWC','q','@','9'),(4,'1','$2a$10$theSaltValue123456789ubPMSE6KACi/VZ5z6hS0dumaBVykX/gm','q','q@','9'),(5,'x','$2a$10$theSaltValue123456789ukcdqUF0N/1opaQB3/QvVVGIkXOAAseO','q','@','9'),(6,'bobby','$2a$10$theSaltValue123456789ubPMSE6KACi/VZ5z6hS0dumaBVykX/gm','q','@','9'),(7,'sega','$2a$10$theSaltValue123456789ubPMSE6KACi/VZ5z6hS0dumaBVykX/gm','q','d@','9'),(8,'3','$2a$10$theSaltValue123456789u2dKx/E3YwRp2/ppbdfLhYtxzhNM27WK','3','@',NULL),(9,'4','$2a$10$theSaltValue123456789uZ5drqy/4tCNMCq/Y9HLfr.lKe86HL3q','q','@','9');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sube`
--

DROP TABLE IF EXISTS `sube`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sube` (
  `idsube` int NOT NULL AUTO_INCREMENT,
  `qtext` varchar(45) DEFAULT NULL,
  `qanswer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idsube`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sube`
--

LOCK TABLES `sube` WRITE;
/*!40000 ALTER TABLE `sube` DISABLE KEYS */;
INSERT INTO `sube` VALUES (1,'What is 8 - 3?','5'),(2,'What is 12 - 5?','7'),(3,'What is 15 - 7?','8'),(4,'What is 20 - 9?','11'),(5,'What is 25 - 11?','14'),(6,'What is 30 - 13?','17'),(7,'What is 35 - 15?','20'),(8,'What is 40 - 17?','23'),(9,'What is 45 - 19?','26'),(10,'What is 50 - 21?','29'),(11,'What is 8 - 3?','5'),(12,'What is 17 - 9?','8');
/*!40000 ALTER TABLE `sube` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subh`
--

DROP TABLE IF EXISTS `subh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subh` (
  `idsubh` int NOT NULL AUTO_INCREMENT,
  `qtext` varchar(45) DEFAULT NULL,
  `qanswer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idsubh`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subh`
--

LOCK TABLES `subh` WRITE;
/*!40000 ALTER TABLE `subh` DISABLE KEYS */;
INSERT INTO `subh` VALUES (1,'What is 248 - 173?','75'),(2,'What is 287 - 214?','73'),(3,'What is 323 - 248?','75'),(4,'What is 368 - 292?','76'),(5,'What is 402 - 318?','84'),(6,'What is 437 - 349?','88'),(7,'What is 481 - 396?','85'),(8,'What is 527 - 432?','95'),(9,'What is 562 - 469?','93'),(10,'What is 610 - 513?','97'),(11,'What is 38 - 19?','19'),(12,'What is 55 - 25?','30');
/*!40000 ALTER TABLE `subh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subm`
--

DROP TABLE IF EXISTS `subm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subm` (
  `idsubm` int NOT NULL AUTO_INCREMENT,
  `qtext` varchar(45) DEFAULT NULL,
  `qanswer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idsubm`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subm`
--

LOCK TABLES `subm` WRITE;
/*!40000 ALTER TABLE `subm` DISABLE KEYS */;
INSERT INTO `subm` VALUES (1,'What is 36 - 18?','18'),(2,'What is 79 - 48?','31'),(3,'What is 94 - 57?','37'),(4,'What is 108 - 63?','45'),(5,'What is 123 - 76?','47'),(6,'What is 148 - 89?','59'),(7,'What is 163 - 97?','66'),(8,'What is 177 - 112?','65'),(9,'What is 195 - 134?','61'),(10,'What is 212 - 156?','56'),(11,'What is 12 - 6?','6'),(12,'What is 30 - 13?','17');
/*!40000 ALTER TABLE `subm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacherresults`
--

DROP TABLE IF EXISTS `teacherresults`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacherresults` (
  `idteacherResults` int NOT NULL AUTO_INCREMENT,
  `idStudent` int DEFAULT NULL,
  `idTeacher` int DEFAULT NULL,
  `SAnswers` varchar(45) DEFAULT NULL,
  `correct` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  `difficulty` varchar(45) DEFAULT NULL,
  `topic` varchar(45) DEFAULT NULL,
  `questionid` varchar(45) DEFAULT NULL,
  `quizid` int DEFAULT NULL,
  PRIMARY KEY (`idteacherResults`),
  KEY `Sid_idx` (`idStudent`),
  KEY `qid_idx` (`quizid`),
  KEY `Tid_idx` (`idTeacher`),
  CONSTRAINT `qid` FOREIGN KEY (`quizid`) REFERENCES `teachersetquiz` (`idTeacherSetQuiz`),
  CONSTRAINT `Sid` FOREIGN KEY (`idStudent`) REFERENCES `students` (`idstudents`),
  CONSTRAINT `Tid` FOREIGN KEY (`idTeacher`) REFERENCES `teachers` (`idteachers`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacherresults`
--

LOCK TABLES `teacherresults` WRITE;
/*!40000 ALTER TABLE `teacherresults` DISABLE KEYS */;
INSERT INTO `teacherresults` VALUES (31,4,2,'59','1','2024-03-23','4','MEDIUM','sub','6',12),(32,4,2,'31','1','2024-03-23','6','MEDIUM','div','9',12),(33,4,2,'18','1','2024-03-23','9','MEDIUM','sub','1',12),(34,4,2,'37','1','2024-03-23','4','MEDIUM','sub','3',12),(35,4,2,'12','1','2024-03-23','2','MEDIUM','div','1',12),(36,4,2,'55','1','2024-03-23','1','MEDIUM','add','4',12),(37,4,2,'70','1','2024-03-23','3','MEDIUM','add','7',12),(38,4,2,'37','1','2024-03-23','2','MEDIUM','sub','3',12),(39,4,2,'65','0','2024-03-23','4','MEDIUM','sub','8',12),(40,4,2,'65','1','2024-03-23','6','MEDIUM','sub','8',12),(41,4,2,'50','1','2024-03-23','3','MEDIUM','add','8',13),(42,4,2,'39','1','2024-03-23','2','MEDIUM','add','2',13),(43,4,2,'66','1','2024-03-23','4','MEDIUM','sub','7',13),(44,4,2,'84','1','2024-03-23','3','MEDIUM','mul','7',13),(45,4,2,'31','1','2024-03-23','3','MEDIUM','sub','2',13),(46,4,2,'119','1','2024-03-23','2','MEDIUM','mul','3',13),(47,4,2,'84','0','2024-03-23','2','MEDIUM','mul','7',13),(48,4,2,'84','1','2024-03-23','7','MEDIUM','mul','7',13),(49,4,2,'84','1','2024-03-23','4','MEDIUM','mul','7',13),(50,4,2,'47','1','2024-03-23','4','MEDIUM','sub','5',13);
/*!40000 ALTER TABLE `teacherresults` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teachers` (
  `idteachers` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `school` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idteachers`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (1,'2','$2a$10$theSaltValue123456789uZEOEyJiC3hZAnJQ0R73mwCbF1u9P4Ya','q','@'),(2,'14','$2a$10$theSaltValue123456789ui9WDVydVjxM9tb6u0YnMCeTQ7DXTzIW','14','@');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachersetquiz`
--

DROP TABLE IF EXISTS `teachersetquiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teachersetquiz` (
  `idTeacherSetQuiz` int NOT NULL AUTO_INCREMENT,
  `teacher` varchar(45) DEFAULT NULL,
  `class` varchar(45) DEFAULT NULL,
  `quiztype` varchar(45) DEFAULT NULL,
  `spec` varchar(45) DEFAULT NULL,
  `difficulty` varchar(45) DEFAULT NULL,
  `duedate` date DEFAULT NULL,
  PRIMARY KEY (`idTeacherSetQuiz`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachersetquiz`
--

LOCK TABLES `teachersetquiz` WRITE;
/*!40000 ALTER TABLE `teachersetquiz` DISABLE KEYS */;
INSERT INTO `teachersetquiz` VALUES (5,'2','9','norm','10','EASY','3111-02-20'),(6,'2','9','time','100','MEDIUM','1999-12-20'),(7,'2','9','norm','5','EASY','1998-12-20'),(8,'2','9','time','50','EASY','1879-12-20'),(9,'2','9','norm','6','EASY','2030-12-20'),(10,'2','9','norm','2','EASY','2030-12-20'),(11,'2','9','norm','3','EASY','2030-12-20'),(12,'2','13','norm','10','MEDIUM','2000-12-20'),(13,'2','13','norm','10','MEDIUM','1066-11-21'),(14,'2','13','norm','4','EASY','2022-03-04'),(15,'2','13','time','10','HARD','2202-02-02'),(16,'2','13','norm','10','HARD','0001-01-01');
/*!40000 ALTER TABLE `teachersetquiz` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-24 11:29:16
