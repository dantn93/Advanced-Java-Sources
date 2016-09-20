-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 20, 2016 at 10:46 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cdstore`
--
CREATE DATABASE IF NOT EXISTS `cdstore` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `cdstore`;

-- --------------------------------------------------------

--
-- Table structure for table `cd`
--

DROP TABLE IF EXISTS `cd`;
CREATE TABLE `cd` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL,
  `singer` varchar(150) NOT NULL,
  `numbersongs` int(11) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cd`
--

INSERT INTO `cd` (`id`, `name`, `singer`, `numbersongs`, `price`) VALUES
(1, 'nga', 'hoang', 3, 12000),
(2, 'ca', 'tom', 2, 10000),
(3, ' hang ', ' nga ', 10, 10),
(7, 'hoang', 'anh', 9, 9);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cd`
--
ALTER TABLE `cd`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cd`
--
ALTER TABLE `cd`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
