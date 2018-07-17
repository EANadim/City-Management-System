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
-- Table structure for table `specialnotice`
--

CREATE TABLE `specialnotice` (
  `date` varchar(100) NOT NULL,
  `notice` varchar(100) NOT NULL,
  `sl` mediumint(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `specialnotice`
--

INSERT INTO `specialnotice` (`date`, `notice`, `sl`) VALUES
('Fri Dec 29 00:15:21 BDT 2017', 'Notun Table banalam', 1),
('Fri Dec 29 00:24:39 BDT 2017', 'muri khao', 2),
('Fri Dec 29 23:42:50 BDT 2017', 'Testing again', 3),
('Sat Dec 30 22:00:11 BDT 2017', 'Updated version', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `specialnotice`
--
ALTER TABLE `specialnotice`
  ADD PRIMARY KEY (`sl`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `specialnotice`
--
ALTER TABLE `specialnotice`
  MODIFY `sl` mediumint(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
