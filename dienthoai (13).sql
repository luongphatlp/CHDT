-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Mar 21, 2026 at 05:29 PM
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
  `BoNho` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `dienthoai`
--

INSERT INTO `dienthoai` (`Ma`, `Ten`, `SoLuong`, `DonGia`, `BoNho`) VALUES
('DTGG825', 'Google Pixel 8 Pro', 7, 25000000, '12GB / 256GB'),
('DTHW6051', 'Huawei Mate 60', 7, 23000000, '12GB / 512GB'),
('DTIP1510', 'iPhone 15 Pro Max', 8, 34000000, '8GB / 1TB'),
('DTIP1512', 'iPhone 15', 15, 22000000, '6GB / 128GB'),
('DTIP1525', 'iPhone 15 Plus', 10, 25000000, '6GB / 256GB'),
('DTIP1551', 'iPhone 15 Pro', 12, 28000000, '8GB / 512GB'),
('DTOP1225', 'OnePlus 12', 9, 21000000, '16GB / 256GB'),
('DTOPF725', 'Oppo Find X7', 12, 21000000, '12GB / 256GB'),
('DTOPR1125', 'Oppo Reno11 Pro', 10, 14500000, '12GB / 256GB'),
('DTRL1225', 'Realme 12 Pro+', 20, 9500000, '8GB / 256GB'),
('DTRM1312', 'Redmi Note 13', 30, 6000000, '6GB / 128GB'),
('DTSS2425', 'Samsung Galaxy S24', 20, 21000000, '8GB / 256GB'),
('DTSS2451', 'Samsung Galaxy S24 Ultra', 10, 31000000, '12GB / 512GB'),
('DTVVX125', 'Vivo X100', 8, 22000000, '12GB / 256GB'),
('DTXM1451', 'Xiaomi 14 Ultra', 8, 29000000, '16GB / 512GB');

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
