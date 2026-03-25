-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 22, 2026 at 02:26 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chdt`
--

-- --------------------------------------------------------

--
-- Table structure for table `baohanh`
--

CREATE TABLE `baohanh` (
  `MaBH` varchar(10) NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  `MaKH` varchar(10) NOT NULL,
  `NgayLap` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `baohanh`
--

INSERT INTO `baohanh` (`MaBH`, `MaNV`, `MaKH`, `NgayLap`) VALUES
('BH001', 'NV001', 'KH001', '2026-03-01'),
('BH002', 'NV002', 'KH005', '2026-03-05'),
('BH003', 'NV001', 'KH002', '2026-03-08'),
('BH004', 'NV003', 'KH008', '2026-03-10'),
('BH005', 'NV004', 'KH003', '2026-03-12'),
('BH006', 'NV002', 'KH009', '2026-03-14'),
('BH007', 'NV005', 'KH004', '2026-03-15'),
('BH008', 'NV001', 'KH010', '2026-03-18'),
('BH009', 'NV003', 'KH006', '2026-03-19'),
('BH010', 'NV002', 'KH007', '2026-03-20');

-- --------------------------------------------------------

--
-- Table structure for table `chitietbaohanh`
--

CREATE TABLE `chitietbaohanh` (
  `MaBH` varchar(10) NOT NULL,
  `IMEI` varchar(20) NOT NULL,
  `NgayHetBaoHanh` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chitietbaohanh`
--

INSERT INTO `chitietbaohanh` (`MaBH`, `IMEI`, `NgayHetBaoHanh`) VALUES
('BH001', '356789100000001', '2027-03-21'),
('BH001', '356789100000002', '2027-03-21'),
('BH002', '356789100000003', '2027-04-15'),
('BH003', '356789100000004', '2027-05-10'),
('BH003', '356789100000005', '2027-05-10'),
('BH004', '356789100000006', '2027-06-20'),
('BH005', '356789100000007', '2027-07-25'),
('BH006', '356789100000008', '2027-08-30'),
('BH007', '356789100000009', '2027-09-05'),
('BH008', '356789100000010', '2027-10-12'),
('BH01', '123456789211', '2026-03-22');

-- --------------------------------------------------------

--
-- Table structure for table `chitietdienthoai`
--

CREATE TABLE `chitietdienthoai` (
  `Ma` varchar(15) NOT NULL,
  `Mau` varchar(50) NOT NULL,
  `ManHinh` varchar(100) NOT NULL,
  `KichThuocManHInh` varchar(50) NOT NULL,
  `TenChip` varchar(100) NOT NULL,
  `BoNhoTrong` varchar(50) NOT NULL,
  `BoNhoNgoai` int(11) NOT NULL,
  `CameraTruoc` int(11) NOT NULL,
  `CameraSau` int(11) NOT NULL,
  `Pin` int(11) NOT NULL,
  `HeDieuHanh` varchar(50) NOT NULL,
  `ThoiHanBaoHanh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chitietdienthoai`
--

INSERT INTO `chitietdienthoai` (`Ma`, `Mau`, `ManHinh`, `KichThuocManHInh`, `TenChip`, `BoNhoTrong`, `BoNhoNgoai`, `CameraTruoc`, `CameraSau`, `Pin`, `HeDieuHanh`, `ThoiHanBaoHanh`) VALUES
('DTGG825', 'Obsidian', 'LTPO OLED', '6.7 inch', 'Google Tensor G3', '12GB', 256, 11, 50, 5050, 'Android', 12),
('DTHW6051', 'Black', 'LTPO OLED', '6.82 inch', 'Kirin 9000S', '12GB', 512, 13, 50, 5000, 'HarmonyOS', 12),
('DTIP1510', 'Natural Titanium', 'LTPO Super Retina XDR OLED', '6.7 inch', 'Apple A17 Pro', '8GB', 1024, 12, 48, 4441, 'iOS', 12),
('DTIP1512', 'Blue', 'Super Retina XDR OLED', '6.1 inch', 'Apple A16 Bionic', '6GB', 128, 12, 48, 3349, 'iOS', 12),
('DTIP1525', 'Pink', 'Super Retina XDR OLED', '6.7 inch', 'Apple A16 Bionic', '6GB', 256, 12, 48, 4383, 'iOS', 12),
('DTIP1551', 'White Titanium', 'LTPO Super Retina XDR OLED', '6.1 inch', 'Apple A17 Pro', '8GB', 512, 12, 48, 3274, 'iOS', 12),
('DTOP1225', 'Flowy Emerald', 'LTPO AMOLED', '6.82 inch', 'Snapdragon 8 Gen 3', '16GB', 256, 32, 50, 5400, 'Android', 12),
('DTOPF725', 'Ocean Blue', 'LTPO AMOLED', '6.82 inch', 'Dimensity 9300', '12GB', 256, 32, 50, 5000, 'Android', 12),
('DTOPR1125', 'Pearl White', 'AMOLED', '6.7 inch', 'Dimensity 8200', '12GB', 256, 32, 50, 4600, 'Android', 12),
('DTRL1225', 'Submarine Blue', 'AMOLED', '6.7 inch', 'Snapdragon 7s Gen 2', '8GB', 256, 32, 50, 5000, 'Android', 12),
('DTRM1312', 'Midnight Black', 'AMOLED', '6.67 inch', 'Snapdragon 685', '6GB', 128, 16, 108, 5000, 'Android', 12),
('DTSS2425', 'Amber Yellow', 'Dynamic LTPO AMOLED 2X', '6.2 inch', 'Exynos 2400', '8GB', 256, 12, 50, 4000, 'Android', 12),
('DTSS2451', 'Titanium Gray', 'Dynamic LTPO AMOLED 2X', '6.8 inch', 'Snapdragon 8 Gen 3', '12GB', 512, 12, 200, 5000, 'Android', 12),
('DTVVX125', 'Starrail Blue', 'LTPO AMOLED', '6.78 inch', 'Dimensity 9300', '12GB', 256, 32, 50, 5000, 'Android', 12),
('DTXM1451', 'Black', 'LTPO AMOLED', '6.73 inch', 'Snapdragon 8 Gen 3', '16GB', 512, 32, 50, 5000, 'Android', 12);

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MaHD` varchar(50) NOT NULL,
  `MaSP` varchar(50) NOT NULL,
  `SoLuong` int(10) NOT NULL,
  `DonGia` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MaHD`, `MaSP`, `SoLuong`, `DonGia`) VALUES
('HD01', 'DT01', 1, 22000000),
('HD02', 'DT02', 1, 25000000),
('HD03', 'DT07', 1, 31000000),
('HD04', 'DT09', 1, 18000000),
('HD05', 'DT05', 1, 21000000),
('HD06', 'DT16', 1, 11000000),
('HD07', 'DT08', 1, 9500000),
('HD08', 'DT15', 1, 14500000),
('HD09', 'DT11', 1, 6000000),
('HD10', 'DT30', 1, 8200000),
('HD11', 'DT01', 1, 22000000),
('HD12', 'DT02', 1, 25000000),
('HD13', 'DT01', 1, 22000000),
('HD14', 'DT01', 1, 22000000),
('HD15', 'DT01', 1, 22000000),
('HD16', 'DT01', 1, 22000000),
('HD17', 'DT01', 1, 22000000),
('HD18', 'DT02', 2, 25000000),
('HD19', 'DT01', 1, 22000000),
('HD20', 'DT01', 1, 22000000),
('HD21', 'DT01', 1, 22000000),
('HD22', 'DT01', 9, 22000000),
('HD23', 'DT12', 1, 8500000),
('HD24', 'DT02', 1, 24750000),
('HD25', 'DT02', 2, 24750000),
('HD26', 'DT21', 1, 19000000),
('HD27', 'DT02', 2, 24750000),
('HD28', 'DT03', 1, 28000000),
('HD29', 'DT11', 2, 6000000),
('HD30', 'DT02', 1, 24750000),
('HD31', 'DT02', 1, 24750000),
('HD32', 'DT03', 1, 28000000),
('HD33', 'DT10', 1, 29000000),
('HD34', 'DT02', 2, 24750000),
('HD35', 'DT02', 2, 24500000),
('HD36', 'DT2', 10, 25000000);

-- --------------------------------------------------------

--
-- Table structure for table `chitietkhuyenmai`
--

CREATE TABLE `chitietkhuyenmai` (
  `MaKhuyenMai` varchar(10) NOT NULL,
  `MaSanPham` varchar(10) NOT NULL,
  `PhanTram` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chitietkhuyenmai`
--

INSERT INTO `chitietkhuyenmai` (`MaKhuyenMai`, `MaSanPham`, `PhanTram`) VALUES
('KM001', 'DT001', 5),
('KM002', 'DT002', 10),
('KM003', 'DT003', 15),
('KM004', 'DT004', 5),
('KM005', 'DT005', 8),
('KM006', 'DT006', 10),
('KM007', 'DT007', 5),
('KM008', 'DT008', 20),
('KM009', 'DT009', 10),
('KM010', 'DT010', 15),
('KM011', 'DT011', 5),
('KM012', 'DT012', 12),
('KM013', 'DT013', 10),
('KM014', 'DT014', 25),
('KM015', 'DT015', 5),
('KM016', 'DT016', 10),
('KM017', 'DT017', 5),
('KM018', 'DT018', 15),
('KM019', 'DT019', 10),
('KM020', 'DT020', 8),
('KM021', 'DT021', 10),
('KM022', 'DT022', 15),
('KM023', 'DT023', 20),
('KM024', 'DT024', 20),
('KM025', 'DT025', 30);

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `MaPN` varchar(20) NOT NULL,
  `MaSP` varchar(10) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `TongTien` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`MaPN`, `MaSP`, `SoLuong`, `TongTien`) VALUES
('PN001', 'DT001', 3, 90000000),
('PN001', 'DT002', 2, 50000000),
('PN002', 'DT003', 4, 72000000),
('PN002', 'DT004', 1, 32000000),
('PN002', 'DT005', 2, 80000000),
('PN003', 'DT006', 5, 45000000),
('PN003', 'DT007', 2, 44000000),
('PN004', 'DT008', 10, 75000000),
('PN004', 'DT009', 2, 56000000),
('PN005', 'DT010', 5, 55000000),
('PN006', 'DT011', 2, 52000000),
('PN006', 'DT012', 4, 42000000),
('PN006', 'DT013', 3, 28500000),
('PN007', 'DT014', 10, 35000000),
('PN007', 'DT015', 1, 35000000),
('PN008', 'DT016', 2, 58000000),
('PN008', 'DT017', 2, 62000000),
('PN009', 'DT018', 3, 72000000),
('PN009', 'DT019', 2, 50000000),
('PN010', 'DT020', 2, 54000000),
('PN24439', 'DT21', 1, 19000000);

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

-- --------------------------------------------------------

--
-- Table structure for table `hang`
--

CREATE TABLE `hang` (
  `Ma` varchar(10) NOT NULL,
  `Ten` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hang`
--

INSERT INTO `hang` (`Ma`, `Ten`) VALUES
('H001', 'Apple'),
('H002', 'Samsung'),
('H003', 'Xiaomi'),
('H004', 'Oppo'),
('H005', 'Vivo'),
('H006', 'Realme'),
('H007', 'Nokia'),
('H008', 'Sony'),
('H009', 'Asus'),
('H010', 'Huawei'),
('H011', 'OnePlus'),
('H012', 'Google'),
('H013', 'Honor'),
('H014', 'Motorola'),
('H015', 'Lenovo'),
('H016', 'HTC'),
('H017', 'LG'),
('H018', 'ZTE'),
('H019', 'Meizu'),
('H020', 'BlackBerry'),
('H021', 'TCL'),
('H022', 'Alcatel'),
('H023', 'Tecno'),
('H024', 'Infinix'),
('H025', 'Itel');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` varchar(10) NOT NULL,
  `Ngay` datetime NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  `MaKH` varchar(10) NOT NULL,
  `TongTien` int(10) NOT NULL,
  `PTTT` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `Ngay`, `MaNV`, `MaKH`, `TongTien`, `PTTT`) VALUES
('HD01', '2026-03-01 00:00:00', 'NV02', 'KH01', 22000000, 'Tiền mặt'),
('HD02', '2026-03-02 00:00:00', 'NV03', 'KH02', 25000000, 'Chuyển khoản'),
('HD03', '2026-03-03 00:00:00', 'NV02', 'KH03', 31000000, 'Tiền mặt'),
('HD04', '2026-03-04 00:00:00', 'NV07', 'KH04', 18000000, 'Chuyển khoản'),
('HD05', '2026-03-05 00:00:00', 'NV02', 'KH05', 21000000, 'Tiền mặt'),
('HD06', '2026-03-06 00:00:00', 'NV03', 'KH06', 11000000, 'Chuyển khoản'),
('HD07', '2026-03-07 00:00:00', 'NV07', 'KH07', 9500000, 'Tiền mặt'),
('HD08', '2026-03-08 00:00:00', 'NV02', 'KH08', 14500000, 'Chuyển khoản'),
('HD09', '2026-03-09 00:00:00', 'NV03', 'KH09', 6000000, 'Tiền mặt'),
('HD10', '2026-03-10 00:00:00', 'NV07', 'KH10', 8200000, 'Chuyển khoản'),
('HD11', '2026-03-18 00:00:00', 'NV02', 'KH01', 1, 'Tiền mặt'),
('HD12', '2026-03-18 00:00:00', 'NV02', 'KH01', 1, 'Tiền mặt'),
('HD13', '2026-03-18 00:00:00', 'NV02', 'KH01', 1, 'Tiền mặt'),
('HD14', '2026-03-18 00:00:00', 'NV02', 'KH01', 1, 'Tiền mặt'),
('HD15', '2026-03-18 00:00:00', 'NV02', 'KH01', 1, 'Tiền mặt'),
('HD16', '2026-03-18 00:00:00', 'NV02', 'KH01', 1, 'Tiền mặt'),
('HD17', '2026-03-19 00:00:00', 'NV02', 'KH01', 250000, 'Tiền mặt'),
('HD18', '2026-03-19 00:00:00', 'NV02', 'KH01', 49500000, 'Tiền mặt'),
('HD19', '2026-03-19 21:10:39', 'NV02', 'KH01', 22000000, 'Tiền mặt'),
('HD20', '2026-03-20 22:41:13', 'NV02', 'KH01', 22000000, 'Thẻ ngân hàng'),
('HD21', '2026-03-20 22:43:06', 'NV02', 'KH01', 22000000, 'Tiền mặt'),
('HD22', '2026-03-22 13:18:58', 'NV02', 'KH01', 250750000, 'Chuyển khoản'),
('HD23', '2026-03-22 13:19:56', 'NV02', 'KH01', 29500000, 'Tiền mặt'),
('HD24', '2026-03-22 13:26:21', 'NV02', 'KH01', 24750000, 'Thẻ ngân hàng'),
('HD25', '2026-03-22 13:33:35', 'NV02', 'KH01', 77500000, 'Tiền mặt'),
('HD26', '2026-03-22 13:34:58', 'NV02', 'KH01', 19000000, 'Tiền mặt'),
('HD27', '2026-03-22 13:36:16', 'NV02', 'KH01', 77500000, 'Thẻ ngân hàng'),
('HD28', '2026-03-22 13:37:01', 'NV02', 'KH01', 28000000, 'Tiền mặt'),
('HD29', '2026-03-22 13:37:14', 'NV02', 'KH01', 12000000, 'Tiền mặt'),
('HD30', '2026-03-22 13:43:22', 'NV02', 'KH10', 24750000, 'Tiền mặt'),
('HD31', '2026-03-22 13:49:51', 'NV02', 'KH01', 24750000, 'Tiền mặt'),
('HD32', '2026-03-22 13:55:14', 'NV02', 'KH01', 28000000, 'Chuyển khoản'),
('HD33', '2026-03-22 13:56:03', 'NV02', 'KH01', 29000000, 'Tiền mặt'),
('HD34', '2026-03-22 13:58:29', 'NV02', 'KH01', 77500000, 'Thẻ ngân hàng'),
('HD35', '2026-03-22 14:15:52', 'NV02', 'KH01', 133000000, 'Chuyển khoản'),
('HD36', '2026-03-22 17:33:45', 'NV024', 'KH09', 250000000, 'Chuyển khoản');

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `Ma` varchar(10) NOT NULL,
  `HoTen` varchar(50) NOT NULL,
  `SDT` varchar(15) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`Ma`, `HoTen`, `SDT`, `Email`) VALUES
('KH003', 'Lê Hoàng Cường', '0923334455', 'cuong.lh@gmail.com'),
('KH004', 'Phạm Minh Duy', '0934445566', 'duy.pm@gmail.com'),
('KH005', 'Vũ Phương Dung', '0945556677', 'dung.vp@gmail.com'),
('KH006', 'Đặng Tuấn Hải', '0956667788', 'hai.dt@gmail.com'),
('KH007', 'Hoàng Thu Hương', '0967778899', 'huong.ht@gmail.com'),
('KH008', 'Ngô Kiến Quốc', '0978889900', 'quoc.nk@gmail.com'),
('KH009', 'Đinh Tiến Dũng', '0989990011', 'dung.dt@gmail.com'),
('KH01', 'Nguyễn Văn An', '0901112233', 'an.nv@gmail.com'),
('KH010', 'Lý Hải Băng', '0990001122', 'bang.lh@gmail.com'),
('KH02', 'Trần Thị Bích', '0912223344', 'bich.tt@gmail.com'),
('KH09', 'Nguyễn Trần Nam B', '0123456789', 'an.nv@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `Ma` varchar(10) NOT NULL,
  `Ten` varchar(50) NOT NULL,
  `NgayBatDau` date NOT NULL,
  `NgayKetThuc` date NOT NULL,
  `GhiChu` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khuyenmai`
--

INSERT INTO `khuyenmai` (`Ma`, `Ten`, `NgayBatDau`, `NgayKetThuc`, `GhiChu`) VALUES
('KM001', 'Sale Đón Tết', '2025-01-01', '2025-01-30', 'Giảm giá dịp Tết'),
('KM002', 'Lễ Tình Nhân', '2025-02-10', '2025-02-15', 'Quà tặng Valentine'),
('KM003', 'Quốc Tế Phụ Nữ', '2025-03-01', '2025-03-10', 'Ưu đãi phái đẹp'),
('KM004', 'Siêu Sale 4/4', '2025-04-01', '2025-04-05', NULL),
('KM005', 'Mừng Lễ 30/4', '2025-04-25', '2025-05-05', 'Nghỉ lễ lớn'),
('KM006', 'Chào Hè Sôi Động', '2025-05-15', '2025-06-15', 'Mua sắm thả ga'),
('KM007', 'Sale Giữa Năm 6/6', '2025-06-01', '2025-06-10', NULL),
('KM008', 'Lễ Hội Mua Sắm', '2025-06-20', '2025-06-30', NULL),
('KM009', 'Sale 7/7', '2025-07-01', '2025-07-10', 'Giảm đậm tháng 7'),
('KM010', 'Lương Về Sale To', '2025-07-25', '2025-08-05', NULL),
('KM011', 'Back To School', '2025-08-10', '2025-09-10', 'Đồng hành cùng sinh viên'),
('KM012', 'Mừng Quốc Khánh', '2025-08-25', '2025-09-05', 'Quốc khánh 2/9'),
('KM013', 'Siêu Sale 9/9', '2025-09-01', '2025-09-15', NULL),
('KM014', 'Tuần Lễ Vàng', '2025-09-20', '2025-09-30', 'Ưu đãi cực sốc'),
('KM015', 'Sale 10/10', '2025-10-01', '2025-10-15', NULL),
('KM016', 'Phụ Nữ Việt Nam', '2025-10-15', '2025-10-25', 'Chào mừng 20/10'),
('KM017', 'Halloween', '2025-10-25', '2025-10-31', 'Lễ hội ma quỷ'),
('KM018', 'Lễ Độc Thân 11/11', '2025-11-01', '2025-11-15', 'Cô đơn nhưng vẫn sale'),
('KM019', 'Black Friday', '2025-11-20', '2025-11-30', 'Thứ 6 đen tối'),
('KM020', 'Cyber Monday', '2025-12-01', '2025-12-05', 'Thứ 2 mua sắm'),
('KM021', 'Siêu Sale 12/12', '2025-12-06', '2025-12-15', NULL),
('KM022', 'Giáng Sinh An Lành', '2025-12-18', '2025-12-25', 'Merry Christmas'),
('KM023', 'Xả Kho Cuối Năm', '2025-12-20', '2025-12-31', 'Clearance Sale'),
('KM024', 'Tri Ân Khách Hàng', '2026-01-01', '2026-01-15', 'Mừng năm mới'),
('KM025', 'Tết Nguyên Đán 2026', '2026-01-20', '2026-02-20', 'Lì xì đầu năm'),
('KM026', 'ADB', '2026-03-09', '2026-03-09', ''),
('KM027', 'ABC', '2026-03-20', '2026-03-20', ''),
('KM028', 'tết', '2026-03-01', '2026-03-01', 'adb');

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `Ma` varchar(10) NOT NULL,
  `Ten` varchar(100) NOT NULL,
  `DiaChi` varchar(200) NOT NULL,
  `SDT` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`Ma`, `Ten`, `DiaChi`, `SDT`) VALUES
('NCC01', 'Công ty TNHH Apple Việt Nam', 'Quận 1, TP. HCM', '0901234567'),
('NCC02', 'Công ty Samsung Electronics', 'Khu Công Nghệ Cao, Quận 9, TP. HCM', '0912345678'),
('NCC03', 'Đại lý phân phối Xiaomi', 'Quận Thanh Xuân, Hà Nội', '0987654321'),
('NCC04', 'Tập đoàn Oppo Việt Nam', 'Quận 7, TP. HCM', '0976543210'),
('NCC05', 'Công ty Phân phối Vivo', 'Quận Hải Châu, Đà Nẵng', '0934567890'),
('NCC06', 'Đại lý Realme Toàn Quốc', 'Quận 3, TP. HCM', '0945678901'),
('NCC07', 'Nhà phân phối Thế Giới Di Động', 'Quận Hoàn Kiếm, Hà Nội', '0967890123'),
('NCC08', 'Công ty Sony Electronics', 'Quận Bình Thạnh, TP. HCM', '0923456789'),
('NCC09', 'Nhà phân phối ROG Asus', 'Quận 10, TP. HCM', '0998765432'),
('NCC10', 'Công ty Huawei Việt Nam', 'Quận Cầu Giấy, Hà Nội', '0956789012');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `ma` varchar(20) NOT NULL,
  `hoten` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gioitinh` varchar(10) NOT NULL,
  `ngaysinh` date DEFAULT NULL,
  `chucvu` varchar(50) DEFAULT NULL,
  `luong` double NOT NULL,
  `tinhtrang` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`ma`, `hoten`, `email`, `gioitinh`, `ngaysinh`, `chucvu`, `luong`, `tinhtrang`) VALUES
('NV001', 'Nguyễn Thành Nhân', 'nhan.nt@gmail.com', 'Nam', '1995-05-20', 'Quản lý', 25000000, 1),
('NV002', 'Trần Thị Mỹ Linh', 'linh.ttm@gmail.com', 'Nữ', '1997-10-12', 'Nhân Viên', 10000000, 1),
('NV003', 'Lê Hoàng Nam', 'nam.lh@gmail.com', 'Nam', '1998-03-15', 'Nhân Viên', 10000000, 1),
('NV004', 'Phạm Minh Tuấn', 'tuan.pm@gmail.com', 'Nam', '1994-12-30', 'Nhân Viên', 12000000, 1),
('NV005', 'Vũ Phương Thảo', 'thao.vp@gmail.com', 'Nữ', '2000-01-05', 'Nhân Viên', 15000000, 1),
('NV006', 'Đặng Văn Hùng', 'hung.dv@gmail.com', 'Nam', '1992-07-22', 'Kho', 9000000, 0),
('NV007', 'Hoàng Thu Trang', 'trang.ht@gmail.com', 'Nữ', '1999-09-09', 'Bán hàng', 8500000, 0),
('NV008', 'Ngô Anh Đức', 'duc.na@gmail.com', 'Nữ', '1996-02-14', 'Nhân Viên', 14000000, 1),
('NV009', 'Đới Tuyết Mai', 'mai.dt@gmail.com', 'Nữ', '2001-04-18', 'Nhân Viên', 123123123, 1),
('NV010', 'Lý Gia Bảo', 'bao.lg@gmail.com', 'Nam', '1993-11-25', 'Bảo vệ', 7500000, 1),
('NV011', 'Trịnh Công Sơn', 'son.tc@gmail.com', 'Nam', '1995-06-30', 'Kỹ thuật', 14500000, 1),
('NV012', 'Đỗ Kim Liên', 'lien.dk@gmail.com', 'Nữ', '1998-08-21', 'Nhân Viên', 85000000, 1),
('NV013', 'Vương Đình Huệ', 'hue.vd@gmail.com', 'Nam', '1990-05-15', 'Quản lý', 24000000, 1),
('NV014', 'Mai Thu Huyền', 'huyen.mt@gmail.com', 'Nữ', '2002-12-01', 'Thực tập', 4000000, 0),
('NV015', 'Tạ Quang Bửu', 'buu.tq@gmail.com', 'Nam', '1997-01-20', 'Nhân Viên', 11000000, 1),
('NV016', 'Phan Thanh Hải', 'hai.pt@gmail.com', 'Nam', '1994-04-10', 'Bán hàng', 9500000, 1),
('NV017', 'Nguyễn Bích Ngọc', 'ngoc.nb@gmail.com', 'Nữ', '1999-11-11', 'Kế toán', 14500000, 1),
('NV018', 'Dương Trung Quốc', 'quoc.dt@gmail.com', 'Nam', '1991-08-05', 'Bảo vệ', 7000000, 1),
('NV019', 'Hà Kiều Anh', 'anh.hk@gmail.com', 'Nữ', '2000-02-28', 'Bán hàng', 8000000, 1),
('NV020', 'Chu Ngọc Anh', 'anh.cn@gmail.com', 'Nam', '1996-03-03', 'Kỹ thuật', 15000000, 1),
('NV021', 'Trương Thế Vinh', 'vinh.tt@gmail.com', 'Nam', '1995-09-30', 'Nhân Viên', 11500000, 1),
('NV022', 'Lâm Minh Anh', 'anh.lm@gmail.com', 'Nữ', '2001-11-11', 'Thực tập', 4500000, 1),
('NV023', 'Nguyễn Văn B', 'nguyenvanb@gmail.com', 'Nam', '2005-03-01', 'Nhân Viên', 10500000, 1),
('NV024', 'Nguyễn Trần Nam Thịnh', 'singapothinh0711@gmail.com', 'Nam', '2005-03-07', 'Quản Lý', 26000000, 1),
('NV025', 'Thanh Phục', 'nam@gmail.com', 'Nam', '2004-03-10', 'Quản lý', 22000000, 1),
('NV026', 'Nguyễn Trần Văn a', 'nvc@gmail.com', 'Nam', '2005-03-11', 'Nhân Viên', 5000000, 0),
('NV027', 'Nguyễn Văn B C', 'nguyenvanbc@gmail.com', 'Nam', '2000-03-09', 'Nhân Viên', 5000000, 1),
('NV028', 'Trần Thị Nữ ', 'tranthinu@gmail.com', 'Nữ', '2001-03-13', 'Nhân Viên', 5000000, 1),
('NV029', 'Lê Văn Đạt', 'dat.lv@gmail.com', 'Nam', '1998-11-20', 'Nhân Viên', 10000000, 1),
('NV030', 'Phạm Thu Thủy', 'thuy.pt@gmail.com', 'Nữ', '2002-05-15', 'Thực tập', 4500000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPN` varchar(20) NOT NULL,
  `Ngay` date NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  `MaNCC` varchar(10) NOT NULL,
  `TongTien` int(11) NOT NULL,
  `TrangThai` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`MaPN`, `Ngay`, `MaNV`, `MaNCC`, `TongTien`, `TrangThai`) VALUES
('PN001', '2026-03-01', 'NV001', 'NCC01', 145000000, 'Đang hoạt động'),
('PN002', '2026-03-02', 'NV002', 'NCC02', 85000000, 'Đang hoạt động'),
('PN003', '2026-03-03', 'NV003', 'NCC01', 45000000, 'Đang hoạt động'),
('PN004', '2026-03-05', 'NV001', 'NCC03', 120000000, 'Đang hoạt động'),
('PN005', '2026-03-07', 'NV004', 'NCC04', 30000000, 'Đang hoạt động'),
('PN006', '2026-03-10', 'NV002', 'NCC02', 210000000, 'Đang hoạt động'),
('PN007', '2026-03-12', 'NV005', 'NCC05', 65000000, 'Đang hoạt động'),
('PN008', '2026-03-15', 'NV001', 'NCC01', 90000000, 'Đang hoạt động'),
('PN009', '2026-03-22', 'NV003', 'NCC04', 115000000, 'Đang hoạt động'),
('PN010', '2026-03-20', 'NV002', 'NCC03', 55000000, 'Đang hoạt động'),
('PN24439', '2026-03-22', 'NV024', 'NCC01', 19000000, 'Đang hoạt động');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `ma` varchar(20) NOT NULL,
  `taikhoan` varchar(50) NOT NULL,
  `matkhau` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`ma`, `taikhoan`, `matkhau`) VALUES
('NV001', 'nhan.nt', '123456'),
('NV002', 'linh.ttm', '123456'),
('NV003', 'nam.lh', '123456'),
('NV004', 'tuan.pm', '123456'),
('NV005', 'thao.vp', '123456'),
('NV006', 'hung.dv', '123456'),
('NV007', 'trang.ht', '123456'),
('NV008', 'duc.na', '123456'),
('NV009', 'mai.dt', '123456'),
('NV010', 'bao.lg', '123456'),
('NV011', 'son.tc', '123456'),
('NV012', 'lien.dk', '123456'),
('NV013', 'hue.vd', '123456'),
('NV014', 'huyen.mt', '123456'),
('NV015', 'buu.tq', '123456'),
('NV016', 'hai.pt', '123456'),
('NV017', 'ngoc.nb', '123456'),
('NV018', 'quoc.dt', '123456'),
('NV019', 'anh.hk', '123456'),
('NV020', 'anh.cn', '123456'),
('NV021', 'vinh.tt', '123456'),
('NV022', 'anh.lm', '123456'),
('NV023', 'nguyenvanb', '123456'),
('NV024', 'Admin', '2'),
('NV025', 'nam', '123456'),
('NV026', '123', '1'),
('NV027', 'nguyenvanbc', '1'),
('NV028', 'tranthinu', '1'),
('NV029', 'NV029', '123456'),
('NV030', 'NV030', '123456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `baohanh`
--
ALTER TABLE `baohanh`
  ADD PRIMARY KEY (`MaBH`);

--
-- Indexes for table `chitietbaohanh`
--
ALTER TABLE `chitietbaohanh`
  ADD PRIMARY KEY (`MaBH`,`IMEI`);

--
-- Indexes for table `chitietdienthoai`
--
ALTER TABLE `chitietdienthoai`
  ADD PRIMARY KEY (`Ma`);

--
-- Indexes for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`MaHD`);

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`MaPN`,`MaSP`);

--
-- Indexes for table `dienthoai`
--
ALTER TABLE `dienthoai`
  ADD PRIMARY KEY (`Ma`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`Ma`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`Ma`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`ma`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPN`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`ma`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietdienthoai`
--
ALTER TABLE `chitietdienthoai`
  ADD CONSTRAINT `fk_chi_tiet_ma` FOREIGN KEY (`Ma`) REFERENCES `dienthoai` (`Ma`) ON DELETE CASCADE;

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `fk_taikhoan_nhanvien` FOREIGN KEY (`ma`) REFERENCES `nhanvien` (`ma`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
