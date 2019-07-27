CREATE DATABASE  IF NOT EXISTS `db_krisela` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_krisela`;
-- MySQL dump 10.16  Distrib 10.1.38-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: db_krisela
-- ------------------------------------------------------
-- Server version	10.1.38-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `coba`
--

DROP TABLE IF EXISTS `coba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coba` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coba`
--

LOCK TABLES `coba` WRITE;
/*!40000 ALTER TABLE `coba` DISABLE KEYS */;
/*!40000 ALTER TABLE `coba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id_customer` int(11) NOT NULL AUTO_INCREMENT,
  `nama_perusahaan` varchar(30) DEFAULT NULL,
  `alamat` varchar(60) DEFAULT NULL,
  `no_telepon` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'PT Maju Mundur','Jalan-in aja dulu','08xx'),(2,'PT Renalmed Tiara Utama','Jalan-nya sama aku nikahnya sa','08xx'),(3,'PT Putra Mandiri','Gg PU','08xx');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jenis_barang`
--

DROP TABLE IF EXISTS `jenis_barang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jenis_barang` (
  `id_barang` int(11) NOT NULL AUTO_INCREMENT,
  `nama_barang` varchar(30) DEFAULT NULL,
  `jenis_barang` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_barang`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jenis_barang`
--

LOCK TABLES `jenis_barang` WRITE;
/*!40000 ALTER TABLE `jenis_barang` DISABLE KEYS */;
INSERT INTO `jenis_barang` VALUES (1,'Lampu Sinyoku','Elektronik'),(2,'Gerinda','Perkakas'),(3,'Bor duduk','Perkakas'),(4,'Lampung tembak krisbow','Elektronik'),(5,'Roda Omni','Komponen Robot'),(6,'Servo','Komponen Robot'),(7,'Mini Pc','Komponen Robot'),(8,'Kipas angin','Elektronik'),(9,'Rice Coocker','Elektronik'),(10,'Setrika','Elektronik');
/*!40000 ALTER TABLE `jenis_barang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peminjaman`
--

DROP TABLE IF EXISTS `peminjaman`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peminjaman` (
  `id_peminjaman` int(11) NOT NULL AUTO_INCREMENT,
  `id_customer` int(11) DEFAULT NULL,
  `id_barang` int(11) DEFAULT NULL,
  `berat` varchar(5) DEFAULT NULL,
  `tanggal_pinjam` date DEFAULT NULL,
  `tanggal_kembali` date DEFAULT NULL,
  `lokasi` varchar(30) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_peminjaman`),
  KEY `id_customer` (`id_customer`),
  KEY `id_barang` (`id_barang`),
  CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`id_barang`) REFERENCES `jenis_barang` (`id_barang`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peminjaman`
--

LOCK TABLES `peminjaman` WRITE;
/*!40000 ALTER TABLE `peminjaman` DISABLE KEYS */;
INSERT INTO `peminjaman` VALUES (1,1,1,'Kg','2012-07-02','2012-07-12','Depok',5000000),(2,1,2,'Kg','2012-07-12','2012-07-24','Lampung',7500000),(3,1,3,'Kg','2012-07-01','2012-07-20','Palembang',10000000),(4,1,4,'Kg','2012-08-01','2012-08-20','Yogyakarta',6500000),(5,2,5,'Kg','2012-09-02','2012-09-20','Palangka Raya',8000000),(6,2,6,'Kg','2012-10-15','2012-10-20','Banjarmasin',9600000),(7,2,7,'Kg','2012-11-10','2012-11-27','Jakarta',7600000);
/*!40000 ALTER TABLE `peminjaman` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pengguna`
--

DROP TABLE IF EXISTS `pengguna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pengguna` (
  `username` varchar(15) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pengguna`
--

LOCK TABLES `pengguna` WRITE;
/*!40000 ALTER TABLE `pengguna` DISABLE KEYS */;
/*!40000 ALTER TABLE `pengguna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piutang`
--

DROP TABLE IF EXISTS `piutang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `piutang` (
  `id_piutang` int(11) NOT NULL AUTO_INCREMENT,
  `id_peminjaman` int(11) DEFAULT NULL,
  `tanggal_bayar` date DEFAULT NULL,
  `jumlah_bayar` int(11) DEFAULT NULL,
  `saldo_piutang` int(11) DEFAULT NULL,
  `keterangan` enum('LUNAS','BELUM LUNAS') DEFAULT NULL,
  PRIMARY KEY (`id_piutang`),
  KEY `id_peminjaman` (`id_peminjaman`),
  CONSTRAINT `piutang_ibfk_1` FOREIGN KEY (`id_peminjaman`) REFERENCES `peminjaman` (`id_peminjaman`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piutang`
--

LOCK TABLES `piutang` WRITE;
/*!40000 ALTER TABLE `piutang` DISABLE KEYS */;
INSERT INTO `piutang` VALUES (1,1,'2012-07-03',1000000,4000000,'BELUM LUNAS'),(2,1,'2012-07-04',1000000,3000000,'BELUM LUNAS'),(3,1,'2012-07-05',1000000,2000000,'BELUM LUNAS'),(4,2,'2012-07-13',1500000,6000000,'BELUM LUNAS'),(5,2,'2012-07-14',2000000,4000000,'BELUM LUNAS'),(6,2,'2012-07-14',4000000,0,'LUNAS');
/*!40000 ALTER TABLE `piutang` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-27 10:22:41
