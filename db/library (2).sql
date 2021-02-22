-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 22, 2020 at 05:11 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `employee_id` varchar(100) NOT NULL,
  `secret_ques` varchar(100) NOT NULL,
  `secret_ques_ans` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`, `employee_id`, `secret_ques`, `secret_ques_ans`) VALUES
('admin', 'admin', '123', 'your pet name?', 'lucy'),
('adminship', '123', '5898', 'asqdf', 'qwdqwdqwed');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `book_id` varchar(20) NOT NULL,
  `book_name` varchar(100) NOT NULL,
  `author` varchar(50) NOT NULL,
  `book_genre` varchar(100) NOT NULL,
  `available_books` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`book_id`, `book_name`, `author`, `book_genre`, `available_books`) VALUES
('1407', 'history', 'qs edfc', 'CSE', 9),
('1408', 'archeology', 'jpg', 'Pharmacy', 12),
('1409', 'bnagla', 'kaium', 'English', 16),
('1410', 'sea', 'kkl', 'Architecture', 10);

-- --------------------------------------------------------

--
-- Table structure for table `issue`
--

CREATE TABLE `issue` (
  `issue_no` int(11) NOT NULL,
  `book_id` varchar(20) NOT NULL,
  `student_id` int(11) NOT NULL,
  `issue_date` date NOT NULL,
  `last_day_of_return` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issue`
--

INSERT INTO `issue` (`issue_no`, `book_id`, `student_id`, `issue_date`, `last_day_of_return`) VALUES
(1, '1407', 15201082, '2020-07-25', '2020-08-08'),
(3, '1407', 15201081, '2020-07-25', '2020-08-08'),
(4, '1408', 15201081, '2020-07-25', '2020-08-08'),
(5, '1409', 15201088, '2020-07-25', '2020-08-08'),
(6, '1410', 15201088, '2020-07-25', '2020-08-08'),
(7, '1408', 15201085, '2020-07-26', '2020-08-09'),
(8, '1408', 15201082, '2020-07-26', '2020-08-09'),
(9, '1409', 15201082, '2020-07-26', '2020-08-09'),
(10, '1410', 15201082, '2020-07-26', '2020-08-09');

-- --------------------------------------------------------

--
-- Table structure for table `librarian`
--

CREATE TABLE `librarian` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `employee_id` varchar(20) NOT NULL,
  `secret_ques` varchar(100) NOT NULL,
  `secret_ques_ans` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `librarian`
--

INSERT INTO `librarian` (`username`, `password`, `employee_id`, `secret_ques`, `secret_ques_ans`) VALUES
('librarian', 'librarian', '1407', 'My schhol name?', 'uskc'),
('weeff', 'ddvfdv', 'fefwd', 'qwdwd', 'qwdwd');

-- --------------------------------------------------------

--
-- Table structure for table `retrieve`
--

CREATE TABLE `retrieve` (
  `retrieve_no` int(11) NOT NULL,
  `issue_no` int(11) NOT NULL,
  `book_id` varchar(20) NOT NULL,
  `student_id` int(11) NOT NULL,
  `issue_date` date NOT NULL,
  `last_day_of_return` date NOT NULL,
  `retrieve_day` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `retrieve`
--

INSERT INTO `retrieve` (`retrieve_no`, `issue_no`, `book_id`, `student_id`, `issue_date`, `last_day_of_return`, `retrieve_day`) VALUES
(1, 2, '1408', 15201082, '2020-07-25', '2020-08-08', '2020-07-26');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `student_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `department` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`student_id`, `name`, `department`) VALUES
(15201081, 'manik', 'CSE'),
(15201082, 'sharif', 'CSE'),
(15201085, 'anik', 'CSE'),
(15201088, 'kiron', 'CSE'),
(15201092, 'Tawfique Ahmed', 'Architecture'),
(15201106, 'Rahimul Islam', 'Civil'),
(15201112, 'asraful quiyum', 'CSE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`book_id`),
  ADD UNIQUE KEY `book_id` (`book_id`);

--
-- Indexes for table `issue`
--
ALTER TABLE `issue`
  ADD PRIMARY KEY (`issue_no`),
  ADD KEY `book_id` (`book_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `librarian`
--
ALTER TABLE `librarian`
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `retrieve`
--
ALTER TABLE `retrieve`
  ADD PRIMARY KEY (`retrieve_no`),
  ADD UNIQUE KEY `retrieve_no` (`retrieve_no`),
  ADD UNIQUE KEY `issue_no` (`issue_no`),
  ADD KEY `book_id` (`book_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`student_id`),
  ADD UNIQUE KEY `student_id` (`student_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `issue`
--
ALTER TABLE `issue`
  MODIFY `issue_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `retrieve`
--
ALTER TABLE `retrieve`
  MODIFY `retrieve_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `issue`
--
ALTER TABLE `issue`
  ADD CONSTRAINT `issue_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `books` (`book_id`),
  ADD CONSTRAINT `issue_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`);

--
-- Constraints for table `retrieve`
--
ALTER TABLE `retrieve`
  ADD CONSTRAINT `retrieve_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `books` (`book_id`),
  ADD CONSTRAINT `retrieve_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
