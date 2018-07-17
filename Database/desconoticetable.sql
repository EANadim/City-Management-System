-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 26, 2018 at 02:21 PM
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
-- Table structure for table `desconoticetable`
--

CREATE TABLE `desconoticetable` (
  `date` varchar(100) NOT NULL,
  `descoNotice` varchar(100) NOT NULL,
  `sl` mediumint(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `desconoticetable`
--

INSERT INTO `desconoticetable` (`date`, `descoNotice`, `sl`) VALUES
('Thu Dec 28 23:37:11 BDT 2017', 'current dibo na ha ha', 1),
('Thu Dec 28 23:53:01 BDT 2017', 'code kaj korse', 2),
('Fri Dec 29 09:46:59 BDT 2017', 'current dibo na', 3),
('Fri Dec 29 09:47:12 BDT 2017', 'sobai mombati keno', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `desconoticetable`
--
ALTER TABLE `desconoticetable`
  ADD PRIMARY KEY (`sl`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `desconoticetable`
--
ALTER TABLE `desconoticetable`
  MODIFY `sl` mediumint(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
