-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: przychodniadb
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `adresy`
--

DROP TABLE IF EXISTS `adresy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adresy` (
  `Adres_ID` int NOT NULL AUTO_INCREMENT,
  `Ulica` varchar(64) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `Nr_domu` varchar(10) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `Kod_pocztowy` varchar(6) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `Miejscowosc` varchar(64) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`Adres_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adresy`
--

LOCK TABLES `adresy` WRITE;
/*!40000 ALTER TABLE `adresy` DISABLE KEYS */;
INSERT INTO `adresy` VALUES (28,'Okulickiego','22','37-450','Stalowa Wola');
INSERT INTO `adresy` VALUES (29,'Poniatowskiego','44','44-444','?ód?');
INSERT INTO `adresy` VALUES (30,'Rejtana','99','33-401','Rzeszów');
INSERT INTO `adresy` VALUES (31,'Sobieskiego','23/24','57-000','Staszów');
INSERT INTO `adresy` VALUES (32,'Myśliborska','29','46-422','Warszawa');
INSERT INTO `adresy` VALUES (33,'Konopnickiej','451','33-401','Łódź');
INSERT INTO `adresy` VALUES (34,'Inflacka','1A','35-401','Konstancin Jeziorna');
INSERT INTO `adresy` VALUES (35,'Nowowiejska','97','75-435','Tychy');
INSERT INTO `adresy` VALUES (36,'Bonifratów','451','00-441','Katowice');
INSERT INTO `adresy` VALUES (37,'Braci Wagów','64/3A','53-136','Lubawa');
/*!40000 ALTER TABLE `adresy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `konta`
--

DROP TABLE IF EXISTS `konta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `konta` (
  `Login` int NOT NULL AUTO_INCREMENT,
  `Haslo` varchar(64) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `Administrator` tinyint(1) NOT NULL,
  `Lekarz` tinyint(1) NOT NULL,
  `Pacjent` tinyint(1) NOT NULL,
  PRIMARY KEY (`Login`)
) ENGINE=InnoDB AUTO_INCREMENT=923457 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `konta`
--

LOCK TABLES `konta` WRITE;
/*!40000 ALTER TABLE `konta` DISABLE KEYS */;
INSERT INTO `konta` VALUES (96345,'asdfasdf',0,0,1);
INSERT INTO `konta` VALUES (96347,'ytrewq',0,0,1);
INSERT INTO `konta` VALUES (111111,'qqq',0,1,0);
INSERT INTO `konta` VALUES (222222,'www',0,0,1);
INSERT INTO `konta` VALUES (236576,'qwerty',0,1,0);
INSERT INTO `konta` VALUES (333333,'eee',1,0,0);
INSERT INTO `konta` VALUES (345164,'23f3d1',1,1,0);
INSERT INTO `konta` VALUES (923456,'zxcvasdf',0,1,0);
/*!40000 ALTER TABLE `konta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lekarze`
--

DROP TABLE IF EXISTS `lekarze`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lekarze` (
  `Lekarz_ID` int NOT NULL AUTO_INCREMENT,
  `Imie` varchar(64) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `Nazwisko` varchar(64) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `PESEL` bigint NOT NULL,
  `Telefon` int NOT NULL,
  `Specjalizacja` varchar(64) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `Adres_ID` int NOT NULL,
  `Login` int NOT NULL,
  PRIMARY KEY (`Lekarz_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lekarze`
--

LOCK TABLES `lekarze` WRITE;
/*!40000 ALTER TABLE `lekarze` DISABLE KEYS */;
INSERT INTO `lekarze` VALUES (1,'Roman','Kot',56745678912,111123421,'Chirulg',1,35412342);
INSERT INTO `lekarze` VALUES (2,'Lew','Sapiecha',99312678912,923654321,'Internista',1,345164);
INSERT INTO `lekarze` VALUES (3,'Damian','Rębala',32645678912,323423432,'Neurolog',1,874457);
INSERT INTO `lekarze` VALUES (4,'Daniel','Kęsy',32645678912,987654567,'Kardiolog',1,923456);
INSERT INTO `lekarze` VALUES (5,'Rafał','Chmiel',32645678912,987654367,'Internista',1,236576);
INSERT INTO `lekarze` VALUES (7,'Jan','Kowalski',12345678912,987654321,'Laryngolog',1,111111);
/*!40000 ALTER TABLE `lekarze` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacjenci`
--

DROP TABLE IF EXISTS `pacjenci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pacjenci` (
  `Pacjent_ID` int NOT NULL AUTO_INCREMENT,
  `Imie` varchar(64) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `Nazwisko` varchar(64) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `PESEL` bigint NOT NULL,
  `Telefon` int NOT NULL,
  `Adres_ID` int NOT NULL,
  `Login` int NOT NULL,
  PRIMARY KEY (`Pacjent_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacjenci`
--

LOCK TABLES `pacjenci` WRITE;
/*!40000 ALTER TABLE `pacjenci` DISABLE KEYS */;
INSERT INTO `pacjenci` VALUES (1,'Robert','Pyzdra',8462432198,454573423,1,312354);
INSERT INTO `pacjenci` VALUES (2,'Michał','Świtał',547652986,763233432,1,67454);
INSERT INTO `pacjenci` VALUES (3,'Michalina','Głowacka',265328346,98753343,2,96346);
INSERT INTO `pacjenci` VALUES (4,'Martyna','Rąbala',6633463467,56235543,3,96347);
INSERT INTO `pacjenci` VALUES (5,'Bogumiła','Luba',856345735,84456742,4,96345);
INSERT INTO `pacjenci` VALUES (6,'Piotr','Nowak',98765432198,654987321,2,222222);
/*!40000 ALTER TABLE `pacjenci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wizyty`
--

DROP TABLE IF EXISTS `wizyty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wizyty` (
  `Wizyta_ID` int NOT NULL AUTO_INCREMENT,
  `Data` date NOT NULL,
  `Godzina` time NOT NULL,
  `Opis` varchar(128) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `Status` varchar(64) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `Pacjent_ID` int NOT NULL,
  `Lekarz_ID` int NOT NULL,
  PRIMARY KEY (`Wizyta_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wizyty`
--

LOCK TABLES `wizyty` WRITE;
/*!40000 ALTER TABLE `wizyty` DISABLE KEYS */;
INSERT INTO `wizyty` VALUES (1,'2020-03-10','12:30:00','Test uzębienia','Trwa',2,2);
INSERT INTO `wizyty` VALUES (2,'2020-06-12','12:30:00','Test nogi','Przełożona',3,1);
INSERT INTO `wizyty` VALUES (3,'2020-04-01','12:30:00','Test ramienia','Wygasła',4,1);
INSERT INTO `wizyty` VALUES (4,'2020-07-17','12:30:00','Test głowy','Umówiona',4,3);
INSERT INTO `wizyty` VALUES (5,'2020-03-10','12:30:00','Test','Oczekuj?ca',1,1);
INSERT INTO `wizyty` VALUES (6,'2020-06-22','12:30:00','Test nadgarstka','Oczekująca',5,5);
/*!40000 ALTER TABLE `wizyty` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-20 23:57:08
