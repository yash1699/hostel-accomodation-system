-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: has_project
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `boys_hostel`
--

DROP TABLE IF EXISTS `boys_hostel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boys_hostel` (
  `room_num` varchar(5) DEFAULT NULL,
  `room_type` varchar(20) DEFAULT NULL,
  `price` varchar(30) DEFAULT NULL,
  `available` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boys_hostel`
--

LOCK TABLES `boys_hostel` WRITE;
/*!40000 ALTER TABLE `boys_hostel` DISABLE KEYS */;
INSERT INTO `boys_hostel` VALUES ('101','Single Bed','RS.90000 p.a',0),('102','Single Bed','RS.90000 p.a',0),('201','Double Bed','RS.45000 p.a',0),('202','Double Bed','RS.45000 p.a',1),('203','Double Bed','RS.45000 p.a',2);
/*!40000 ALTER TABLE `boys_hostel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `girls_hostel`
--

DROP TABLE IF EXISTS `girls_hostel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `girls_hostel` (
  `room_num` varchar(5) DEFAULT NULL,
  `room_type` varchar(20) DEFAULT NULL,
  `price` varchar(30) DEFAULT NULL,
  `available` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `girls_hostel`
--

LOCK TABLES `girls_hostel` WRITE;
/*!40000 ALTER TABLE `girls_hostel` DISABLE KEYS */;
INSERT INTO `girls_hostel` VALUES ('101','Single Bed','RS.90000 p.a',0),('102','Single Bed','RS.90000 p.a',0),('201','Double Bed','RS.45000 p.a',0),('202','Double Bed','RS.45000 p.a',1),('203','Double Bed','RS.45000 p.a',2);
/*!40000 ALTER TABLE `girls_hostel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('admin','12345');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `name` varchar(30) DEFAULT NULL,
  `age` varchar(5) DEFAULT NULL,
  `gender` varchar(7) DEFAULT NULL,
  `en_num` varchar(50) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `course` varchar(30) DEFAULT NULL,
  `batch` varchar(30) DEFAULT NULL,
  `room_num` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES ('Yash Verma','21','male','12019009001184','9123788204','yash@gmail.com','B.Tech','2019','101'),('Amar Sharma','21','male','12018008010256','9876543021','amar@gmail.com','BHM','2018','201'),('Rohan Ghosh','20','male','12019009001256','7654981230','rohan@gmail.com','BBA','2019','102'),('Dhruba Haldar','20','male','12019009002764','8520147963','dhruba@gmail.com','BCA','2019','201'),('Arijit Sarkar','24','male','12021001008963','6549871023','arijit@gmail.com','M.Tech','2021','202'),('Neha Gupta','21','female','12019009004582','8641025793','neha@gmail.com','B.Tech','2019','101'),('Adrija Ghosh','22','female','12018008008514','7389456102','adrija@gmail.com','B.Tech','2018','201'),('Sneha Sharma','20','female','12019009007902','8297431560','sneha@gmail.com','BHM','2019','102'),('Payal Jha','19','female','12020002009025','9015478632','payal@gmail.com','BCA','2020','201'),('Sudeshna Sarkar','25','female','12020002008137','7980456288','sudeshna@gmail.com','MBA','2020','202');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-29 20:43:03
