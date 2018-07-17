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
-- Table structure for table `projectjava`
--

CREATE TABLE `projectjava` (
  `userId` varchar(14) NOT NULL,
  `accountType` varchar(14) NOT NULL,
  `accountHolderName` varchar(14) NOT NULL,
  `address` varchar(14) NOT NULL,
  `password` varchar(14) NOT NULL,
  `gasLineType` varchar(14) NOT NULL,
  `gasBill` int(8) NOT NULL,
  `electricityLineType` varchar(14) NOT NULL,
  `electricityBill` int(8) NOT NULL,
  `wasaLineType` varchar(14) NOT NULL,
  `wasaBill` int(8) NOT NULL,
  `tiasObjection` varchar(30) NOT NULL,
  `descoObjection` varchar(30) NOT NULL,
  `wasaObjection` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `projectjava`
--

INSERT INTO `projectjava` (`userId`, `accountType`, `accountHolderName`, `address`, `password`, `gasLineType`, `gasBill`, `electricityLineType`, `electricityBill`, `wasaLineType`, `wasaBill`, `tiasObjection`, `descoObjection`, `wasaObjection`) VALUES
('', 'homeOwner', '', '', '', '', 0, '', 0, '', 0, '', '', ''),
('11-11111-0', 'homeOwner', 'RAsAL', 'Rampura', '123', '', 0, '', 0, '', 0, '', '', ''),
('11-11111-1', 'admin', 'Batman', 'Gotham', '123456', '', 0, '', 0, '', 0, '', '', ''),
('33-33333-3', 'homeOwner', 'Rashed', 'Mirpur 13', '1234', '', 0, '', 550, 'residential', 224, '', 'cu theje', ''),
('44-44444-4', 'desco', 'Thor', 'Asgard', '321', '', 0, '', 0, '', 0, '', '', ''),
('55-55555-5', 'homeOwner', 'Shovon', 'Mirpur 10', '898989', '', 0, 'industrial', 560, 'commercial', 0, '', 'ora valo na', 'ora khub kahrap'),
('66-66666-6', 'wasa', 'Clark Kent', 'Metropolis', '343434', '', 0, '', 0, '', 0, '', '', ''),
('77-77777-7', 'homeOwner', 'Scott', 'Purbachal', '1234', '', 0, '', 0, '', 0, '', '', ''),
('88-88888-8', 'desco', 'Shakib', 'Magura', '75', '', 0, '', 0, '', 0, '', '', ''),
('99-99999-9', 'wasa', 'Nadim', 'Mirpur 12', '11223344', '', 0, '', 0, '', 0, '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `projectjava`
--
ALTER TABLE `projectjava`
  ADD PRIMARY KEY (`userId`),
  ADD KEY `accountType` (`accountType`),
  ADD KEY `accountType_2` (`accountType`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
