-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 31, 2023 at 08:01 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_myschool`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_department`
--

DROP TABLE IF EXISTS `tb_department`;
CREATE TABLE IF NOT EXISTS `tb_department` (
  `dpid` int(10) NOT NULL AUTO_INCREMENT,
  `dpname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`dpid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tb_department`
--

INSERT INTO `tb_department` (`dpid`, `dpname`) VALUES
(1, 'ບໍລິຫານທຸລະກິດ'),
(2, 'ເຕັກໂນໂລຊີໄຟຟ້າ'),
(3, 'ກໍ່ສ້າງເຄຫະສະຖານ');

-- --------------------------------------------------------

--
-- Table structure for table `tb_major`
--

DROP TABLE IF EXISTS `tb_major`;
CREATE TABLE IF NOT EXISTS `tb_major` (
  `majorID` int(10) NOT NULL AUTO_INCREMENT,
  `dpID` int(10) NOT NULL,
  `majorName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`majorID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tb_major`
--

INSERT INTO `tb_major` (`majorID`, `dpID`, `majorName`) VALUES
(1, 1, 'ບັນຊີ'),
(4, 1, 'ການຕະຫຼາດ'),
(8, 1, 'ເຕັກໂນໂລຊີຂໍ້ມູນຂ່າວສານ'),
(9, 2, 'ຫກດຫກດ');

-- --------------------------------------------------------

--
-- Table structure for table `tb_student`
--

DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE IF NOT EXISTS `tb_student` (
  `sid` int(10) NOT NULL AUTO_INCREMENT,
  `scode` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sdfb` date NOT NULL,
  `majorID` int(10) NOT NULL,
  `sgender` int(10) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tb_teacher`
--

DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE IF NOT EXISTS `tb_teacher` (
  `tid` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ໄອດີອາຈານ',
  `majorID` int(10) NOT NULL,
  `tname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tel` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE IF NOT EXISTS `tb_user` (
  `userID` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`userID`, `userName`, `password`) VALUES
(1, 'admin', 'admin'),
(2, 'root', '123'),
(3, 'u1', '111'),
(4, 'uu', '123'),
(5, 'java', '123'),
(6, 'ui', '123');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
