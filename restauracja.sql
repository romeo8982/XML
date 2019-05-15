-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 15 Maj 2019, 23:52
-- Wersja serwera: 10.1.29-MariaDB
-- Wersja PHP: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `restauracja`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `danie`
--

CREATE TABLE `danie` (
  `ID` int(11) NOT NULL,
  `Nazwa` text COLLATE utf8_polish_ci NOT NULL,
  `Cena` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `danie`
--

INSERT INTO `danie` (`ID`, `Nazwa`, `Cena`) VALUES
(1, 'Sphagetti', 30.59),
(3, 'Pulpety', 15.67),
(4, 'Rosól', 11.32),
(5, 'Pierogi', 7.9),
(6, 'Rosól', 11.32),
(7, 'S', 423),
(8, 'Pajda chleba', 5.5),
(9, 'Pajda Chleba', 5.5),
(10, 'Pajda Chleba', 5.5),
(11, 'Pajda Chleba', 5.5),
(12, 'Pajda Chleba', 5.5),
(13, 'Pajda Chleba', 5.5),
(14, 'Pajda Chleba', 5.5),
(15, '321', 423);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `klient`
--

CREATE TABLE `klient` (
  `ID` int(11) NOT NULL,
  `Imie` text COLLATE utf8_polish_ci NOT NULL,
  `Nazwisko` text COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `klient`
--

INSERT INTO `klient` (`ID`, `Imie`, `Nazwisko`) VALUES
(1, 'Jagoda', 'Kowalska'),
(3, 'Kajko', 'Kokosz'),
(4, 'Tadeusz', 'Watróbka'),
(8, 'Michal', 'Aniol'),
(9, 'Michal', 'Aniol'),
(10, 'Michal', 'Aniol'),
(11, 'Michal', 'Aniol'),
(12, 'Michal', 'Aniol'),
(13, 'Michal', 'Aniol'),
(14, 'Michal', 'Aniol'),
(15, 'Michal', 'Aniol'),
(16, 'Michal', 'Aniol'),
(17, 'Kasia', 'Kowalska'),
(18, '31314', '41'),
(19, 'Jan', 'Kowalski');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zamowienie`
--

CREATE TABLE `zamowienie` (
  `ID` int(11) NOT NULL,
  `Id_klienta` int(11) NOT NULL,
  `Id_dania` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `zamowienie`
--

INSERT INTO `zamowienie` (`ID`, `Id_klienta`, `Id_dania`) VALUES
(1, 1, 4),
(2, 1, 1),
(3, 1, 4),
(4, 3, 4),
(5, 1, 3),
(6, 1, 3),
(7, 1, 3),
(8, 1, 3),
(9, 1, 3);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `danie`
--
ALTER TABLE `danie`
  ADD UNIQUE KEY `ID` (`ID`);

--
-- Indexes for table `klient`
--
ALTER TABLE `klient`
  ADD UNIQUE KEY `ID` (`ID`);

--
-- Indexes for table `zamowienie`
--
ALTER TABLE `zamowienie`
  ADD UNIQUE KEY `ID` (`ID`),
  ADD KEY `Id_dania` (`Id_dania`),
  ADD KEY `Id_klienta` (`Id_klienta`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `danie`
--
ALTER TABLE `danie`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT dla tabeli `klient`
--
ALTER TABLE `klient`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT dla tabeli `zamowienie`
--
ALTER TABLE `zamowienie`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `zamowienie`
--
ALTER TABLE `zamowienie`
  ADD CONSTRAINT `zamowienie_ibfk_1` FOREIGN KEY (`Id_dania`) REFERENCES `danie` (`ID`),
  ADD CONSTRAINT `zamowienie_ibfk_2` FOREIGN KEY (`Id_klienta`) REFERENCES `klient` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
