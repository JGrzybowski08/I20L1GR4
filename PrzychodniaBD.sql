-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 04 Cze 2020, 01:58
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

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `adresy`
--

CREATE TABLE `adresy` (
  `Adres_ID` int(11) NOT NULL,
  `Ulica` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `Nr_domu` varchar(10) COLLATE utf8_polish_ci NOT NULL,
  `Kod_pocztowy` varchar(6) COLLATE utf8_polish_ci NOT NULL,
  `Miejscowosc` varchar(64) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `konta`
--

CREATE TABLE `konta` (
  `Login` int(11) NOT NULL,
  `Haslo` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `Administrator` tinyint(1) NOT NULL,
  `Lekarz` tinyint(1) NOT NULL,
  `Pacjent` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `lekarze`
--

CREATE TABLE `lekarze` (
  `Lekarz_ID` int(11) NOT NULL,
  `Imie` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `Nazwisko` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `Email` varchar(128) COLLATE utf8_polish_ci NOT NULL,
  `PESEL` bigint(20) NOT NULL,
  `Telefon` int(9) NOT NULL,
  `Specjalizacja` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `Adres_ID` int(11) NOT NULL,
  `Login` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pacjenci`
--

CREATE TABLE `pacjenci` (
  `Pacjent_ID` int(11) NOT NULL,
  `Imie` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `Nazwisko` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `PESEL` bigint(20) NOT NULL,
  `Telefon` int(11) NOT NULL,
  `Adres_ID` int(11) NOT NULL,
  `Login` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wizyty`
--

CREATE TABLE `wizyty` (
  `Wizyta_ID` int(11) NOT NULL,
  `Data` varchar(10) COLLATE utf8_polish_ci NOT NULL,
  `Godzina` varchar(8) COLLATE utf8_polish_ci NOT NULL,
  `Opis` varchar(128) COLLATE utf8_polish_ci NOT NULL,
  `Status` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `Pacjent_ID` int(11) NOT NULL,
  `Lekarz_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `adresy`
--
ALTER TABLE `adresy`
  ADD PRIMARY KEY (`Adres_ID`);

--
-- Indeksy dla tabeli `konta`
--
ALTER TABLE `konta`
  ADD PRIMARY KEY (`Login`);
  

--
-- Indeksy dla tabeli `lekarze`
--
ALTER TABLE `lekarze`
  ADD PRIMARY KEY (`Lekarz_ID`);

--
-- Indeksy dla tabeli `pacjenci`
--
ALTER TABLE `pacjenci`
  ADD PRIMARY KEY (`Pacjent_ID`);

--
-- Indeksy dla tabeli `wizyty`
--
ALTER TABLE `wizyty`
  ADD PRIMARY KEY (`Wizyta_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `adresy`
--
ALTER TABLE `adresy`
  MODIFY `Adres_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `lekarze`
--
ALTER TABLE `lekarze`
  MODIFY `Lekarz_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `pacjenci`
--
ALTER TABLE `pacjenci`
  MODIFY `Pacjent_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `wizyty`
--
ALTER TABLE `wizyty`
  MODIFY `Wizyta_ID` int(11) NOT NULL AUTO_INCREMENT;
  
--
-- Insert konta administratora do tabeli `konta`
--
 INSERT INTO `konta` (`Login`, `Haslo`, `Administrator`, `Lekarz`, `Pacjent`) VALUES
(111, 'qqq', 1, 0, 0);
  
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
