-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 04 Cze 2020, 01:59
-- Wersja serwera: 10.3.15-MariaDB
-- Wersja PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `przychodnia`
--

--
-- Zrzut danych tabeli `adresy`
--

INSERT INTO `adresy` (`Adres_ID`, `Ulica`, `Nr_domu`, `Kod_pocztowy`, `Miejscowosc`) VALUES
(1, 'Okulickiego', '22', '37-450', 'Stalowa Wola'),
(2, 'Poniatowskiego', '44', '44-444', 'Łódź'),
(3, 'Rejtana', '99', '33-401', 'Rzeszów'),
(4, 'Sobieskiego', '23/24', '57-000', 'Staszów'),
(5, 'Myśliborska', '29', '46-422', 'Warszawa'),
(6, 'Konopnickiej', '451', '33-401', 'Łódź'),
(7, 'Inflacka', '1A', '35-401', 'Konstancin Jeziorna'),
(8, 'Nowowiejska', '97', '75-435', 'Tychy'),
(9, 'Bonifratów', '451', '00-441', 'Katowice'),
(10, 'Braci Wagów', '64/3A', '53-136', 'Lubawa');

--
-- Zrzut danych tabeli `konta`
--

INSERT INTO `konta` (`Login`, `Haslo`, `Administrator`, `Lekarz`, `Pacjent`) VALUES
(222222, 'www', 0, 1, 0),
(333333, 'eee', 0, 1, 0),
(444444, 'rrr', 0, 1, 0),
(555555, 'ttt', 0, 1, 0),
(666666, 'yyy', 0, 0, 1),
(777777, 'uuu', 0, 0, 1),
(888888, 'iii', 0, 0, 1),
(999999, 'ooo', 0, 0, 1);

--
-- Zrzut danych tabeli `lekarze`
--

INSERT INTO `lekarze` (`Lekarz_ID`, `Imie`, `Nazwisko`, `Email`, `PESEL`, `Telefon`, `Specjalizacja`, `Adres_ID`, `Login`) VALUES
(1, 'Jan', 'Kowalski', 'test0', 78806243129, 229496313, 'Laryngolog', 1, 222222),
(2, 'Roman', 'Kot', 'etst1', 30265613965, 945695014, 'Chirulg', 2, 333333),
(3, 'Lew', 'Sapiecha', 'test2', 79154873985, 866789889, 'Internista', 3, 444444),
(4, 'Damian', 'Rębala', 'test3', 88765210869, 273935893, 'Neurolog', 4, 555555);

--
-- Zrzut danych tabeli `pacjenci`
--

INSERT INTO `pacjenci` (`Pacjent_ID`, `Imie`, `Nazwisko`, `PESEL`, `Telefon`, `Adres_ID`, `Login`) VALUES
(1, 'Piotr', 'Nowak', 98765432198, 167509275, 5, 666666),
(2, 'Robert', 'Pyzdra', 63982857188, 433277143, 6, 777777),
(3, 'Michał', 'Świtał', 34824963990, 613104320, 7, 888888),
(4, 'Michalina', 'Głowacka', 66774899715, 308714943, 8, 999999);

--
-- Zrzut danych tabeli `wizyty`
--

INSERT INTO `wizyty` (`Wizyta_ID`, `Data`, `Godzina`, `Opis`, `Status`, `Pacjent_ID`, `Lekarz_ID`) VALUES
(1, '2020-03-10', '11:45:00', 'Wizyta1', 'Odwołana', 1, 1),
(2, '2020-03-25', '15:15:00', 'Wizyta2', 'Zakończona', 2, 2),
(3, '2020-03-30', '13:00:00', 'Wizyta3', 'Zakończona', 3, 2),
(4, '2020-04-14', '09:00:00', 'Wizyta4', 'Odwołana', 4, 3),
(5, '2020-04-19', '10:30:00', 'Wizyta5', 'Zakończona', 5, 4),
(6, '2020-04-27', '11:45:00', 'Wizyta6', 'Odwołana', 1, 4),
(7, '2020-05-10', '14:00:00', 'Wizyta7', 'Zakończona', 2, 3),
(8, '2020-05-25', '13:45:00', 'Wizyta8', 'Oczekująca', 3, 2),
(9, '2020-05-29', '12:15:00', 'Wizyta9', 'Oczekująca', 4, 1),
(10, '2020-06-05', '11:00:00', 'Wizyta10', 'Oczekująca', 5, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
