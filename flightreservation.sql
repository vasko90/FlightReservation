-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: flightreservation
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flight_number` int(11) DEFAULT NULL,
  `operating_airlines` varchar(256) DEFAULT NULL,
  `departure_city` varchar(256) DEFAULT NULL,
  `arrival_city` varchar(256) DEFAULT NULL,
  `departure_date` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,2553,'Air Serbia','Belgrade','Podgorica','10-05-2018'),(2,1211,'Air Serbia','Belgrade','Rome','10-05-2018'),(3,3333,'Air Serbia','Belgrade','London','11-05-2018'),(4,7622,'Fly Emirates','Belgrade','Cairo','10-05-2018'),(5,233,'Montenegro Airlines','Belgrade','Podgorica','13-05-2018'),(6,9912,'Air France','Belgrade','Paris','14-05-2018'),(7,3221,'Montenegro Airlines','Podgorica','Belgrade','15-05-2018');
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passenger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(256) DEFAULT NULL,
  `lastname` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (1,'Mike','James','yyyyyyyyyyyyyyy@gmail.com'),(2,'Djoko','Nesanica','yyyyyyyyyyyyyyy@gmail.com'),(3,'Jane','Doe','yyyyyyyyyyyyyyy@gmail.com'),(4,'John','Mouse','yyyyyyyyyyyyyyy@gmail.com'),(5,'Mark','Coleman','yyyyyyyyyyyyyyy@gmail.com'),(6,'Ilija','Peras','yyyyyyyyyyyyyyy@gmail.com'),(7,'Mickey','Nesanica','yyyyyyyyyyyyyyy@gmail.com'),(8,'Mickey','Nesanica','yyyyyyyyyyyyyyy@gmail.com'),(9,'Mickey','Nesanica','yyyyyyyyyyyyyyy@gmail.com'),(10,'Jon','Jones','yyyyyyyyyyyyyyy@gmail.com'),(11,'Mickey','James','yyyyyyyyyyyyyyy@gmail.com'),(12,'Mickey','James','yyyyyyyyyyyyyyy@gmail.com'),(13,'Mark','Mouse','yyyyyyyyyyyyyyy@gmail.com'),(14,'Mark','Mouse','yyyyyyyyyyyyyyy@gmail.com'),(15,'Mark','Mouse','yyyyyyyyyyyyyyy@gmail.com'),(16,'Mickey','Nesanica','yyyyyyyyyyyyyyy@gmail.com'),(17,'Mike','James','yyyyyyyyyyyyyyy@gmail.com'),(18,'Jane','James','yyyyyyyyyyyyyyy@gmail.com'),(19,'Mickey','Mouse','yyyyyyyyyyyyyyy@gmail.com'),(20,'Mickey','Mouse','yyyyyyyyyyyyyyy@gmail.com'),(21,'Mickey','Mouse','yyyyyyyyyyyyyyy@gmail.com'),(22,'Mickey','Mouse','yyyyyyyyyyyyyyy@gmail.com'),(23,'Mickey','Mouse','yyyyyyyyyyyyyyy@gmail.com'),(24,'Mickey','Mouse','yyyyyyyyyyyyyyy@gmail.com'),(25,'Mickey','Mouse','yyyyyyyyyyyyyyy@gmail.com'),(26,'Mickey','Mouse','yyyyyyyyyyyyyyy@gmail.com'),(27,'Mickey','Mouse','yyyyyyyyyyyyyyy@gmail.com'),(28,'Mark','Mouse','yyyyyyyyyyyyyyy@gmail.com'),(29,'Mark','Mouse','yyyyyyyyyyyyyyy@gmail.com'),(30,'Mark','Mouse','yyyyyyyyyyyyyyy@gmail.com'),(31,'Mike','James','yyyyyyyyyyyyyyy@gmail.com'),(32,'John','Doe','yyyyyyyyyyyyyyy@gmail.com'),(33,'Johny','Doe','dsadasdadasdasdsaasd@gmail.com');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `checked_in` tinyint(1) DEFAULT NULL,
  `number_of_bags` int(11) DEFAULT NULL,
  `passenger_id` int(11) DEFAULT NULL,
  `flight_id` int(11) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `passenger_id` (`passenger_id`),
  KEY `flight_id` (`flight_id`),
  CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`passenger_id`) REFERENCES `passenger` (`id`),
  CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,1,2,1,6,'2018-08-12 11:49:36'),(2,1,1,2,3,'2018-08-12 11:54:02'),(3,1,16,3,3,'2018-08-12 13:29:08'),(4,1,3,4,6,'2018-08-12 18:07:28'),(5,0,0,5,3,'2018-08-12 21:23:55'),(6,0,0,6,3,'2018-08-15 20:17:47'),(7,1,2,7,3,'2018-08-15 20:36:44'),(8,0,0,8,3,'2018-08-15 20:47:56'),(9,0,0,9,3,'2018-08-15 20:47:58'),(10,0,0,10,3,'2018-08-16 12:02:04'),(11,0,0,11,3,'2018-08-16 12:32:09'),(12,0,0,12,3,'2018-08-16 12:42:05'),(13,0,0,13,1,'2018-08-16 13:13:19'),(14,0,0,14,1,'2018-08-16 13:27:37'),(15,0,0,15,1,'2018-08-16 13:29:06'),(16,0,0,16,3,'2018-08-25 11:33:30'),(17,0,0,17,3,'2018-08-25 11:37:58'),(18,1,2,18,3,'2018-08-25 11:41:39'),(19,0,0,19,3,'2018-08-25 11:45:43'),(20,0,0,20,3,'2018-08-25 11:51:49'),(21,0,0,21,3,'2018-08-25 11:52:02'),(22,1,3,22,3,'2018-08-25 12:12:13'),(23,0,0,23,3,'2018-08-25 12:13:25'),(24,0,0,24,3,'2018-08-25 12:13:55'),(25,0,0,25,3,'2018-08-25 12:17:51'),(26,0,0,26,3,'2018-08-25 12:19:52'),(27,0,0,27,3,'2018-08-25 12:19:55'),(28,0,0,28,6,'2018-08-25 14:36:45'),(29,0,0,29,6,'2018-08-25 15:00:22'),(30,1,3,30,6,'2018-08-25 15:00:30'),(31,0,0,31,3,'2018-08-25 20:20:24'),(32,0,0,32,3,'2018-08-26 13:30:05'),(33,0,0,33,3,'2018-08-26 13:43:29');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(256) DEFAULT NULL,
  `lastname` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (5,'Mark','Coleman','springbootdemomail@gmail.com','12345');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-26 15:45:44
