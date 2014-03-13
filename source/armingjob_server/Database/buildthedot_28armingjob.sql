-- phpMyAdmin SQL Dump
-- version 4.0.6deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 13, 2014 at 11:05 AM
-- Server version: 5.5.35-0ubuntu0.13.10.2
-- PHP Version: 5.5.3-1ubuntu2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `buildthedot_28armingjob`
--

-- --------------------------------------------------------

--
-- Table structure for table `buildthedot_armingjob_company`
--

CREATE TABLE IF NOT EXISTS `buildthedot_armingjob_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `website` text COLLATE utf8_unicode_ci NOT NULL,
  `company_pic` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT 'file',
  `short_address` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `full_address` varchar(225) COLLATE utf8_unicode_ci NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `TopCompanyName` (`company_name`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `buildthedot_armingjob_company`
--

INSERT INTO `buildthedot_armingjob_company` (`id`, `company_name`, `website`, `company_pic`, `short_address`, `full_address`, `time`) VALUES
(1, 'JASPAL', 'http://www.jaspal.com/', '', '', '', '2014-01-23 02:45:23');

-- --------------------------------------------------------

--
-- Table structure for table `buildthedot_armingjob_job`
--

CREATE TABLE IF NOT EXISTS `buildthedot_armingjob_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `position_thai` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `position_eng` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `salary` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `job_description` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `date_start` date NOT NULL,
  `date_end` date NOT NULL,
  `job_type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `buildthedot_armingjob_job`
--

INSERT INTO `buildthedot_armingjob_job` (`id`, `company_id`, `position_thai`, `position_eng`, `salary`, `job_description`, `date_start`, `date_end`, `job_type`) VALUES
(1, 'Whiteboard.Co.,Ltd.', 'Marketing / Business Development', 'Marketing / Business Development', '3x,xxx ', 'Whiteboard is a small company that provided creative business IT solutions to our customers. We are expanding our business scope to both IT and Non-IT related business.\r\n \r\nJob Description : Establish relationships with customers B2B, or B2C. / Calling, or visiting clients on a regular basis, promoting features and benefits of the company products and services./ Develop new potential markets. /Develop and implement marketing plan. /Analyze the strengths and weaknesses of competitors, and monitor new trends. \r\n', '2013-11-22', '2014-12-22', 1),
(2, 'aaaa', 'aaaaaaa', 'aaaaaaaaaaa', '10000', 'aaaaaa', '2014-01-08', '2014-01-17', 2);

-- --------------------------------------------------------

--
-- Table structure for table `buildthedot_armingjob_user_account`
--

CREATE TABLE IF NOT EXISTS `buildthedot_armingjob_user_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `firstname` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `midname` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `nickname` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `profile_picture` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `job_id` int(40) NOT NULL,
  `job_status` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `admin_status` int(1) NOT NULL,
  `birthdate` date NOT NULL,
  `place_of_birth` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `age` int(10) NOT NULL,
  `nationality` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `religion` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `height` int(10) NOT NULL,
  `weight` int(10) NOT NULL,
  `blood` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `lesion` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `current_address` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `relationship_status` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `pouse_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `number_of_children` int(10) NOT NULL,
  `military_status` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `current_address_status` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `father_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `father_age` int(10) NOT NULL,
  `father_career` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `father_live_status` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `mother_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `mother_age` int(10) NOT NULL,
  `mother_career` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `mother_live_status` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Dumping data for table `buildthedot_armingjob_user_account`
--

INSERT INTO `buildthedot_armingjob_user_account` (`id`, `email`, `password`, `firstname`, `midname`, `lastname`, `nickname`, `profile_picture`, `job_id`, `job_status`, `admin_status`, `birthdate`, `place_of_birth`, `age`, `nationality`, `religion`, `height`, `weight`, `blood`, `lesion`, `current_address`, `phone_number`, `relationship_status`, `pouse_name`, `number_of_children`, `military_status`, `current_address_status`, `father_name`, `father_age`, `father_career`, `father_live_status`, `mother_name`, `mother_age`, `mother_career`, `mother_live_status`) VALUES
(1, 'a@a.com', '77de54ccf56eb6f7dbf99e4d3be949ab6f9b0a55df8ac28564cb9f63a10be8af6ab3f7c2', 'a', 'a', 'a', '', 'user_1__CN5:-Sensory-and-Motor-Mastication---Google-Chrome_052.png', 1, '1', 1, '2013-11-07', '', 0, '', '', 0, 0, '', '', '', '', '', '', 0, '', 'home', '1', 0, '', '', '', 0, '', ''),
(2, 'huineken@gmail.com', '0144712dd81be0c3d9724f5e56ce668567a74306b06d0c01624fe0d0249a570f4d093747', '', '', '', '', '', 0, '', 0, '2013-11-29', '', 0, '', '', 0, 0, '', '', '', '', '', '', 0, 'pass_commandeering_soldier', 'live_with_parent', '', 0, '', '', '', 0, '', ''),
(3, 'guy-phuttikul@hotmail.com', '0144712dd81be0c3d9724f5e56ce668567a74306b06d0c01624fe0d0249a570f4d093747', '', '', '', '', 'user_3_1385720880_phuttikul.jpg', 0, '', 0, '1989-11-23', 'เพชรบุรี', 24, 'ไทย', 'พุทธ', 180, 90, 'โอ', '-', '6/170 ม.3 หมู่บ้านสุขสันต์9 ซ.เพชรเกษม100 แขวงหนองค้างพลู เขตหนองแขม กทม 10160', '0817107885', 'single', '-', 0, 'study_education', 'home', 'นายกิติภูมิ คีรีวรรณ', 51, 'รับราชการ', 'live', 'นางวาสนา คีรีวรรณ', 50, '-', 'live'),
(4, 'tmjning@gmail.com', '0144712dd81be0c3d9724f5e56ce668567a74306b06d0c01624fe0d0249a570f4d093747', '', '', '', '', 'user_4_1390417973_ninggggg123.jpg', 0, '', 0, '1986-10-12', 'น่าน', 27, 'ไทย', 'พุทธ', 152, 65, 'โอ', 'ไฝ', '67 ถ.เจริญกรุง กทม. 10120', '0909100389', 'single', '-', 0, 'other', 'home', 'a', 67, 'b', 'died', 'b', 63, 'd', 'live');

-- --------------------------------------------------------

--
-- Table structure for table `buildthedot_armingjob_user_account_reference_contacts`
--

CREATE TABLE IF NOT EXISTS `buildthedot_armingjob_user_account_reference_contacts` (
  `user_account_reference_contacts_id` int(100) NOT NULL AUTO_INCREMENT,
  `user_account_id` int(100) NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `relationship` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `workplace` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `position` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`user_account_reference_contacts_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `buildthedot_armingjob_user_account_reference_contacts`
--

INSERT INTO `buildthedot_armingjob_user_account_reference_contacts` (`user_account_reference_contacts_id`, `user_account_id`, `name`, `relationship`, `workplace`, `position`, `phone_number`) VALUES
(1, 2, '', '', '', '', 'งงจุง'),
(2, 3, 'นายกิติภูมิ คีรีวรรณ', 'บิดา', 'กรมศุลกากร', 'นักวิชาการระดับสูง', '0814855139'),
(3, 4, '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `buildthedot_armingjob_user_history_educations`
--

CREATE TABLE IF NOT EXISTS `buildthedot_armingjob_user_history_educations` (
  `user_history_educations_id` int(50) NOT NULL AUTO_INCREMENT,
  `user_account_id` int(50) NOT NULL,
  `education_level` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `Institution` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `date_start` date NOT NULL,
  `date_end` date NOT NULL,
  `educational_background` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`user_history_educations_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `buildthedot_armingjob_user_history_educations`
--

INSERT INTO `buildthedot_armingjob_user_history_educations` (`user_history_educations_id`, `user_account_id`, `education_level`, `Institution`, `date_start`, `date_end`, `educational_background`) VALUES
(1, 4, 'ปริญญาตรี', 'มหิดล', '2005-01-26', '2007-01-26', 'ปริญญาตรี');

-- --------------------------------------------------------

--
-- Table structure for table `buildthedot_armingjob_user_history_experiences`
--

CREATE TABLE IF NOT EXISTS `buildthedot_armingjob_user_history_experiences` (
  `user_history_experiences_id` int(50) NOT NULL AUTO_INCREMENT,
  `user_account_id` int(11) NOT NULL,
  `job_position` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `company_name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `date_start` date NOT NULL,
  `date_end` date NOT NULL,
  `salary` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`user_history_experiences_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `buildthedot_armingjob_user_history_talent_languages`
--

CREATE TABLE IF NOT EXISTS `buildthedot_armingjob_user_history_talent_languages` (
  `user_history_talent_languages_id` int(50) NOT NULL AUTO_INCREMENT,
  `user_account_id` int(50) NOT NULL,
  `language` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`user_history_talent_languages_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `buildthedot_armingjob_user_history_talent_others`
--

CREATE TABLE IF NOT EXISTS `buildthedot_armingjob_user_history_talent_others` (
  `user_history_talent_others_id` int(50) NOT NULL AUTO_INCREMENT,
  `user_account_id` int(50) NOT NULL,
  `topic` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`user_history_talent_others_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
