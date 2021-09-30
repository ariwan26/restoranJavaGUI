-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2021 at 12:20 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `resto_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail_order`
--

CREATE TABLE `detail_order` (
  `id_detail_order` int(10) NOT NULL,
  `id_order` varchar(10) DEFAULT NULL,
  `id_masakan` varchar(10) DEFAULT NULL,
  `keterangan` varchar(20) DEFAULT NULL,
  `status_detail_order` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_order`
--

INSERT INTO `detail_order` (`id_detail_order`, `id_order`, `id_masakan`, `keterangan`, `status_detail_order`) VALUES
(1, 'ORD-2253', '7', '2', 'Ditempat'),
(2, 'ORD-0658', '2', '3', 'Ditempat');

-- --------------------------------------------------------

--
-- Table structure for table `level`
--

CREATE TABLE `level` (
  `id_level` int(10) NOT NULL,
  `nama_level` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `level`
--

INSERT INTO `level` (`id_level`, `nama_level`) VALUES
(1, 'Admin'),
(2, 'Waiter'),
(3, 'Kasir'),
(4, 'Owner'),
(5, 'Pelanggan');

-- --------------------------------------------------------

--
-- Table structure for table `masakan`
--

CREATE TABLE `masakan` (
  `id_masakan` varchar(10) NOT NULL,
  `nama_masakan` varchar(30) DEFAULT NULL,
  `harga` int(20) DEFAULT NULL,
  `status_masakan` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `masakan`
--

INSERT INTO `masakan` (`id_masakan`, `nama_masakan`, `harga`, `status_masakan`) VALUES
('1', 'Nasi Padang', 20000, 'Tersedia'),
('2', 'Nasi Kucing', 5000, 'Tersedia'),
('3', 'Nasi Lemak', 5000, 'Kosong'),
('4', 'Mie Goreng', 5000, 'Kosong'),
('5', 'Nasi Rames', 5000, 'Tersedia'),
('6', 'Nasi Goreng + Telur', 13000, 'Tersedia'),
('7', 'Martabak Telur + Daging', 18000, 'Tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `id_order` varchar(10) NOT NULL,
  `no_meja` varchar(10) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `id_user` varchar(10) DEFAULT NULL,
  `keterangan` varchar(30) DEFAULT NULL,
  `status_order` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`id_order`, `no_meja`, `tanggal`, `id_user`, `keterangan`, `status_order`) VALUES
('ORD-0658', '0', '2021-02-17', 'USR001', '3', 'Delivery'),
('ORD-1052', '2', '2021-02-03', 'USR001', '1', 'Ditempat'),
('ORD-1259', '4', '2021-02-17', 'USR001', '2', 'Ditempat'),
('ORD-1275', '0', '2021-02-17', 'USR001', '2', 'Delivery'),
('ORD-1406', '0', '2021-02-17', 'USR001', '1', 'Delivery'),
('ORD-2129', '0', '2020-11-11', 'USR001', '4', 'Delivery'),
('ORD-2182', '0', '2020-11-20', 'USR005', '1', 'Delivery'),
('ORD-2253', '0', '2021-02-17', 'USR001', '2', 'Delivery'),
('ORD-3660', '2', '2021-02-17', 'USR001', '1', 'Ditempat'),
('ORD-4580', '2', '2020-11-20', 'USR005', '1', 'Ditempat'),
('ORD-5246', '1', '2020-11-11', 'USR001', '2', 'Ditempat'),
('ORD-8727', '1', '2021-02-17', 'USR001', '2', 'Ditempat'),
('ORD-8753', '0', '2021-02-17', 'USR001', '2', 'Delivery'),
('ORD-9347', '0', '2020-11-20', 'USR001', '1', 'Delivery'),
('ORD-9388', '1', '2021-02-03', 'USR001', '1', 'Ditempat');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(10) NOT NULL,
  `id_user` varchar(10) DEFAULT NULL,
  `id_order` varchar(10) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `total_bayar` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_user`, `id_order`, `tanggal`, `total_bayar`) VALUES
(1, 'USR001', 'ORD-5246', '2020-11-12', 40000),
(2, 'USR001', 'ORD-5246', '2021-02-03', 40000),
(3, 'USR001', 'ORD-1259', '2021-02-17', 40000),
(4, 'USR001', 'ORD-0658', '2021-02-17', 15000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` varchar(10) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `nama_user` varchar(25) DEFAULT NULL,
  `id_level` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `nama_user`, `id_level`) VALUES
('USR001', 'admin', 'admin', 'Ari Kurniawan', 1),
('USR002', 'waiter', 'waiter', 'Andre Nugroho', 2),
('USR003', 'kasir', 'kasir', 'Dimas Sulistiyo', 3),
('USR004', 'owner', 'owner', 'Ari Kurniawan', 4),
('USR005', 'pelanggan', 'pelanggan', 'Andre Nugroho', 5),
('USR006', 'rafa', '123', 'rafa', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detail_order`
--
ALTER TABLE `detail_order`
  ADD PRIMARY KEY (`id_detail_order`),
  ADD KEY `id_order` (`id_order`),
  ADD KEY `id_masakan` (`id_masakan`);

--
-- Indexes for table `level`
--
ALTER TABLE `level`
  ADD PRIMARY KEY (`id_level`);

--
-- Indexes for table `masakan`
--
ALTER TABLE `masakan`
  ADD PRIMARY KEY (`id_masakan`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_order` (`id_order`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_level` (`id_level`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detail_order`
--
ALTER TABLE `detail_order`
  MODIFY `id_detail_order` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_order`
--
ALTER TABLE `detail_order`
  ADD CONSTRAINT `detail_order_ibfk_1` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`),
  ADD CONSTRAINT `detail_order_ibfk_2` FOREIGN KEY (`id_masakan`) REFERENCES `masakan` (`id_masakan`);

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_level`) REFERENCES `level` (`id_level`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
