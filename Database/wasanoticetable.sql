-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 26, 2018 at 02:20 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oop1`
--

-- --------------------------------------------------------

--
-- Table structure for table `wasanoticetable`
--

CREATE TABLE `wasanoticetable` (
  `date` varchar(100) NOT NULL,
  `wasaNotice` varchar(100) NOT NULL,
  `sl` mediumint(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wasanoticetable`
--

INSERT INTO `wasanoticetable` (`date`, `wasaNotice`, `sl`) VALUES
('Fri Dec 29 00:00:06 BDT 2017', 'Pani na kheye moro', 1),
('Fri Dec 29 00:27:51 BDT 2017', '', 2),
('Fri Dec 29 09:55:33 BDT 2017', 'panir ovabe moro', 3),
('Fri Dec 29 09:56:05 BDT 2017', 'pani kom kore use korba', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `wasanoticetable`
--
ALTER TABLE `wasanoticetable`
  ADD PRIMARY KEY (`sl`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `wasanoticetable`
--
ALTER TABLE `wasanoticetable`
  MODIFY `sl` mediumint(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
