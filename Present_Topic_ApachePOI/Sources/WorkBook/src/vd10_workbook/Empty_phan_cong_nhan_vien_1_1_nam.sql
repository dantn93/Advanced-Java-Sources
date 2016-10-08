-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2016 at 07:13 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phan_cong_nhan_vien_1_1_nam`
--
CREATE DATABASE IF NOT EXISTS `phan_cong_nhan_vien_1_1_nam` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `phan_cong_nhan_vien_1_1_nam`;

-- --------------------------------------------------------

--
-- Table structure for table `cong_ty`
--

DROP TABLE IF EXISTS `cong_ty`;
CREATE TABLE `cong_ty` (
  `ID` int(11) NOT NULL,
  `Ten` varchar(200) DEFAULT NULL,
  `Dien_thoai` varchar(200) DEFAULT NULL,
  `Dia_chi` varchar(200) DEFAULT NULL,
  `Tuoi_toi_thieu` int(11) DEFAULT NULL,
  `Tuoi_toi_da` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `don_vi`
--

DROP TABLE IF EXISTS `don_vi`;
CREATE TABLE `don_vi` (
  `ID` int(11) NOT NULL,
  `Ten` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `kha_nang`
--

DROP TABLE IF EXISTS `kha_nang`;
CREATE TABLE `kha_nang` (
  `ID` int(11) NOT NULL,
  `ID_NHAN_VIEN` int(11) DEFAULT NULL,
  `ID_NGOAI_NGU` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `loai_cong_viec`
--

DROP TABLE IF EXISTS `loai_cong_viec`;
CREATE TABLE `loai_cong_viec` (
  `ID` int(11) NOT NULL,
  `Ten` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `ngoai_ngu`
--

DROP TABLE IF EXISTS `ngoai_ngu`;
CREATE TABLE `ngoai_ngu` (
  `ID` int(11) NOT NULL,
  `Ten` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `nguoi_dung`
--

DROP TABLE IF EXISTS `nguoi_dung`;
CREATE TABLE `nguoi_dung` (
  `ID` int(11) NOT NULL,
  `Ten` varchar(200) DEFAULT NULL,
  `Mat_khau` varchar(200) DEFAULT NULL,
  `Mo_rong` varchar(200) DEFAULT NULL,
  `ID_NHOM_NGUOI_DUNG` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `nhan_vien`
--

DROP TABLE IF EXISTS `nhan_vien`;
CREATE TABLE `nhan_vien` (
  `ID` int(11) NOT NULL,
  `Ho_ten` varchar(200) DEFAULT NULL,
  `Gioi_tinh` int(1) DEFAULT NULL,
  `Ngay_sinh` date DEFAULT NULL,
  `CMND` varchar(200) DEFAULT NULL,
  `Muc_luong` double DEFAULT NULL,
  `Dia_chi` varchar(200) DEFAULT NULL,
  `ID_DON_VI` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `nhom_nguoi_dung`
--

DROP TABLE IF EXISTS `nhom_nguoi_dung`;
CREATE TABLE `nhom_nguoi_dung` (
  `ID` int(11) NOT NULL,
  `Ten` varchar(200) DEFAULT NULL,
  `Ma_so` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `phieu_phan_cong`
--

DROP TABLE IF EXISTS `phieu_phan_cong`;
CREATE TABLE `phieu_phan_cong` (
  `ID` int(11) NOT NULL,
  `Ngay_bat_dau` date DEFAULT NULL,
  `So_ngay` int(11) DEFAULT NULL,
  `ID_NHAN_VIEN` int(11) DEFAULT NULL,
  `ID_LOAI_CONG_VIEC` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `yeu_cau`
--

DROP TABLE IF EXISTS `yeu_cau`;
CREATE TABLE `yeu_cau` (
  `ID` int(11) NOT NULL,
  `ID_LOAI_CONG_VIEC` int(11) DEFAULT NULL,
  `ID_NGOAI_NGU` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cong_ty`
--
ALTER TABLE `cong_ty`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `don_vi`
--
ALTER TABLE `don_vi`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `kha_nang`
--
ALTER TABLE `kha_nang`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `loai_cong_viec`
--
ALTER TABLE `loai_cong_viec`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `ngoai_ngu`
--
ALTER TABLE `ngoai_ngu`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `nguoi_dung`
--
ALTER TABLE `nguoi_dung`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `nhom_nguoi_dung`
--
ALTER TABLE `nhom_nguoi_dung`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `phieu_phan_cong`
--
ALTER TABLE `phieu_phan_cong`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `yeu_cau`
--
ALTER TABLE `yeu_cau`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cong_ty`
--
ALTER TABLE `cong_ty`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `don_vi`
--
ALTER TABLE `don_vi`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `kha_nang`
--
ALTER TABLE `kha_nang`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=351;
--
-- AUTO_INCREMENT for table `loai_cong_viec`
--
ALTER TABLE `loai_cong_viec`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `ngoai_ngu`
--
ALTER TABLE `ngoai_ngu`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `nguoi_dung`
--
ALTER TABLE `nguoi_dung`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=148;
--
-- AUTO_INCREMENT for table `nhan_vien`
--
ALTER TABLE `nhan_vien`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=141;
--
-- AUTO_INCREMENT for table `nhom_nguoi_dung`
--
ALTER TABLE `nhom_nguoi_dung`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `phieu_phan_cong`
--
ALTER TABLE `phieu_phan_cong`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1339;
--
-- AUTO_INCREMENT for table `yeu_cau`
--
ALTER TABLE `yeu_cau`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
