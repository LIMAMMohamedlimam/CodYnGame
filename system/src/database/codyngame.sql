-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 18, 2024 at 03:29 AM
-- Server version: 8.0.34
-- PHP Version: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `codyngame`
--

-- --------------------------------------------------------

--
-- Table structure for table `Problem`
--

DROP TABLE IF EXISTS `Problem`;
CREATE TABLE IF NOT EXISTS `Problem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` text NOT NULL,
  `description` text NOT NULL,
  `solutionFile` text NOT NULL,
  `difficulty` VARCHAR(10) NOT NULL DEFAULT "Medium",
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- UUID for unique identifier
    username VARCHAR(255) UNIQUE NOT NULL, -- Unique username
    password VARCHAR(255) DEFAULT NULL,    -- Password can be NULL
    email VARCHAR(255) DEFAULT NULL        -- Email can be NULL
);

--
-- Dumping data for table `Problem`
--

INSERT INTO `Problem` (`id`, `title`, `description`, `solutionFile`) VALUES
(1, 'Two Sum', 'Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.\r\n\r\n	You may assume that each input would have exactly one solution, and you may not use the same element twice.\r\n\r\n	You can return the answer in any order.\r\n\r\n	\r\n\r\n	Example 1:\r\n\r\n	Input: nums = [2,7,11,15], target = 9\r\n	Output: [0,1]\r\n	Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].\r\n	Example 2:\r\n\r\n	Input: nums = [3,2,4], target = 6\r\n	Output: [1,2]\r\n	Example 3:\r\n\r\n	Input: nums = [3,3], target = 6\r\n	Output: [0,1]',  '/home/mohamed/Java_IHM/CodYnGame/DataGenFiles/TwoSumGen.py'),
(2, 'Longest Substring Without Repeating Characters', 'Given a string s, find the length of the longest \r\n	substring\r\n without repeating characters.\r\n\r\n \r\n\r\nExample 1:\r\n\r\nInput: s = \'abcabcbb\'\r\nOutput: 3\r\nExplanation: The answer is \'abc\', with the length of 3.\r\nExample 2:\r\n\r\nInput: s = \'bbbbb\'\r\nOutput: 1\r\nExplanation: The answer is \'b\', with the length of 1.\r\nExample 3:\r\n\r\nInput: s = \'pwwkew\'\r\nOutput: 3\r\nExplanation: The answer is \'wke\', with the length of 3.\r\nNotice that the answer must be a substring, \'pwke\' is a subsequence and not a substring.', '/home/mohamed/Java_IHM/CodYnGame/DataGenFiles/LongestSubstringWithoutRepeatingCharactersGen.py'),
(3, 'Calculate the multiplication and sum of two numbers', 'Given two integer numbers, return their product only if the product is equal to or lower than 1000. Otherwise, return their sum.\r\n\r\nGiven 1:\r\n\r\nnumber1 = 20\r\nnumber2 = 30\r\nExpected Output:\r\n\r\nThe result is 600\r\nGiven 2:\r\n\r\nnumber1 = 40\r\nnumber2 = 30\r\nExpected Output:\r\n\r\nThe result is 70',  '/home/mohamed/Java_IHM/CodYnGame/DataGenFiles/CalculaTheMultiplicationAndSumOfTwoNumbersGen.py'),
(4, 'Reverse Integer\r\n', 'Given a signed 32-bit integer x, return x with its digits reversed.\r\n\r\nExample Input:\r\nx = 123\r\n\r\nExample Output:\r\n321','/home/mohamed/Java_IHM/CodYnGame/DataGenFiles/ReverseIntegerGen.py'),
(5, 'Palindrome Number\r\n', 'Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.\r\n\r\nExample Input:\r\nx = 121\r\n\r\nExample Output:\r\nTrue', '/home/mohamed/Java_IHM/CodYnGame/DataGenFiles/PalindromeNumberGen.py'),
(6, 'Roman to Integer', 'Convert a Roman numeral to an integer.\r\n\r\nExample Input:\r\ns = \"III\"\r\n\r\nExample Output:\r\n3',  '/home/mohamed/Java_IHM/CodYnGame/DataGenFiles/RomantoIntegerGen.py'),
(7, 'Valid Parentheses', 'Given a string containing just the characters \'(\', \')\', \'{\', \'}\', \'[\' and \']\', determine if the input string is valid.\r\n\r\nExample Input:\r\ns = \"()[]{}\"\r\n\r\nExample Output:\r\nTrue', '/home/mohamed/Java_IHM/CodYnGame/DataGenFiles/ValidParenthesesGen.py'),
(8, 'Container With Most Water\r\n', 'Given n non-negative integers height, where each represents a point at coordinate (i, height[i]), n vertical lines are drawn such that the two endpoints of the line i are at (i, height[i]) and (i, 0). Find two lines, which, together with the x-axis, forms a container, such that the container contains the most water. Your program should return the area of the container.\r\n\r\nExample Input:\r\nheight = [1,8,6,2,5,4,8,3,7]\r\n\r\nExample Output:\r\n49', '/home/mohamed/Java_IHM/CodYnGame/DataGenFiles/ContainerWithMostWaterGen.py'),
(9, 'Merge Two Sorted Lists', 'Merge two sorted linked lists and return it as a new sorted list.\r\n\r\nExample Input:\r\nl1 = [1,2,4], l2 = [1,3,4]\r\n\r\nExample Output:\r\n[1,1,2,3,4,4]','/home/mohamed/Java_IHM/CodYnGame/DataGenFiles/MergeTwoSortedListsGen.py'),
(10, 'Longest Common Prefix\r\n', 'Write a function to find the longest common prefix string amongst an array of strings.\r\nExample Input:\r\nstrs = [\"flower\",\"flow\",\"flight\"]\r\n\r\nExample Output:\r\n\"fl\"',  '/home/mohamed/Java_IHM/CodYnGame/DataGenFiles/LongestCommonPrefixGen.py'),
(11, 'Valid Sudoku', 'Determine if a 9x9 Sudoku board is valid.\r\n\r\nExample Input:\r\nboard = [\r\n  [\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],\r\n  [\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],\r\n  [\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],\r\n  [\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],\r\n  [\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],\r\n  [\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],\r\n  [\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],\r\n  [\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],\r\n  [\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]\r\n]\r\n\r\nExample Output:\r\nTrue', '/home/mohamed/Java_IHM/CodYnGame/DataGenFiles/ValidSudokuGen.py');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
