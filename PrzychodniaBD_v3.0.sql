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
INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (1, 'Okulickiego', '22', '37-450', 'Stalowa Wola');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (2, 'Poniatowskiego', '44', '44-444', 'Łódź');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (3, 'Rejtana', '99', '33-401', 'Rzeszów');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (4, 'Sobieskiego','23/24','57-000','Staszów');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (5, 'Myśliborska','29','46-422','Warszawa');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (6, 'Konopnickiej','451','33-401','Łódź');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (7, 'Inflacka','1A','35-401','Konstancin Jeziorna');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (8, 'Nowowiejska','97','75-435','Tychy');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (9, 'Bonifratów','451','00-441','Katowice');

INSERT INTO adresy (Adres_ID, Ulica, Nr_domu, Kod_pocztowy, Miejscowosc)
VALUES (10, 'Braci Wagów','64/3A','53-136','Lubawa');
/*!40000 ALTER TABLE `adresy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `konta`
--

DROP TABLE IF EXISTS `konta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `konta` (
  `Login` bigint NOT NULL,
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
/* Konta Administratorow */;
INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (111, '111', 1, 0, 0);
/* Konta Administratorow */;

/* Konta Lekarzy */;
INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (35412342, 'www', 0 ,1, 0);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (345164, 'eee', 0, 1 ,0);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (874457,'rrr',0,1,0);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (923456,'ttt',0,1,0);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (236576,'aaa',0,1,0);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (33335253,'ghh',0,1,0);
/* Konta Lekarzy */;

/* Konta Pacjentow */;
INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (312354,'yyy',0,0,1);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (67454,'uuu',0,0,1);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (96346,'iii',0,0,1);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (96347, 'ooo', 0, 0 ,1);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (96345, 'ppp', 0, 0 ,1);

INSERT INTO konta (Login, Haslo, Administrator, Lekarz, Pacjent)
VALUES (2222221122, 'ppp', 0, 0 ,1);
/* Konta Pacjentow */;

/* Konta ------------------------------------- */;




/* Pacjenci ----------------------------------- */;
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
  `Telefon` int NOT NULL,
  `Specjalizacja` varchar(64) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `Adres_ID` int NOT NULL,
  `PESEL` bigint NOT NULL,
  `e_mail` varchar(255) NOT NULL,
  PRIMARY KEY (`Lekarz_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lekarze`
--

LOCK TABLES `lekarze` WRITE;
/*!40000 ALTER TABLE `lekarze` DISABLE KEYS */;
INSERT INTO `lekarze` VALUES (1,'Roman','Kot',111123421,'Chirurg',1,35412342, 'rkot@przychodnia.pl');
INSERT INTO `lekarze` VALUES (2,'Lew','Sapiecha',923654321,'Internista',1,345164, 'lewsapiecha@przychodnia.pl');
INSERT INTO `lekarze` VALUES (3,'Damian','Rębala',323423432,'Neurolog',1,874457, 'damianrebala@przychodnia.pl');
INSERT INTO `lekarze` VALUES (4,'Daniel','Kęsy',987654567,'Kardiolog',1,923456, 'kesydaniel@przychodnia.pl');
INSERT INTO `lekarze` VALUES (5,'Rafał','Chmiel',987654367,'Internista',1,236576, 'chmiel223@przychodnia.pl');
INSERT INTO `lekarze` VALUES (7,'Jan','Kowalski',987654321,'Laryngolog',1,33335253, 'kowalski82@przychodnia.pl');
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
  `Telefon` int NOT NULL,
  `Adres_ID` int NOT NULL,
  `PESEL` bigint NOT NULL,
  `e_mail` varchar(255) NOT NULL,
  PRIMARY KEY (`Pacjent_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacjenci`
--

LOCK TABLES `pacjenci` WRITE;
/*!40000 ALTER TABLE `pacjenci` DISABLE KEYS */;
INSERT INTO `pacjenci` VALUES (1,'Robert','Pyzdra',454573423,1,312354, 'rpyzdra@przychodnia.pl');
INSERT INTO `pacjenci` VALUES (2,'Michał','Świtał',763233432,1,67454, 'mswital@przychodnia.pl');
INSERT INTO `pacjenci` VALUES (3,'Michalina','Głowacka',98753343,2,96346, 'michglowacka@przychodnia.pl');
INSERT INTO `pacjenci` VALUES (4,'Martyna','Rąbala',56235543,3,96347, 'rabala22@przychodnia.pl');
INSERT INTO `pacjenci` VALUES (5,'Bogumiła','Luba',84456742,4,96345, 'bluba223@przychodnia.pl');
INSERT INTO `pacjenci` VALUES (6,'Piotr','Nowak',654987321,2,2222221122, 'nowak293@przychodnia.pl');
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
