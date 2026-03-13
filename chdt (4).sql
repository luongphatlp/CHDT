-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 12, 2026 lúc 08:04 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `chdt`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baohanh`
--

CREATE TABLE `baohanh` (
  `Ma` varchar(10) NOT NULL,
  `ThoiGian` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `baohanh`
--

INSERT INTO `baohanh` (`Ma`, `ThoiGian`) VALUES
('BH1', 12),
('BH10', 12),
('BH2', 12),
('BH3', 18),
('BH4', 24),
('BH5', 12),
('BH6', 24),
('BH7', 12),
('BH8', 18),
('BH9', 24);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baohanhdienthoai`
--

CREATE TABLE `baohanhdienthoai` (
  `TenMay` varchar(50) NOT NULL,
  `IMEI` varchar(50) NOT NULL,
  `NgayHen` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `baohanhdienthoai`
--

INSERT INTO `baohanhdienthoai` (`TenMay`, `IMEI`, `NgayHen`) VALUES
('iPhone 15', 'IMEI10001', '2026-03-15'),
('iPhone 15 Plus', 'IMEI10002', '2026-03-16'),
('Samsung Galaxy S24', 'IMEI10003', '2026-03-17'),
('Samsung Galaxy S24 Ultra', 'IMEI10004', '2026-03-18'),
('Xiaomi 14', 'IMEI10005', '2026-03-19'),
('Oppo Find X7', 'IMEI10006', '2026-03-20'),
('Vivo V30', 'IMEI10007', '2026-03-21'),
('Realme GT5', 'IMEI10008', '2026-03-22'),
('Google Pixel 8', 'IMEI10009', '2026-03-23'),
('Honor Magic 6', 'IMEI10010', '2026-03-24');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietbaohanh`
--

CREATE TABLE `chitietbaohanh` (
  `MaBH` varchar(10) NOT NULL,
  `IMEI` varchar(50) NOT NULL,
  `NgayHetBaoHanh` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietbaohanh`
--

INSERT INTO `chitietbaohanh` (`MaBH`, `IMEI`, `NgayHetBaoHanh`) VALUES
('BH1', 'IMEI10001', '2027-03-01'),
('BH10', 'IMEI10010', '2027-03-10'),
('BH2', 'IMEI10002', '2027-03-02'),
('BH3', 'IMEI10003', '2027-03-03'),
('BH4', 'IMEI10004', '2028-03-04'),
('BH5', 'IMEI10005', '2027-03-05'),
('BH6', 'IMEI10006', '2028-03-06'),
('BH7', 'IMEI10007', '2027-03-07'),
('BH8', 'IMEI10008', '2027-03-08'),
('BH9', 'IMEI10009', '2028-03-09');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdienthoai`
--

CREATE TABLE `chitietdienthoai` (
  `Ma` varchar(10) NOT NULL,
  `Mau` varchar(20) NOT NULL,
  `ManHinh` varchar(50) NOT NULL,
  `KichThuocManHInh` varchar(50) NOT NULL,
  `TenChip` varchar(50) NOT NULL,
  `BoNhoTrong` varchar(50) NOT NULL,
  `BoNhoNgoai` int(11) NOT NULL,
  `CameraTruoc` int(11) NOT NULL,
  `CameraSau` int(11) NOT NULL,
  `Pin` int(11) NOT NULL,
  `HeDieuHanh` varchar(20) NOT NULL,
  `ThoiHanBaoHanh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietdienthoai`
--

INSERT INTO `chitietdienthoai` (`Ma`, `Mau`, `ManHinh`, `KichThuocManHInh`, `TenChip`, `BoNhoTrong`, `BoNhoNgoai`, `CameraTruoc`, `CameraSau`, `Pin`, `HeDieuHanh`, `ThoiHanBaoHanh`) VALUES
('DT1', 'Black', 'Super Retina XDR OLED', '6.1 inch', 'Apple A17', '128GB', 0, 12, 48, 3349, 'iOS', 12),
('DT10', 'Black', 'AMOLED', '6.73 inch', 'Snapdragon 8 Gen 3', '256GB', 0, 32, 50, 5000, 'MIUI (Android)', 12),
('DT11', 'Black', 'AMOLED', '6.67 inch', 'Snapdragon 685', '128GB', 1024, 16, 108, 5000, 'MIUI (Android)', 12),
('DT12', 'Blue', 'AMOLED', '6.67 inch', 'Snapdragon 7s Gen 2', '256GB', 1024, 16, 200, 5100, 'MIUI (Android)', 12),
('DT13', 'Purple', 'AMOLED', '6.82 inch', 'Dimensity 9300', '256GB', 0, 32, 50, 5000, 'ColorOS (Android)', 12),
('DT14', 'Silver', 'AMOLED', '6.7 inch', 'Snapdragon 778G', '256GB', 0, 32, 50, 4800, 'ColorOS (Android)', 12),
('DT15', 'Green', 'AMOLED', '6.7 inch', 'Snapdragon 8+ Gen 1', '256GB', 0, 32, 50, 4700, 'ColorOS (Android)', 12),
('DT16', 'Blue', 'AMOLED', '6.78 inch', 'Snapdragon 7 Gen 3', '256GB', 0, 50, 50, 5000, 'Funtouch OS (Android', 12),
('DT17', 'Black', 'AMOLED', '6.78 inch', 'Dimensity 8200', '256GB', 0, 50, 50, 5000, 'Funtouch OS (Android', 12),
('DT18', 'Blue', 'AMOLED', '6.78 inch', 'Dimensity 9300', '256GB', 0, 32, 50, 5000, 'Funtouch OS (Android', 12),
('DT19', 'Black', 'AMOLED', '6.74 inch', 'Snapdragon 8 Gen 2', '256GB', 0, 16, 50, 4600, 'Realme UI (Android)', 12),
('DT2', 'Blue', 'Super Retina XDR OLED', '6.7 inch', 'Apple A17', '256GB', 0, 12, 48, 4383, 'iOS', 12),
('DT20', 'Gold', 'AMOLED', '6.7 inch', 'Snapdragon 7s Gen 2', '256GB', 0, 32, 50, 5000, 'Realme UI (Android)', 12),
('DT21', 'Black', 'OLED', '6.2 inch', 'Google Tensor G3', '128GB', 0, 10, 50, 4575, 'Pixel UI (Android)', 12),
('DT22', 'Blue', 'OLED', '6.7 inch', 'Google Tensor G3', '256GB', 0, 10, 50, 5050, 'Pixel UI (Android)', 12),
('DT23', 'Green', 'AMOLED', '6.82 inch', 'Snapdragon 8 Gen 3', '256GB', 0, 32, 50, 5400, 'OxygenOS (Android)', 12),
('DT24', 'Gray', 'AMOLED', '6.74 inch', 'Dimensity 9000', '256GB', 0, 16, 50, 5000, 'OxygenOS (Android)', 12),
('DT25', 'White', 'OLED', '6.67 inch', 'Kirin 9000S', '256GB', 0, 13, 48, 4815, 'HarmonyOS', 12),
('DT26', 'Black', 'OLED', '6.82 inch', 'Kirin 9000S', '256GB', 0, 13, 50, 5000, 'HarmonyOS', 12),
('DT27', 'Purple', 'OLED', '6.78 inch', 'Snapdragon 8 Gen 3', '256GB', 0, 50, 50, 5450, 'MagicOS (Android)', 12),
('DT28', 'Black', 'OLED', '6.8 inch', 'Snapdragon 8 Gen 3', '512GB', 0, 50, 50, 5600, 'MagicOS (Android)', 12),
('DT29', 'Blue', 'IPS LCD', '6.79 inch', 'Helio G91', '128GB', 1024, 8, 108, 5030, 'MIUI (Android)', 12),
('DT3', 'Titanium', 'Super Retina XDR OLED', '6.1 inch', 'Apple A17 Pro', '256GB', 0, 12, 48, 3274, 'iOS', 12);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MaHD` varchar(50) NOT NULL,
  `MaSP` varchar(50) NOT NULL,
  `SoLuong` int(10) NOT NULL,
  `DonGia` int(10) NOT NULL,
  `ThanhTien` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MaHD`, `MaSP`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES
('1', '1', 2, 50000, 100000),
('HD1', 'DT1', 1, 22000000, 22000000),
('HD10', 'DT30', 1, 8200000, 8200000),
('HD2', 'DT2', 1, 25000000, 25000000),
('HD3', 'DT7', 1, 31000000, 31000000),
('HD4', 'DT9', 1, 18000000, 18000000),
('HD5', 'DT5', 1, 21000000, 21000000),
('HD6', 'DT16', 1, 11000000, 11000000),
('HD7', 'DT8', 1, 9500000, 9500000),
('HD8', 'DT15', 1, 14500000, 14500000),
('HD9', 'DT11', 1, 6000000, 6000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietkhuyenmai`
--

CREATE TABLE `chitietkhuyenmai` (
  `MaKhuyenMai` varchar(10) NOT NULL,
  `MaSanPham` varchar(10) NOT NULL,
  `PhanTram` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietkhuyenmai`
--

INSERT INTO `chitietkhuyenmai` (`MaKhuyenMai`, `MaSanPham`, `PhanTram`) VALUES
('1', '1', 2),
('1', '2', 2),
('2', '1', 10),
('2', '2', 6),
('3', '1', 0),
('KM1', 'DT1', 10),
('KM1', 'DT2', 10),
('KM10', 'DT1', 10),
('KM10', 'DT10', 10),
('KM10', 'DT13', 10),
('KM2', 'DT5', 5),
('KM2', 'DT6', 5),
('KM3', 'DT7', 8),
('KM4', 'DT8', 7),
('KM5', 'DT9', 6),
('KM6', 'DT10', 5),
('KM7', 'DT15', 10),
('KM8', 'DT20', 12);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `MaPN` varchar(10) NOT NULL,
  `MaSP` varchar(10) NOT NULL,
  `SoLuong` int(10) NOT NULL,
  `TongTien` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`MaPN`, `MaSP`, `SoLuong`, `TongTien`) VALUES
('1', '1', 3, 400000),
('2', '2', 3, 5000),
('PN1', 'DT1', 10, 220000000),
('PN10', 'DT27', 5, 105000000),
('PN2', 'DT5', 10, 210000000),
('PN3', 'DT9', 10, 180000000),
('PN4', 'DT13', 8, 168000000),
('PN5', 'DT16', 10, 110000000),
('PN6', 'DT19', 10, 120000000),
('PN7', 'DT21', 5, 95000000),
('PN8', 'DT23', 5, 105000000),
('PN9', 'DT25', 5, 120000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dienthoai`
--

CREATE TABLE `dienthoai` (
  `Ma` varchar(10) NOT NULL,
  `Ten` varchar(50) NOT NULL,
  `SoLuong` int(5) NOT NULL,
  `DonGia` int(10) NOT NULL,
  `DonViTinh` varchar(10) NOT NULL,
  `MaHang` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `dienthoai`
--

INSERT INTO `dienthoai` (`Ma`, `Ten`, `SoLuong`, `DonGia`, `DonViTinh`, `MaHang`) VALUES
('DT1', 'iPhone 15', 15, 22000000, 'Cái', 'H1'),
('DT10', 'Xiaomi 14 Ultra', 8, 29000000, 'Cái', 'H3'),
('DT11', 'Redmi Note 13', 30, 6000000, 'Cái', 'H3'),
('DT12', 'Redmi Note 13 Pro', 20, 8500000, 'Cái', 'H3'),
('DT13', 'Oppo Find X7', 12, 21000000, 'Cái', 'H4'),
('DT14', 'Oppo Reno11', 18, 10500000, 'Cái', 'H4'),
('DT15', 'Oppo Reno11 Pro', 10, 14500000, 'Cái', 'H4'),
('DT16', 'Vivo V30', 15, 11000000, 'Cái', 'H5'),
('DT17', 'Vivo V30 Pro', 10, 15000000, 'Cái', 'H5'),
('DT18', 'Vivo X100', 8, 22000000, 'Cái', 'H5'),
('DT19', 'Realme GT5', 12, 12000000, 'Cái', 'H6'),
('DT2', 'iPhone 15 Plus', 10, 25000000, 'Cái', 'H1'),
('DT20', 'Realme 12 Pro+', 20, 9500000, 'Cái', 'H6'),
('DT21', 'Google Pixel 8', 10, 19000000, 'Cái', 'H7'),
('DT22', 'Google Pixel 8 Pro', 7, 25000000, 'Cái', 'H7'),
('DT23', 'OnePlus 12', 9, 21000000, 'Cái', 'H8'),
('DT24', 'OnePlus Nord 3', 14, 11000000, 'Cái', 'H8'),
('DT25', 'Huawei P60 Pro', 8, 24000000, 'Cái', 'H9'),
('DT26', 'Huawei Mate 60', 7, 23000000, 'Cái', 'H9'),
('DT27', 'Honor Magic 6', 9, 21000000, 'Cái', 'H10'),
('DT28', 'Honor Magic 6 Pro', 6, 26000000, 'Cái', 'H10'),
('DT29', 'Redmi 13', 25, 4200000, 'Cái', 'H3'),
('DT3', 'iPhone 15 Pro', 12, 28000000, 'Cái', 'H1'),
('DT30', 'Samsung Galaxy A35', 22, 8200000, 'Cái', 'H2'),
('DT31', 'iPhone 14', 12, 19000000, 'Cái', 'H1'),
('DT4', 'iPhone 15 Pro Max', 8, 34000000, 'Cái', 'H1'),
('DT5', 'Samsung Galaxy S24', 20, 21000000, 'Cái', 'H2'),
('DT6', 'Samsung Galaxy S24+', 15, 25000000, 'Cái', 'H2'),
('DT7', 'Samsung Galaxy S24 Ultra', 10, 31000000, 'Cái', 'H2'),
('DT8', 'Samsung Galaxy A55', 25, 9500000, 'Cái', 'H2'),
('DT9', 'Xiaomi 14', 20, 18000000, 'Cái', 'H3');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hang`
--

CREATE TABLE `hang` (
  `Ma` varchar(10) NOT NULL,
  `Ten` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hang`
--

INSERT INTO `hang` (`Ma`, `Ten`) VALUES
('H1', 'Apple'),
('H10', 'Honor'),
('H2', 'Samsung'),
('H3', 'Xiaomi'),
('H4', 'Oppo'),
('H5', 'Vivo'),
('H6', 'Realme'),
('H7', 'Google'),
('H8', 'OnePlus'),
('H9', 'Huawei');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` varchar(10) NOT NULL,
  `Ngay` date NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  `MaKH` varchar(10) NOT NULL,
  `TongTien` int(10) NOT NULL,
  `PTTT` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `Ngay`, `MaNV`, `MaKH`, `TongTien`, `PTTT`) VALUES
('1', '2026-01-01', '1', '1', 100000, '1'),
('10', '2026-10-01', '1', '1', 500000, '1'),
('11', '2026-11-01', '1', '1', 500000, '1'),
('12', '2026-12-01', '1', '1', 300000, '1'),
('2', '2026-02-01', '1', '1', 100000, '1'),
('3', '2026-03-01', '1', '1', 100000, '1'),
('4', '2026-04-01', '1', '1', 100000, '1'),
('5', '2026-05-01', '1', '1', 100000, '1'),
('6', '2026-06-01', '1', '1', 100000, '1'),
('7', '2026-07-01', '1', '1', 200000, '1'),
('8', '2026-08-01', '1', '1', 300000, '1'),
('9', '2026-09-01', '1', '1', 50000, '1'),
('HD1', '2026-03-01', 'NV2', 'KH1', 22000000, 'Tiền mặt'),
('HD10', '2026-03-10', 'NV7', 'KH10', 8200000, 'Chuyển khoản'),
('HD2', '2026-03-02', 'NV3', 'KH2', 25000000, 'Chuyển khoản'),
('HD3', '2026-03-03', 'NV2', 'KH3', 31000000, 'Tiền mặt'),
('HD4', '2026-03-04', 'NV7', 'KH4', 18000000, 'Chuyển khoản'),
('HD5', '2026-03-05', 'NV2', 'KH5', 21000000, 'Tiền mặt'),
('HD6', '2026-03-06', 'NV3', 'KH6', 11000000, 'Chuyển khoản'),
('HD7', '2026-03-07', 'NV7', 'KH7', 9500000, 'Tiền mặt'),
('HD8', '2026-03-08', 'NV2', 'KH8', 14500000, 'Chuyển khoản'),
('HD9', '2026-03-09', 'NV3', 'KH9', 6000000, 'Tiền mặt');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `Ma` varchar(10) NOT NULL,
  `SDT` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`Ma`, `SDT`, `email`) VALUES
('KH1', '0901234567', 'minh@gmail.com'),
('KH10', '0910234567', 'khoa@gmail.com'),
('KH2', '0902234567', 'long@gmail.com'),
('KH3', '0903234567', 'anh@gmail.com'),
('KH4', '0904234567', 'son@gmail.com'),
('KH5', '0905234567', 'hoa@gmail.com'),
('KH6', '0906234567', 'trang@gmail.com'),
('KH7', '0907234567', 'tuan@gmail.com'),
('KH8', '0908234567', 'huy@gmail.com'),
('KH9', '0909234567', 'bao@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `Ma` varchar(10) NOT NULL,
  `Ten` varchar(50) NOT NULL,
  `NgayBatDau` date NOT NULL,
  `NgayKetThuc` date NOT NULL,
  `GhiChu` varchar(50) DEFAULT NULL,
  `TinhTrang` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khuyenmai`
--

INSERT INTO `khuyenmai` (`Ma`, `Ten`, `NgayBatDau`, `NgayKetThuc`, `GhiChu`, `TinhTrang`) VALUES
('1', 'Tết', '2026-02-01', '2026-02-27', 'Khuyến mãi theo chủ đề Tết', 0),
('2', '22', '2025-11-12', '2025-12-31', 'Cuối năm', 0),
('3', 'Mùa đông', '2026-04-01', '2026-06-23', '', 0),
('KM1', 'Sale Tết', '2026-01-01', '2026-02-01', 'Tết', 1),
('KM10', 'Online Sale', '2026-10-01', '2026-10-10', 'Online', 1),
('KM2', 'Sale Hè', '2026-05-01', '2026-06-01', 'Mùa hè', 1),
('KM3', 'Black Friday', '2026-11-20', '2026-11-30', 'Sale lớn', 1),
('KM4', 'Back To School', '2026-08-01', '2026-09-01', 'Sinh viên', 1),
('KM5', 'Flash Sale', '2026-03-01', '2026-03-10', 'Flash', 1),
('KM6', 'Weekend', '2026-04-01', '2026-04-02', 'Cuối tuần', 1),
('KM7', 'Holiday', '2026-07-01', '2026-07-10', 'Du lịch', 1),
('KM8', 'Summer Deal', '2026-06-01', '2026-06-30', 'Hè', 1),
('KM9', 'Winter', '2026-12-01', '2026-12-31', 'Đông', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `Ma` varchar(10) NOT NULL,
  `Ten` varchar(50) NOT NULL,
  `DiaChi` varchar(50) NOT NULL,
  `SDT` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`Ma`, `Ten`, `DiaChi`, `SDT`) VALUES
('NCC1', 'Apple Vietnam', 'HCM', '028111111'),
('NCC10', 'Honor VN', 'HCM', '028101010'),
('NCC2', 'Samsung Vietnam', 'HCM', '028222222'),
('NCC3', 'Xiaomi Vietnam', 'HCM', '028333333'),
('NCC4', 'Oppo Vietnam', 'HCM', '028444444'),
('NCC5', 'Vivo Vietnam', 'HCM', '028555555'),
('NCC6', 'Realme Vietnam', 'HCM', '028666666'),
('NCC7', 'Google Distributor', 'HCM', '028777777'),
('NCC8', 'OnePlus VN', 'HCM', '028888888'),
('NCC9', 'Huawei VN', 'HCM', '028999999');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `Ma` varchar(10) NOT NULL,
  `hoten` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `NgaySinh` date NOT NULL,
  `ChucVu` varchar(50) NOT NULL,
  `TinhTrang` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`Ma`, `hoten`, `Email`, `NgaySinh`, `ChucVu`, `TinhTrang`) VALUES
('NV1', 'Nguyễn Minh Tuấn', 'tuan@shopdt.vn', '1998-03-12', 'Quản lý', 'Đang làm'),
('NV10', 'Phan Đức Thịnh', 'thinh@shopdt.vn', '1998-11-25', 'Bán hàng', 'Đang làm'),
('NV2', 'Trần Quốc Bảo', 'bao@shopdt.vn', '1999-07-21', 'Bán hàng', 'Đang làm'),
('NV3', 'Lê Hoàng Nam', 'nam@shopdt.vn', '1997-05-10', 'Bán hàng', 'Đang làm'),
('NV4', 'Phạm Nhật Anh', 'anh@shopdt.vn', '2000-01-11', 'Thu ngân', 'Đang làm'),
('NV5', 'Võ Minh Đức', 'duc@shopdt.vn', '1996-08-22', 'Kho', 'Đang làm'),
('NV6', 'Đặng Quốc Huy', 'huy@shopdt.vn', '1998-04-19', 'Kỹ thuật', 'Đang làm'),
('NV7', 'Bùi Thành Long', 'long@shopdt.vn', '1999-12-09', 'Bán hàng', 'Đang làm'),
('NV8', 'Hoàng Văn Sơn', 'son@shopdt.vn', '1995-02-18', 'Kỹ thuật', 'Đang làm'),
('NV9', 'Ngô Hải Đăng', 'dang@shopdt.vn', '2001-06-15', 'Thu ngân', 'Đang làm');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPN` varchar(10) NOT NULL,
  `Ngay` date NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  `MaNCC` varchar(10) NOT NULL,
  `TongTien` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`MaPN`, `Ngay`, `MaNV`, `MaNCC`, `TongTien`) VALUES
('1', '2026-02-20', '1', '1', 400000),
('2', '2026-01-01', '1', '1', 100000),
('PN1', '2026-01-10', 'NV5', 'NCC1', 450000000),
('PN10', '2026-05-15', 'NV5', 'NCC10', 140000000),
('PN2', '2026-01-15', 'NV5', 'NCC2', 300000000),
('PN3', '2026-02-02', 'NV5', 'NCC3', 200000000),
('PN4', '2026-02-18', 'NV5', 'NCC4', 150000000),
('PN5', '2026-03-05', 'NV5', 'NCC5', 180000000),
('PN6', '2026-03-20', 'NV5', 'NCC6', 120000000),
('PN7', '2026-04-01', 'NV5', 'NCC7', 90000000),
('PN8', '2026-04-10', 'NV5', 'NCC8', 110000000),
('PN9', '2026-05-02', 'NV5', 'NCC9', 170000000);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `baohanh`
--
ALTER TABLE `baohanh`
  ADD PRIMARY KEY (`Ma`);

--
-- Chỉ mục cho bảng `baohanhdienthoai`
--
ALTER TABLE `baohanhdienthoai`
  ADD PRIMARY KEY (`IMEI`);

--
-- Chỉ mục cho bảng `chitietbaohanh`
--
ALTER TABLE `chitietbaohanh`
  ADD PRIMARY KEY (`MaBH`,`IMEI`);

--
-- Chỉ mục cho bảng `chitietdienthoai`
--
ALTER TABLE `chitietdienthoai`
  ADD PRIMARY KEY (`Ma`);

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`MaHD`);

--
-- Chỉ mục cho bảng `chitietkhuyenmai`
--
ALTER TABLE `chitietkhuyenmai`
  ADD PRIMARY KEY (`MaKhuyenMai`,`MaSanPham`);

--
-- Chỉ mục cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`MaPN`);

--
-- Chỉ mục cho bảng `dienthoai`
--
ALTER TABLE `dienthoai`
  ADD PRIMARY KEY (`Ma`);

--
-- Chỉ mục cho bảng `hang`
--
ALTER TABLE `hang`
  ADD PRIMARY KEY (`Ma`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`Ma`);

--
-- Chỉ mục cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`Ma`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`Ma`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`Ma`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPN`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
