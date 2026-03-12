-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3309
-- Thời gian đã tạo: Th3 12, 2026 lúc 04:19 PM
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
-- Cơ sở dữ liệu: `dienthoai`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baohanh`
--

CREATE TABLE `baohanh` (
  `Ma` varchar(10) NOT NULL,
  `ThoiGian` date NOT NULL,
  `GhiChu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietbaohanh`
--

CREATE TABLE `chitietbaohanh` (
  `MaBH` varchar(10) NOT NULL,
  `IMEI` varchar(50) NOT NULL,
  `Ngay` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  `HeDieuHanh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
('1', '1', 2, 50000, 100000);

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
('3', '2', 0);

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
('2', '2', 3, 5000);

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
  `MaHang` varchar(10) NOT NULL,
  `ThoiGianBaoHanh` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `dienthoai`
--

INSERT INTO `dienthoai` (`Ma`, `Ten`, `SoLuong`, `DonGia`, `DonViTinh`, `MaHang`, `ThoiGianBaoHanh`) VALUES
('1', '1', 2, 1, '1', '1', 0),
('2', 'REDMI NOTE 10', 3, 3, 'Dong', '1', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hang`
--

CREATE TABLE `hang` (
  `Ma` varchar(10) NOT NULL,
  `Ten` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
('9', '2026-09-01', '1', '1', 50000, '1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `Ma` varchar(10) NOT NULL,
  `Ho` varchar(50) NOT NULL,
  `Ten` varchar(50) NOT NULL,
  `GioiTinh` varchar(5) NOT NULL,
  `NgaySinh` date NOT NULL,
  `DiaChi` varchar(50) NOT NULL,
  `SDT` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
('3', 'Mùa đông', '2026-04-01', '2026-06-23', '', 0);

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
('NV01', 'Luong Trieu Phat', 'luongphat1123@gmail.com', '2006-07-09', 'Nhân viên', '0');

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
('2', '2026-01-01', '1', '1', 100000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `Ma` varchar(50) NOT NULL,
  `TaiKhoan` varchar(50) NOT NULL,
  `MatKhau` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`Ma`, `TaiKhoan`, `MatKhau`) VALUES
('NV01', 'Phat', 'LuongPhat1123');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `baohanh`
--
ALTER TABLE `baohanh`
  ADD PRIMARY KEY (`Ma`);

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
