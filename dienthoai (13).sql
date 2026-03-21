-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Mar 21, 2026 at 04:34 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dienthoai`
--

-- --------------------------------------------------------

--
-- Table structure for table `dienthoai`
--

CREATE TABLE `dienthoai` (
  `Ma` varchar(10) NOT NULL,
  `Ten` varchar(50) NOT NULL,
  `SoLuong` int(5) NOT NULL,
  `DonGia` int(10) NOT NULL,
  `DonViTinh` varchar(10) NOT NULL,
  `MaHang` varchar(10) NOT NULL,
  `BoNho` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `dienthoai`
--

INSERT INTO `dienthoai` (`Ma`, `Ten`, `SoLuong`, `DonGia`, `DonViTinh`, `MaHang`, `BoNho`) VALUES
('DT1', 'iPhone 15', 15, 22000000, 'Cái', 'H1', '128GB / 0 GB'),
('DT10', 'Xiaomi 14 Ultra', 8, 29000000, 'Cái', 'H3', '256GB / 0 GB'),
('DT11', 'Redmi Note 13', 30, 6000000, 'Cái', 'H3', '128GB / 1024 GB'),
('DT12', 'Redmi Note 13 Pro', 20, 8500000, 'Cái', 'H3', '256GB / 1024 GB'),
('DT13', 'Oppo Find X7', 12, 21000000, 'Cái', 'H4', '256GB / 0 GB'),
('DT14', 'Oppo Reno11', 18, 10500000, 'Cái', 'H4', '256GB / 0 GB'),
('DT15', 'Oppo Reno11 Pro', 10, 14500000, 'Cái', 'H4', '256GB / 0 GB'),
('DT16', 'Vivo V30', 15, 11000000, 'Cái', 'H5', '256GB / 0 GB'),
('DT17', 'Vivo V30 Pro', 10, 15000000, 'Cái', 'H5', '256GB / 0 GB'),
('DT18', 'Vivo X100', 8, 22000000, 'Cái', 'H5', '256GB / 0 GB'),
('DT19', 'Realme GT5', 12, 12000000, 'Cái', 'H6', '256GB / 0 GB'),
('DT2', 'iPhone 15 Plus', 10, 25000000, 'Cái', 'H1', '256GB / 0 GB'),
('DT20', 'Realme 12 Pro+', 20, 9500000, 'Cái', 'H6', '256GB / 0 GB'),
('DT21', 'Google Pixel 8', 10, 19000000, 'Cái', 'H7', '128GB / 0 GB'),
('DT22', 'Google Pixel 8 Pro', 7, 25000000, 'Cái', 'H7', '256GB / 0 GB'),
('DT23', 'OnePlus 12', 9, 21000000, 'Cái', 'H8', '256GB / 0 GB'),
('DT24', 'OnePlus Nord 3', 14, 11000000, 'Cái', 'H8', '256GB / 0 GB'),
('DT25', 'Huawei P60 Pro', 8, 24000000, 'Cái', 'H9', '256GB / 0 GB'),
('DT26', 'Huawei Mate 60', 7, 23000000, 'Cái', 'H9', '256GB / 0 GB'),
('DT27', 'Honor Magic 6', 9, 21000000, 'Cái', 'H10', '256GB / 0 GB'),
('DT28', 'Honor Magic 6 Pro', 6, 26000000, 'Cái', 'H10', '512GB / 0 GB'),
('DT29', 'Redmi 13', 25, 4200000, 'Cái', 'H3', '128GB / 1024 GB'),
('DT3', 'iPhone 15 Pro', 12, 28000000, 'Cái', 'H1', '256GB / 0 GB'),
('DT30', 'Samsung Galaxy A35', 22, 8200000, 'Cái', 'H2', NULL),
('DT31', 'iPhone 14', 12, 19000000, 'Cái', 'H1', NULL),
('DT4', 'iPhone 15 Pro Max', 8, 34000000, 'Cái', 'H1', NULL),
('DT5', 'Samsung Galaxy S24', 20, 21000000, 'Cái', 'H2', NULL),
('DT6', 'Samsung Galaxy S24+', 15, 25000000, 'Cái', 'H2', NULL),
('DT7', 'Samsung Galaxy S24 Ultra', 10, 31000000, 'Cái', 'H2', NULL),
('DT8', 'Samsung Galaxy A55', 25, 9500000, 'Cái', 'H2', NULL),
('DT9', 'Xiaomi 14', 20, 18000000, 'Cái', 'H3', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dienthoai`
--
ALTER TABLE `dienthoai`
  ADD PRIMARY KEY (`Ma`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
