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
  `defaultCode` text ,
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

INSERT INTO `Problem` (`id`, `title`, `description`, `solutionFile`, `defaultCode`) VALUES
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


CREATE TABLE modeInclude (
    probId INT ,
    probtitle VARCHAR(255),
    filepath VARCHAR(255),
    language VARCHAR(50),
    FOREIGN KEY (probId) REFERENCES Problem(id)
);

---INSERT INTO modeInclude (probId ,probtitle, filepath, language) VALUES
---(1,'Two Sum', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Two Sum.c', 'C'),
---(1,'Two Sum', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Two Sum.py', 'Python'),
---(1,'Two Sum', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Two Sum.js', 'JavaScript'),
---(1,'Two Sum', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Two Sum.php', 'PHP'),
---(1,'Two Sum', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Two Sum.java', 'Java'),
---
---(2,'Longest Substring Without Repeating Characters', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Longest Substring Without Repeating Characters.c', 'C'),
---(2,'Longest Substring Without Repeating Characters', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Longest Substring Without Repeating Characters.py', 'Python'),
---(2,'Longest Substring Without Repeating Characters', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Longest Substring Without Repeating Characters.js', 'JavaScript'),
---(2,'Longest Substring Without Repeating Characters', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Longest Substring Without Repeating Characters.php', 'PHP'),
---(2,'Longest Substring Without Repeating Characters', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Longest Substring Without Repeating Characters.java', 'Java'),
---
---(3,'Calculate the multiplication and sum of two numbers', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Calculate the multiplication and sum of two numbers.c', 'C'),
---(3,'Calculate the multiplication and sum of two numbers', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Calculate the multiplication and sum of two numbers.py', 'Python'),
---(3,'Calculate the multiplication and sum of two numbers', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Calculate the multiplication and sum of two numbers.js', 'JavaScript'),
---(3,'Calculate the multiplication and sum of two numbers', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Calculate the multiplication and sum of two numbers.php', 'PHP'),
---(3,'Calculate the multiplication and sum of two numbers', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Calculate the multiplication and sum of two numbers.java', 'Java'),
---
---(4,'Reverse Integer', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Reverse Integer.c', 'C'),
---(4,'Reverse Integer', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Reverse Integer.py', 'Python'),
---(4,'Reverse Integer', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Reverse Integer.js', 'JavaScript'),
---(4,'Reverse Integer', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Reverse Integer.php', 'PHP'),
---(4,'Reverse Integer', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Reverse Integer.java', 'Java'),
---
---(5,'Palindrome Number', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Palindrome Number.c', 'C'),
---(5,'Palindrome Number', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Palindrome Number.py', 'Python'),
---(5,'Palindrome Number', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Palindrome Number.js', 'JavaScript'),
---(5,'Palindrome Number', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Palindrome Number.php', 'PHP'),
---(5,'Palindrome Number', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Palindrome Number.java', 'Java'),
---
---(6,'Roman to Integer', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Roman to Integer.c', 'C'),
---(6,'Roman to Integer', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Roman to Integer.py', 'Python'),
---(6,'Roman to Integer', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Roman to Integer.js', 'JavaScript'),
---(6,'Roman to Integer', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Roman to Integer.php', 'PHP'),
---(6,'Roman to Integer', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Roman to Integer.java', 'Java'),
---
---(7,'Valid Parentheses', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Valid Parentheses.c', 'C'),
---(7,'Valid Parentheses', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Valid Parentheses.py', 'Python'),
---(7,'Valid Parentheses', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Valid Parentheses.js', 'JavaScript'),
---(7,'Valid Parentheses', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Valid Parentheses.php', 'PHP'),
---(7,'Valid Parentheses', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Valid Parentheses.java', 'Java'),
---
---(8,'Container With Most Water', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Container With Most Water.c', 'C'),
---(8,'Container With Most Water', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Container With Most Water.py', 'Python'),
---(8,'Container With Most Water', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Container With Most Water.js', 'JavaScript'),
---(8,'Container With Most Water', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Container With Most Water.php', 'PHP'),
---(8,'Container With Most Water', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Container With Most Water.java', 'Java'),
---
---(9,'Merge Two Sorted Lists', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Merge Two Sorted Lists.c', 'C'),
---(9,'Merge Two Sorted Lists', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Merge Two Sorted Lists.py', 'Python'),
---(9,'Merge Two Sorted Lists', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Merge Two Sorted Lists.js', 'JavaScript'),
---(9,'Merge Two Sorted Lists', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Merge Two Sorted Lists.php', 'PHP'),
---(9,'Merge Two Sorted Lists', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Merge Two Sorted Lists.java', 'Java'),
---
---(10,'Longest Common Prefix', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Longest Common Prefix.c', 'C'),
---(10,'Longest Common Prefix', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Longest Common Prefix.py', 'Python'),
---(10,'Longest Common Prefix', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Longest Common Prefix.js', 'JavaScript'),
---(10,'Longest Common Prefix', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Longest Common Prefix.php', 'PHP'),
---(10,'Longest Common Prefix', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Longest Common Prefix.java', 'Java'),
---
---(11,'Valid Sudoku', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Valid Sudoku.c', 'C'),
---(11,'Valid Sudoku', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Valid Sudoku.py', 'Python'),
---(11,'Valid Sudoku', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Valid Sudoku.js', 'JavaScript'),
---(11,'Valid Sudoku', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Valid Sudoku.php','PHP'),
---(11,'Valid Sudoku', '/home/mohamed/Java_IHM/CodYnGame/modeInclude/Valid Sudoku.java','Java') ;*
---
---
---/*INSERT INTO modeInclude (probId ,probtitle, filepath, language) VALUES
---(1,'Two Sum', 'Two Sum.c', 'C'),
---(1,'Two Sum', 'Two Sum.py', 'Python'),
---(1,'Two Sum', 'Two Sum.js', 'JavaScript'),
---(1,'Two Sum', 'Two Sum.php', 'PHP'),
---(1,'Two Sum', 'Two Sum.java', 'Java'),
---
---(2,'Longest Substring Without Repeating Characters', 'Longest Substring Without Repeating Characters.c', 'C'),
---(2,'Longest Substring Without Repeating Characters', 'Longest Substring Without Repeating Characters.py', 'Python'),
---(2,'Longest Substring Without Repeating Characters', 'Longest Substring Without Repeating Characters.js', 'JavaScript'),
---(2,'Longest Substring Without Repeating Characters', 'Longest Substring Without Repeating Characters.php', 'PHP'),
---(2,'Longest Substring Without Repeating Characters', 'Longest Substring Without Repeating Characters.java', 'Java'),
---
---(3,'Calculate the multiplication and sum of two numbers', 'Calculate the multiplication and sum of two numbers.c', 'C'),
---(3,'Calculate the multiplication and sum of two numbers', 'Calculate the multiplication and sum of two numbers.py', 'Python'),
---(3,'Calculate the multiplication and sum of two numbers', 'Calculate the multiplication and sum of two numbers.js', 'JavaScript'),
---(3,'Calculate the multiplication and sum of two numbers', 'Calculate the multiplication and sum of two numbers.php', 'PHP'),
---(3,'Calculate the multiplication and sum of two numbers', 'Calculate the multiplication and sum of two numbers.java', 'Java'),
---
---(4,'Reverse Integer', 'Reverse Integer.c', 'C'),
---(4,'Reverse Integer', 'Reverse Integer.py', 'Python'),
---(4,'Reverse Integer', 'Reverse Integer.js', 'JavaScript'),
---(4,'Reverse Integer', 'Reverse Integer.php', 'PHP'),
---(4,'Reverse Integer', 'Reverse Integer.java', 'Java'),
---
---(5,'Palindrome Number', 'Palindrome Number.c', 'C'),
---(5,'Palindrome Number', 'Palindrome Number.py', 'Python'),
---(5,'Palindrome Number', 'Palindrome Number.js', 'JavaScript'),
---(5,'Palindrome Number', 'Palindrome Number.php', 'PHP'),
---(5,'Palindrome Number', 'Palindrome Number.java', 'Java'),
---
---(6,'Roman to Integer', 'Roman to Integer.c', 'C'),
---(6,'Roman to Integer', 'Roman to Integer.py', 'Python'),
---(6,'Roman to Integer', 'Roman to Integer.js', 'JavaScript'),
---(6,'Roman to Integer', 'Roman to Integer.php', 'PHP'),
---(6,'Roman to Integer', 'Roman to Integer.java', 'Java'),
---
---(7,'Valid Parentheses', 'Valid Parentheses.c', 'C'),
---(7,'Valid Parentheses', 'Valid Parentheses.py', 'Python'),
---(7,'Valid Parentheses', 'Valid Parentheses.js', 'JavaScript'),
---(7,'Valid Parentheses', 'Valid Parentheses.php', 'PHP'),
---(7,'Valid Parentheses', 'Valid Parentheses.java', 'Java'),
---
---(8,'Container With Most Water', 'Container With Most Water.c', 'C'),
---(8,'Container With Most Water', 'Container With Most Water.py', 'Python'),
---(8,'Container With Most Water', 'Container With Most Water.js', 'JavaScript'),
---(8,'Container With Most Water', 'Container With Most Water.php', 'PHP'),
---(8,'Container With Most Water', 'Container With Most Water.java', 'Java'),
---
---(9,'Merge Two Sorted Lists', 'Merge Two Sorted Lists.c', 'C'),
---(9,'Merge Two Sorted Lists', 'Merge Two Sorted Lists.py', 'Python'),
---(9,'Merge Two Sorted Lists', 'Merge Two Sorted Lists.js', 'JavaScript'),
---(9,'Merge Two Sorted Lists', 'Merge Two Sorted Lists.php', 'PHP'),
---(9,'Merge Two Sorted Lists', 'Merge Two Sorted Lists.java', 'Java'),
---
---(10,'Longest Common Prefix', 'Longest Common Prefix.c', 'C'),
---(10,'Longest Common Prefix', 'Longest Common Prefix.py', 'Python'),
---(10,'Longest Common Prefix', 'Longest Common Prefix.js', 'JavaScript'),
---(10,'Longest Common Prefix', 'Longest Common Prefix.php', 'PHP'),
---(10,'Longest Common Prefix', 'Longest Common Prefix.java', 'Java'),
---
---(11,'Valid Sudoku', 'Valid Sudoku.c', 'C'),
---(11,'Valid Sudoku', 'Valid Sudoku.py', 'Python'),
---(11,'Valid Sudoku', 'Valid Sudoku.js', 'JavaScript'),
---(11,'Valid Sudoku', 'Valid Sudoku.php','PHP'),
---(11,'Valid Sudoku', 'Valid Sudoku.java','Java') ;




INSERT INTO modeInclude (probId, probtitle, filepath, language) VALUES
(1, 'TwoSum', 'TwoSum.h', 'c'),
(1, 'TwoSum', 'TwoSum.py', 'python'),
(1, 'TwoSum', 'TwoSum.js', 'javascript'),
(1, 'TwoSum', 'TwoSum.php', 'php'),
(1, 'TwoSum', 'TwoSum.java', 'java'),

(2, 'LongestSubstringWithoutRepeatingCharacters', 'LongestSubstringWithoutRepeatingCharacters.h', 'c'),
(2, 'LongestSubstringWithoutRepeatingCharacters', 'LongestSubstringWithoutRepeatingCharacters.py', 'python'),
(2, 'LongestSubstringWithoutRepeatingCharacters', 'LongestSubstringWithoutRepeatingCharacters.js', 'javascript'),
(2, 'LongestSubstringWithoutRepeatingCharacters', 'LongestSubstringWithoutRepeatingCharacters.php', 'php'),
(2, 'LongestSubstringWithoutRepeatingCharacters', 'LongestSubstringWithoutRepeatingCharacters.java', 'java'),

(3, 'Calculatethemultiplicationandsumoftwonumbers', 'Calculatethemultiplicationandsumoftwonumbers.h', 'c'),
(3, 'Calculatethemultiplicationandsumoftwonumbers', 'Calculatethemultiplicationandsumoftwonumbers.py', 'python'),
(3, 'Calculatethemultiplicationandsumoftwonumbers', 'Calculatethemultiplicationandsumoftwonumbers.js', 'javascript'),
(3, 'Calculatethemultiplicationandsumoftwonumbers', 'Calculatethemultiplicationandsumoftwonumbers.php', 'php'),
(3, 'Calculatethemultiplicationandsumoftwonumbers', 'Calculatethemultiplicationandsumoftwonumbers.java', 'java'),

(4, 'ReverseInteger', 'ReverseInteger.h', 'c'),
(4, 'ReverseInteger', 'ReverseInteger.py', 'python'),
(4, 'ReverseInteger', 'ReverseInteger.js', 'javascript'),
(4, 'ReverseInteger', 'ReverseInteger.php', 'php'),
(4, 'ReverseInteger', 'ReverseInteger.java', 'java'),

(5, 'PalindromeNumber', 'PalindromeNumber.h', 'c'),
(5, 'PalindromeNumber', 'PalindromeNumber.py', 'python'),
(5, 'PalindromeNumber', 'PalindromeNumber.js', 'javascript'),
(5, 'PalindromeNumber', 'PalindromeNumber.php', 'php'),
(5, 'PalindromeNumber', 'PalindromeNumber.java', 'java'),

(6, 'RomantoInteger', 'RomantoInteger.h', 'c'),
(6, 'RomantoInteger', 'RomantoInteger.py', 'python'),
(6, 'RomantoInteger', 'RomantoInteger.js', 'javascript'),
(6, 'RomantoInteger', 'RomantoInteger.php', 'php'),
(6, 'RomantoInteger', 'RomantoInteger.java', 'java'),

(7, 'ValidParentheses', 'ValidParentheses.h', 'c'),
(7, 'ValidParentheses', 'ValidParentheses.py', 'python'),
(7, 'ValidParentheses', 'ValidParentheses.js', 'javascript'),
(7, 'ValidParentheses', 'ValidParentheses.php', 'php'),
(7, 'ValidParentheses', 'ValidParentheses.java', 'java'),

(8, 'ContainerWithMostWater', 'ContainerWithMostWater.h', 'c'),
(8, 'ContainerWithMostWater', 'ContainerWithMostWater.py', 'python'),
(8, 'ContainerWithMostWater', 'ContainerWithMostWater.js', 'javascript'),
(8, 'ContainerWithMostWater', 'ContainerWithMostWater.php', 'php'),
(8, 'ContainerWithMostWater', 'ContainerWithMostWater.java', 'java'),

(9, 'MergeTwoSortedLists', 'MergeTwoSortedLists.h', 'c'),
(9, 'MergeTwoSortedLists', 'MergeTwoSortedLists.py', 'python'),
(9, 'MergeTwoSortedLists', 'MergeTwoSortedLists.js', 'javascript'),
(9, 'MergeTwoSortedLists', 'MergeTwoSortedLists.php', 'php'),
(9, 'MergeTwoSortedLists', 'MergeTwoSortedLists.java', 'java'),

(10, 'LongestCommonPrefix', 'LongestCommonPrefix.h', 'c'),
(10, 'LongestCommonPrefix', 'LongestCommonPrefix.py', 'python'),
(10, 'LongestCommonPrefix', 'LongestCommonPrefix.js', 'javascript'),
(10, 'LongestCommonPrefix', 'LongestCommonPrefix.php', 'php'),
(10, 'LongestCommonPrefix', 'LongestCommonPrefix.java', 'java'),

(11, 'ValidSudoku', 'ValidSudoku.h', 'c'),
(11, 'ValidSudoku', 'ValidSudoku.py', 'python'),
(11, 'ValidSudoku', 'ValidSudoku.js', 'javascript'),
(11, 'ValidSudoku', 'ValidSudoku.php', 'php'),
(11, 'ValidSudoku', 'ValidSudoku.java', 'java');



DROP TABLE IF EXISTS `default_code`;
CREATE TABLE IF NOT EXISTS `default_code` (
  `id` int NOT NULL AUTO_INCREMENT,
  `problem_id` int DEFAULT NULL,
  `language` enum('C','PHP','Python','Java','JavaScript') DEFAULT NULL,
  `code` text,
  PRIMARY KEY (`id`),
  KEY `problem_id` (`problem_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `default_code`
--

INSERT INTO `default_code` (`id`, `problem_id`, `language`, `code`) VALUES
(1, 1, 'C', '#include <stdio.h>\r\n#include <stdlib.h>\r\n#include <json-c/json.h>\r\n\r\nint* twoSum(int* nums, int numsSize, int target, int* returnSize) {\r\n    //user input\r\n\r\n    //\r\n}\r\n\r\nint main() {\r\n    char buffer[2048];\r\n    FILE* fp = popen(\"python3 TwoSumGen.py gen\", \"r\");\r\n    fread(buffer, 2048, 1, fp);\r\n    pclose(fp);\r\n\r\n    struct json_object* parsed_json;\r\n    struct json_object* nums_json;\r\n    struct json_object* target_json;\r\n\r\n    parsed_json = json_tokener_parse(buffer);\r\n    json_object_object_get_ex(parsed_json, \"nums\", &nums_json);\r\n    json_object_object_get_ex(parsed_json, \"target\", &target_json);\r\n\r\n    int numsSize = json_object_array_length(nums_json);\r\n    int nums[numsSize];\r\n    for (int i = 0; i < numsSize; i++) {\r\n        nums[i] = json_object_get_int(json_object_array_get_idx(nums_json, i));\r\n    }\r\n    int target = json_object_get_int(target_json);\r\n\r\n    int returnSize;\r\n    int* result = twoSum(nums, numsSize, target, &returnSize);\r\n\r\n    if (result != NULL) {\r\n        printf(\"[%d, %d]\\n\", result[0], result[1]);\r\n        free(result);\r\n    } else {\r\n        printf(\"No solution found\\n\");\r\n    }\r\n\r\n    return 0;\r\n}\r\n'),
(2, 1, 'PHP', 'function twoSum($nums, $target) {\r\n    /* input your try here : */\r\n\r\n}\r\n\r\n$output = shell_exec(\'python3 TwoSumGen.py gen\');\r\n$data = json_decode($output, true);\r\n$nums = $data[\'nums\'];\r\n$target = $data[\'target\'];\r\n\r\n$result = twoSum($nums, $target);\r\nif ($result !== null) {\r\n    echo \"[\" . $result[0] . \", \" . $result[1] . \"]\\n\";\r\n} else {\r\n    echo \"No solution found\\n\";\r\n}\r\n'),
(3, 1, 'Python', 'import json\r\nimport subprocess\r\n\r\ndef twoSum(nums, target):\r\n   #input code here\r\n\r\nif __name__ == \"__main__\":\r\n    result = subprocess.run([\'python3\', \'TwoSumGen.py\', \'gen\'], capture_output=True, text=True)\r\n    data = json.loads(result.stdout)\r\n    \r\n    nums = data[\'nums\']\r\n    target = data[\'target\']\r\n    result = twoSum(nums, target)\r\n    \r\n    if result:\r\n        print(result)\r\n    else:\r\n        print(\"No solution found\")\r\n'),
(4, 1, 'Java', 'import org.json.JSONArray;\r\nimport org.json.JSONObject;\r\nimport java.nio.file.Files;\r\nimport java.nio.file.Paths;\r\nimport java.io.IOException;\r\n\r\npublic class Solution {\r\n    public static int[] twoSum(int[] nums, int target) {\r\n        //code here\r\n    }\r\n\r\n    public static void main(String[] args) {\r\n        try {\r\n            ProcessBuilder builder = new ProcessBuilder(\"python3\", \"TwoSumGen.py\", \"gen\");\r\n            Process process = builder.start();\r\n            String content = new String(process.getInputStream().readAllBytes());\r\n            \r\n            JSONObject jsonObject = new JSONObject(content);\r\n            JSONArray numsArray = jsonObject.getJSONArray(\"nums\");\r\n            int target = jsonObject.getInt(\"target\");\r\n\r\n            int[] nums = new int[numsArray.length()];\r\n            for (int i = 0; i < numsArray.length(); i++) {\r\n                nums[i] = numsArray.getInt(i);\r\n            }\r\n\r\n            int[] result = twoSum(nums, target);\r\n            if (result != null) {\r\n                System.out.println(\"[\" + result[0] + \", \" + result[1] + \"]\");\r\n            } else {\r\n                System.out.println(\"No solution found\");\r\n            }\r\n        } catch (IOException e) {\r\n            e.printStackTrace();\r\n        }\r\n    }\r\n}\r\n'),
(5, 1, 'JavaScript', 'const { execSync } = require(\'child_process\');\r\n\r\nfunction twoSum(nums, target) {\r\n    //code here\r\n}\r\n\r\nconst output = execSync(\'python3 TwoSumGen.py gen\');\r\nconst data = JSON.parse(output.toString());\r\nconst nums = data.nums;\r\nconst target = data.target;\r\n\r\nconst result = twoSum(nums, target);\r\nif (result) {\r\n    console.log(result);\r\n} else {\r\n    console.log(\"No solution found\");\r\n}\r\n'),
(6, 2, 'C', '#include <stdio.h>\r\n#include <string.h>\r\n#include <stdlib.h>\r\n\r\nint lengthOfLongestSubstring(char* s) {\r\n    //input code here:\r\n\r\n}\r\n\r\nint main() {\r\n    FILE *fp = popen(\"python LongestSubstringWithoutRepeatingCharactersGen.py gen\", \"r\");\r\n    char s[256];\r\n    fscanf(fp, \"%s\", s);\r\n    fclose(fp);\r\n    int result = lengthOfLongestSubstring(s);\r\n    printf(\"Output: %d\\n\", result);\r\n    return 0;\r\n}\r\n'),
(7, 2, 'PHP', '<?php\r\nfunction lengthOfLongestSubstring($s) {\r\n    /* input here */\r\n}\r\n\r\n$input = shell_exec(\'python LongestSubstringWithoutRepeatingCharactersGen.py gen\');\r\n$data = json_decode($input, true);\r\n$s = $data[\'s\'];\r\n$result = lengthOfLongestSubstring($s);\r\necho \"Output: \" . $result . \"\\n\";\r\n?>\r\n'),
(8, 2, 'Python', 'import subprocess\r\nimport json\r\n\r\ndef lengthOfLongestSubstring(s):\r\n    # code here:\r\n\r\nif __name__ == \"__main__\":\r\n    result = subprocess.run([\'python\', \'LongestSubstringWithoutRepeatingCharactersGen.py\', \'gen\'], capture_output=True, text=True)\r\n    generated_data = json.loads(result.stdout)\r\n    s = generated_data[\'s\']\r\n    output = lengthOfLongestSubstring(s)\r\n    print(\"Output:\", output)\r\n'),
(9, 2, 'Java', 'import java.io.BufferedReader;\r\nimport java.io.InputStreamReader;\r\nimport java.io.IOException;\r\nimport org.json.simple.JSONObject;\r\nimport org.json.simple.parser.JSONParser;\r\nimport org.json.simple.parser.ParseException;\r\n\r\npublic class LongestSubstring {\r\n    public static int lengthOfLongestSubstring(String s) {\r\n        // code here :\r\n    }\r\n\r\n    public static void main(String[] args) {\r\n        try {\r\n            Process process = Runtime.getRuntime().exec(\"python LongestSubstringWithoutRepeatingCharactersGen.py gen\");\r\n            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));\r\n            String jsonInput = reader.readLine();\r\n            JSONParser parser = new JSONParser();\r\n            JSONObject data = (JSONObject) parser.parse(jsonInput);\r\n            String s = (String) data.get(\"s\");\r\n            int result = lengthOfLongestSubstring(s);\r\n            System.out.println(\"Output: \" + result);\r\n        } catch (IOException | ParseException e) {\r\n            e.printStackTrace();\r\n        }\r\n    }\r\n}\r\n'),
(10, 2, 'JavaScript', 'const { execSync } = require(\'child_process\');\r\n\r\nfunction lengthOfLongestSubstring(s) {\r\n    // code here :\r\n}\r\n\r\nconst generatedData = execSync(\'python LongestSubstringWithoutRepeatingCharactersGen.py gen\').toString().trim();\r\nconst data = JSON.parse(generatedData);\r\nconst s = data[\'s\'];\r\nconst output = lengthOfLongestSubstring(s);\r\nconsole.log(\"Output:\", output);\r\n'),
(11, 3, 'C', '#include <stdio.h>\r\n#include <stdlib.h>\r\n\r\nint calculate(int number1, int number2) {\r\n    // insert code here\r\n}\r\n\r\nint main() {\r\n    int number1, number2;\r\n    FILE *fp = popen(\"python CalculaTheMultiplicationAndSumOfTwoNumbersGen.py gen\", \"r\");\r\n    fscanf(fp, \"%d %d\", &number1, &number2);\r\n    fclose(fp);\r\n    int result = calculate(number1, number2);\r\n    printf(\"The result is %d\\n\", result);\r\n    return 0;\r\n}\r\n'),
(12, 3, 'PHP', '<?php\r\nfunction calculate($number1, $number2) {\r\n    // code here :\r\n}\r\n$input = shell_exec(\'python CalculaTheMultiplicationAndSumOfTwoNumbersGen.py gen\');\r\nlist($number1, $number2) = explode(\" \", trim($input));\r\n$result = calculate($number1, $number2);\r\necho \"The result is $result\\n\";\r\n?>\r\n'),
(13, 3, 'Python', 'import subprocess\r\n\r\ndef calculate(number1, number2):\r\n    #code here :\r\n\r\nif __name__ == \"__main__\":\r\n    result = subprocess.run([\'python\', \'CalculaTheMultiplicationAndSumOfTwoNumbersGen.py\', \'gen\'], capture_output=True, text=True)\r\n    generated_data = result.stdout.strip().split()\r\n    number1, number2 = int(generated_data[0]), int(generated_data[1])\r\n    result = calculate(number1, number2)\r\n    print(\"The result is\", result)\r\n'),
(14, 3, 'Java', 'import java.io.BufferedReader;\r\nimport java.io.IOException;\r\nimport java.io.InputStreamReader;\r\n\r\npublic class Calculate {\r\n    public static int calculate(int number1, int number2) {\r\n        //code here :\r\n    }\r\n\r\n    public static void main(String[] args) throws IOException {\r\n        Process process = Runtime.getRuntime().exec(\"python CalculaTheMultiplicationAndSumOfTwoNumbersGen.py gen\");\r\n        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));\r\n        String input = reader.readLine();\r\n        String[] numbers = input.split(\" \");\r\n        int number1 = Integer.parseInt(numbers[0]);\r\n        int number2 = Integer.parseInt(numbers[1]);\r\n        int result = calculate(number1, number2);\r\n        System.out.println(\"The result is \" + result);\r\n    }\r\n}\r\n'),
(15, 3, 'JavaScript', 'const { execSync } = require(\'child_process\');\r\n\r\nconst generatedData = execSync(\'python CalculaTheMultiplicationAndSumOfTwoNumbersGen.py gen\').toString().trim();\r\nconst [number1, number2] = generatedData.split(\' \').map(Number);\r\n\r\nfunction calculate(number1, number2) {\r\n    // code here: \r\n}\r\n\r\nconst result = calculate(number1, number2);\r\nconsole.log(`The result is ${result}`);\r\n'),
(16, 4, 'C', '#include <stdio.h>\r\n#include <stdlib.h>\r\n#include <limits.h>\r\n\r\nint reverse(int x) {\r\n    //code here :\r\n}\r\n\r\nint main() {\r\n    FILE *fp = popen(\"python ReverseIntegerGen.py gen\", \"r\");\r\n    int x;\r\n    fscanf(fp, \"%d\", &x);\r\n    fclose(fp);\r\n\r\n    int result = reverse(x);\r\n    printf(\"Reversed integer: %d\\n\", result);\r\n\r\n    return 0;\r\n}\r\n'),
(17, 4, 'PHP', '<?php\r\n\r\nfunction reverse($x) {\r\n    // code here :\r\n}\r\n\r\n$input = shell_exec(\'python ReverseIntegerGen.py gen\');\r\n$x = (int)trim($input);\r\n$result = reverse($x);\r\necho \"Reversed integer: $result\\n\";\r\n?>\r\n'),
(18, 4, 'Python', 'import subprocess\r\n\r\ndef reverse(x):\r\n    #code here :\r\n\r\nif __name__ == \"__main__\":\r\n    result = subprocess.run([\'python\', \'ReverseIntegerGen.py\', \'gen\'], capture_output=True, text=True)\r\n    x = int(result.stdout.strip())\r\n    reversed_integer = reverse(x)\r\n    print(\"Reversed integer:\", reversed_integer)\r\n'),
(19, 4, 'Java', 'import java.io.BufferedReader;\r\nimport java.io.IOException;\r\nimport java.io.InputStreamReader;\r\n\r\npublic class ReverseInteger {\r\n    public static int reverse(int x) {\r\n     // code here :        \r\n}\r\n\r\n    public static void main(String[] args) throws IOException {\r\n        Process process = Runtime.getRuntime().exec(\"python ReverseIntegerGen.py gen\");\r\n        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));\r\n        int x = Integer.parseInt(reader.readLine());\r\n        int result = reverse(x);\r\n        System.out.println(\"Reversed integer: \" + result);\r\n    }\r\n}\r\n'),
(20, 4, 'JavaScript', 'const { execSync } = require(\'child_process\');\r\n\r\nfunction reverse(x) {\r\n    // code here :\r\n}\r\n\r\nconst generatedData = execSync(\'python ReverseIntegerGen.py gen\').toString().trim();\r\nconst x = parseInt(generatedData);\r\nconst reversedInteger = reverse(x);\r\nconsole.log(\"Reversed integer:\", reversedInteger);\r\n'),
(21, 5, 'C', '#include <stdio.h>\r\n#include <stdlib.h>\r\n#include <stdbool.h>\r\n\r\nbool isPalindrome(int x) {\r\n    // code here :\r\n}\r\n\r\nint main() {\r\n    FILE *fp = popen(\"python PalindromeNumberGen.py gen\", \"r\");\r\n    int x;\r\n    fscanf(fp, \"%d\", &x);\r\n    fclose(fp);\r\n\r\n    bool result = isPalindrome(x);\r\n    printf(\"%s\\n\", result ? \"True\" : \"False\");\r\n\r\n    return 0;\r\n}\r\n'),
(22, 5, 'PHP', '<?php\r\n\r\n\r\nfunction isPalindrome($x) {\r\n    //code here :\r\n}\r\n$input = shell_exec(\'python PalindromeNumberGen.py gen\');\r\n$x = (int)trim($input);\r\n$result = isPalindrome($x) ? \"True\" : \"False\";\r\necho \"$result\\n\";\r\n?>\r\n'),
(23, 5, 'Python', 'import subprocess\r\n\r\ndef isPalindrome(x):\r\n   #code here :\r\n\r\nif __name__ == \"__main__\":\r\n    result = subprocess.run([\'python\', \'PalindromeNumberGen.py\', \'gen\'], capture_output=True, text=True)\r\n    x = int(result.stdout.strip())\r\n    result = isPalindrome(x)\r\n    print(result)\r\n'),
(24, 5, 'Java', 'import java.io.BufferedReader;\r\nimport java.io.IOException;\r\nimport java.io.InputStreamReader;\r\n\r\npublic class PalindromeNumber {\r\n    public static boolean isPalindrome(int x) {\r\n        // code here :\r\n    }\r\n\r\n    public static void main(String[] args) throws IOException {\r\n        Process process = Runtime.getRuntime().exec(\"python PalindromeNumberGen.py gen\");\r\n        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));\r\n        int x = Integer.parseInt(reader.readLine());\r\n        boolean result = isPalindrome(x);\r\n        System.out.println(result);\r\n    }\r\n}\r\n'),
(25, 5, 'JavaScript', 'const { execSync } = require(\'child_process\');\r\n\r\n\r\n\r\nfunction isPalindrome(x) {\r\n    // code here :\r\n}\r\n\r\nconst generatedData = execSync(\'python PalindromeNumberGen.py gen\').toString().trim();\r\nconst x = parseInt(generatedData);\r\nconst result = isPalindrome(x) ? \"True\" : \"False\";\r\nconsole.log(result);\r\n'),
(26, 6, 'C', '#include <stdio.h>\r\n#include <stdlib.h>\r\n#include <string.h>\r\n\r\nint romanToInt(char *s) {\r\n    // code here :\r\n}\r\n\r\nint main() {\r\n    FILE *fp = popen(\"python RomantoIntegerGen.py gen\", \"r\");\r\n    char s[16];\r\n    fgets(s, sizeof(s), fp);\r\n    fclose(fp);\r\n\r\n    s[strcspn(s, \"\\n\")] = 0;\r\n    int result = romanToInt(s);\r\n    printf(\"%d\\n\", result);\r\n\r\n    return 0;\r\n}\r\n'),
(27, 6, 'PHP', '<?php\r\n\r\nfunction romanToInt($s) {\r\n    // code here :\r\n}\r\n\r\n$input = shell_exec(\'python RomantoIntegerGen.py gen\');\r\n$s = trim($input);\r\n$result = romanToInt($s);\r\necho \"$result\\n\";\r\n\r\n?>\r\n'),
(28, 6, 'Python', 'import subprocess\r\n\r\ndef romanToInt(s):\r\n    #code here :\r\n\r\nif __name__ == \"__main__\":\r\n    result = subprocess.run([\'python\', \'RomantoIntegerGen.py\', \'gen\'], capture_output=True, text=True)\r\n    s = result.stdout.strip()\r\n    result = romanToInt(s)\r\n    print(result)\r\n'),
(29, 6, 'Java', 'import java.io.BufferedReader;\r\nimport java.io.IOException;\r\nimport java.io.InputStreamReader;\r\n\r\npublic class RomanToInteger {\r\n    public static int romanToInt(String s) {\r\n        // code here :\r\n    }\r\n\r\n    public static void main(String[] args) throws IOException {\r\n        Process process = Runtime.getRuntime().exec(\"python RomantoIntegerGen.py gen\");\r\n        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));\r\n        String s = reader.readLine();\r\n        int result = romanToInt(s);\r\n        System.out.println(result);\r\n    }\r\n}\r\n'),
(30, 6, 'JavaScript', 'const { execSync } = require(\'child_process\');\r\n\r\n\r\n\r\nfunction romanToInt(s) {\r\n    // code here : \r\n}\r\n\r\nconst generatedData = execSync(\'python RomantoIntegerGen.py gen\').toString().trim();\r\nconst s = generatedData;\r\nconst result = romanToInt(s);\r\nconsole.log(result);\r\n'),
(31, 7, 'C', '#include <stdio.h>\r\n#include <stdlib.h>\r\n#include <string.h>\r\n\r\n#define MAX_SIZE 100\r\n\r\nint isValid(char *s) {\r\n   // code here :\r\n}\r\n\r\nint main() {\r\n    FILE *fp = popen(\"python ValidParenthesesGen.py gen\", \"r\");\r\n    char s[MAX_SIZE];\r\n    fgets(s, sizeof(s), fp);\r\n    fclose(fp);\r\n\r\n    s[strcspn(s, \"\\n\")] = 0;\r\n    int result = isValid(s);\r\n    printf(\"%s\\n\", result ? \"True\" : \"False\");\r\n\r\n    return 0;\r\n}\r\n'),
(32, 7, 'PHP', '<?php\r\n\r\nfunction isValid($s) {\r\n   // code here :\r\n}\r\n\r\n$input = shell_exec(\'python ValidParenthesesGen.py gen\');\r\n$s = trim($input);\r\n$result = isValid($s);\r\necho $result ? \"True\\n\" : \"False\\n\";\r\n?>\r\n'),
(33, 7, 'Python', 'import subprocess\r\n\r\ndef isValid(s):\r\n    #code here :\r\n\r\nif __name__ == \"__main__\":\r\n    result = subprocess.run([\'python\', \'ValidParenthesesGen.py\', \'gen\'], capture_output=True, text=True)\r\n    s = result.stdout.strip()\r\n    result = isValid(s)\r\n    print(result)\r\n'),
(34, 7, 'Java', 'import java.io.BufferedReader;\r\nimport java.io.IOException;\r\nimport java.io.InputStreamReader;\r\nimport java.util.Stack;\r\n\r\npublic class ValidParentheses {\r\n    public static boolean isValid(String s) {\r\n        // code here :\r\n    }\r\n\r\n    public static void main(String[] args) throws IOException {\r\n        Process process = Runtime.getRuntime().exec(\"python ValidParenthesesGen.py gen\");\r\n        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));\r\n        String s = reader.readLine();\r\n        boolean result = isValid(s);\r\n        System.out.println(result);\r\n    }\r\n}\r\n'),
(35, 7, 'JavaScript', 'const { execSync } = require(\'child_process\');\r\n\r\nfunction isValid(s) {\r\n    // code here :\r\n}\r\n\r\nconst generatedData = execSync(\'python ValidParenthesesGen.py gen\').toString().trim();\r\nconst s = generatedData;\r\nconst result = isValid(s);\r\nconsole.log(result);\r\n'),
(36, 8, 'C', '#include <stdio.h>\r\n#include <stdlib.h>\r\n\r\nint maxArea(int* height, int heightSize) {\r\n    // code here : \r\n}\r\n\r\nint main() {\r\n    FILE *fp = popen(\"python ContainerWithMostWaterGen.py gen\", \"r\");\r\n    char s[1000];\r\n    fgets(s, sizeof(s), fp);\r\n    fclose(fp);\r\n\r\n    int height[100];\r\n    int heightSize = 0;\r\n    char *token = strtok(s, \" []\\n,\");\r\n    while (token != NULL) {\r\n        height[heightSize++] = atoi(token);\r\n        token = strtok(NULL, \" []\\n,\");\r\n    }\r\n\r\n    int result = maxArea(height, heightSize);\r\n    printf(\"%d\\n\", result);\r\n\r\n    return 0;\r\n}\r\n'),
(37, 8, 'PHP', '<?php\r\n\r\n\r\nfunction maxArea($height) {\r\n    // code here :\r\n}\r\n\r\n$input = shell_exec(\'python ContainerWithMostWaterGen.py gen\');\r\n$height = json_decode($input, true)[\'height\'];\r\n$result = maxArea($height);\r\necho $result . \"\\n\";\r\n?>\r\n'),
(38, 8, 'Python', 'import subprocess\r\nimport json\r\n\r\ndef maxArea(height):\r\n    #code here :\r\n\r\nif __name__ == \"__main__\":\r\n    result = subprocess.run([\'python\', \'ContainerWithMostWaterGen.py\', \'gen\'], capture_output=True, text=True)\r\n    height = json.loads(result.stdout.strip())[\'height\']\r\n    result = maxArea(height)\r\n    print(result)\r\n'),
(39, 8, 'Java', 'import java.io.BufferedReader;\r\nimport java.io.IOException;\r\nimport java.io.InputStreamReader;\r\n\r\npublic class ContainerWithMostWater {\r\n    public static int maxArea(int[] height) {\r\n        // code here :\r\n    }\r\n\r\n    public static void main(String[] args) throws IOException {\r\n        Process process = Runtime.getRuntime().exec(\"python ContainerWithMostWaterGen.py gen\");\r\n        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));\r\n        StringBuilder sb = new StringBuilder();\r\n        String line;\r\n        while ((line = reader.readLine()) != null) {\r\n            sb.append(line);\r\n        }\r\n        String input = sb.toString();\r\n        String[] heightStr = input.replaceAll(\"[\\\\[\\\\]]\", \"\").split(\", \");\r\n        int[] height = new int[heightStr.length];\r\n        for (int i = 0; i < heightStr.length; i++) {\r\n            height[i] = Integer.parseInt(heightStr[i]);\r\n        }\r\n        int result = maxArea(height);\r\n        System.out.println(result);\r\n    }\r\n}\r\n'),
(40, 8, 'JavaScript', 'const { execSync } = require(\'child_process\');\r\n\r\nfunction maxArea(height) {\r\n      // code here :\r\n}\r\n\r\nconst generatedData = execSync(\'python ContainerWithMostWaterGen.py gen\').toString().trim();\r\nconst height = JSON.parse(generatedData).height;\r\nconst result = maxArea(height);\r\nconsole.log(result);\r\n'),
(41, 9, 'C', '#include <stdio.h>\r\n#include <stdlib.h>\r\n#include <json-c/json.h>\r\n\r\ntypedef struct ListNode {\r\n    int val;\r\n    struct ListNode *next;\r\n} ListNode;\r\n\r\nListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {\r\n    // your code here :\r\n}\r\n\r\nint main() {\r\n    char buffer[4096];\r\n    FILE *fp = popen(\"python3 MergeTwoSortedListsGen.py gen\", \"r\");\r\n    fread(buffer, sizeof(char), sizeof(buffer), fp);\r\n    pclose(fp);\r\n\r\n    struct json_object *parsed_json;\r\n    struct json_object *list1_json;\r\n    struct json_object *list2_json;\r\n\r\n    parsed_json = json_tokener_parse(buffer);\r\n\r\n    json_object_object_get_ex(parsed_json, \"list1\", &list1_json);\r\n    json_object_object_get_ex(parsed_json, \"list2\", &list2_json);\r\n\r\n    int list1_size = json_object_array_length(list1_json);\r\n    int list2_size = json_object_array_length(list2_json);\r\n\r\n    ListNode* l1 = NULL;\r\n    ListNode* l2 = NULL;\r\n    ListNode* temp;\r\n\r\n    for (int i = list1_size - 1; i >= 0; i--) {\r\n        temp = malloc(sizeof(ListNode));\r\n        temp->val = json_object_get_int(json_object_array_get_idx(list1_json, i));\r\n        temp->next = l1;\r\n        l1 = temp;\r\n    }\r\n\r\n    for (int i = list2_size - 1; i >= 0; i--) {\r\n        temp = malloc(sizeof(ListNode));\r\n        temp->val = json_object_get_int(json_object_array_get_idx(list2_json, i));\r\n        temp->next = l2;\r\n        l2 = temp;\r\n    }\r\n\r\n    ListNode* mergedList = mergeTwoLists(l1, l2);\r\n\r\n    ListNode* current = mergedList;\r\n    while (current != NULL) {\r\n        printf(\"%d \", current->val);\r\n        current = current->next;\r\n    }\r\n    printf(\"\\n\");\r\n\r\n    while (mergedList != NULL) {\r\n        temp = mergedList;\r\n        mergedList = mergedList->next;\r\n        free(temp);\r\n    }\r\n\r\n    return 0;\r\n}\r\n'),
(42, 9, 'PHP', '<?php\r\n\r\nfunction mergeTwoLists($l1, $l2) {\r\n    // your code here :\r\n}\r\n\r\n$jsonData = shell_exec(\'python3 MergeTwoSortedListsGen.py gen\');\r\n$data = json_decode($jsonData, true);\r\n$list1 = $data[\'list1\'];\r\n$list2 = $data[\'list2\'];\r\n\r\n$l1 = null;\r\nforeach (array_reverse($list1) as $val) {\r\n    $node = new stdClass();\r\n    $node->val = $val;\r\n    $node->next = $l1;\r\n    $l1 = $node;\r\n}\r\n\r\n$l2 = null;\r\nforeach (array_reverse($list2) as $val) {\r\n    $node = new stdClass();\r\n    $node->val = $val;\r\n    $node->next = $l2;\r\n    $l2 = $node;\r\n}\r\n\r\n$mergedList = mergeTwoLists($l1, $l2);\r\n\r\n$current = $mergedList;\r\nwhile ($current !== null) {\r\n    echo $current->val . \" \";\r\n    $current = $current->next;\r\n}\r\necho \"\\n\";\r\n'),
(43, 9, 'Python', 'import json\r\nimport subprocess\r\n\r\ndef mergeTwoLists(l1, l2):\r\n    #your code here :\r\n\r\njsonData = subprocess.check_output([\'python3\', \'MergeTwoSortedListsGen.py\', \'gen\']).decode(\'utf-8\')\r\ndata = json.loads(jsonData)\r\nlist1 = data[\'list1\']\r\nlist2 = data[\'list2\']\r\n\r\nl1 = None\r\nfor val in reversed(list1):\r\n    node = {\'val\': val, \'next\': l1}\r\n    l1 = node\r\n\r\nl2 = None\r\nfor val in reversed(list2):\r\n    node = {\'val\': val, \'next\': l2}\r\n    l2 = node\r\n\r\nmergedList = mergeTwoLists(l1, l2)\r\n\r\ncurrent = mergedList\r\nwhile current:\r\n    print(current[\'val\'], end=\" \")\r\n    current = current[\'next\']\r\nprint()\r\n'),
(44, 9, 'Java', 'import org.json.JSONArray;\r\nimport org.json.JSONObject;\r\n\r\nimport java.io.BufferedReader;\r\nimport java.io.IOException;\r\nimport java.io.InputStreamReader;\r\nimport java.util.*;\r\n\r\npublic class MergeTwoSortedLists {\r\n\r\n    public static Map<String, Object> mergeTwoLists(Map<String, Object> l1, Map<String, Object> l2) {\r\n      // your code here\r\n    }\r\n\r\n    public static void main(String[] args) throws IOException {\r\n        Process process = Runtime.getRuntime().exec(\"python3 MergeTwoSortedListsGen.py gen\");\r\n        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));\r\n        StringBuilder jsonData = new StringBuilder();\r\n        String line;\r\n        while ((line = reader.readLine()) != null) {\r\n            jsonData.append(line);\r\n        }\r\n\r\n        JSONObject jsonObject = new JSONObject(jsonData.toString());\r\n        JSONArray list1Json = jsonObject.getJSONArray(\"list1\");\r\n        JSONArray list2Json = jsonObject.getJSONArray(\"list2\");\r\n\r\n        Map<String, Object> l1 = null;\r\n        for (int i = list1Json.length() - 1; i >= 0; i--) {\r\n            Map<String, Object> node = new HashMap<>();\r\n            node.put(\"val\", list1Json.getInt(i));\r\n            node.put(\"next\", l1);\r\n            l1 = node;\r\n        }\r\n\r\n        Map<String, Object> l2 = null;\r\n        for (int i = list2Json.length() - 1; i >= 0; i--) {\r\n            Map<String, Object> node = new HashMap<>();\r\n            node.put(\"val\", list2Json.getInt(i));\r\n            node.put(\"next\", l2);\r\n            l2 = node;\r\n        }\r\n\r\n        Map<String, Object> mergedList = mergeTwoLists(l1, l2);\r\n\r\n        Map<String, Object> current = mergedList;\r\n        while (current != null) {\r\n            System.out.print(current.get(\"val\") + \" \");\r\n            current = (Map<String, Object>) current.get(\"next\");\r\n        }\r\n        System.out.println();\r\n    }\r\n}\r\n'),
(45, 9, 'JavaScript', 'const { execSync } = require(\'child_process\');\r\n\r\nfunction mergeTwoLists(l1, l2) {\r\n    // your code here :\r\n}\r\n\r\nfunction main() {\r\n    const jsonData = execSync(\'python3 MergeTwoSortedListsGen.py gen\', { encoding: \'utf-8\' });\r\n    const { list1, list2 } = JSON.parse(jsonData.trim());\r\n\r\n    let l1 = null;\r\n    list1.reverse().forEach(val => {\r\n        const node = { val, next: l1 };\r\n        l1 = node;\r\n    });\r\n\r\n    let l2 = null;\r\n    list2.reverse().forEach(val => {\r\n        const node = { val, next: l2 };\r\n        l2 = node;\r\n    });\r\n\r\n    const mergedList = mergeTwoLists(l1, l2);\r\n\r\n    let current = mergedList;\r\n    while (current) {\r\n        process.stdout.write(`${current.val} `);\r\n        current = current.next;\r\n    }\r\n    console.log();\r\n}\r\n\r\nmain();\r\n'),
(46, 10, 'C', '#include <stdio.h>\r\n#include <stdlib.h>\r\n#include <string.h>\r\n#include <json-c/json.h>\r\n\r\nchar* longestCommonPrefix(char** strs, int strsSize) {\r\n    // code here :\r\n}\r\n\r\nint main() {\r\n    char buffer[4096];\r\n    FILE *fp = popen(\"python3 LongestCommonPrefixGen.py gen\", \"r\");\r\n    fread(buffer, sizeof(char), sizeof(buffer), fp);\r\n    pclose(fp);\r\n\r\n    struct json_object *parsed_json;\r\n    struct json_object *strs_json;\r\n\r\n    parsed_json = json_tokener_parse(buffer);\r\n    strs_json = json_object_object_get(parsed_json, \"strs\");\r\n\r\n    int strsSize = json_object_array_length(strs_json);\r\n    char* strs[strsSize];\r\n    for (int i = 0; i < strsSize; ++i) {\r\n        strs[i] = strdup(json_object_get_string(json_object_array_get_idx(strs_json, i)));\r\n    }\r\n\r\n    char* prefix = longestCommonPrefix(strs, strsSize);\r\n    printf(\"%s\\n\", prefix);\r\n\r\n    // Free the allocated memory\r\n    for (int i = 0; i < strsSize; ++i) {\r\n        free(strs[i]);\r\n    }\r\n    free(prefix);\r\n\r\n    return 0;\r\n}\r\n'),
(47, 10, 'PHP', '<?php\r\nfunction longestCommonPrefix($strs) {\r\n   // your code here :\r\n}\r\n\r\n$jsonData = exec(\'python3 LongestCommonPrefixGen.py gen\');\r\n$data = json_decode($jsonData, true);\r\n$strs = $data[\'strs\'];\r\n\r\n$prefix = longestCommonPrefix($strs);\r\necho $prefix . \"\\n\";\r\n?>\r\n'),
(48, 10, 'Python', 'import sys\r\nimport json\r\nimport subprocess\r\n\r\ndef longest_common_prefix(strs):\r\n   # your code here :\r\n\r\ndef main():\r\n    json_data = subprocess.check_output([\'python3\', \'LongestCommonPrefixGen.py\', \'gen\']).decode(\'utf-8\').strip()\r\n    data = json.loads(json_data)\r\n    strs = data[\'strs\']\r\n    prefix = longest_common_prefix(strs)\r\n    print(prefix)\r\n\r\nif __name__ == \"__main__\":\r\n    main()\r\n'),
(49, 10, 'Java', 'import org.json.JSONArray;\r\nimport org.json.JSONObject;\r\nimport java.io.IOException;\r\nimport java.nio.file.Files;\r\nimport java.nio.file.Paths;\r\nimport java.util.ArrayList;\r\nimport java.util.List;\r\n\r\npublic class LongestCommonPrefix {\r\n    public static String longestCommonPrefix(String[] strs) {\r\n   //your code here :\r\n    }\r\n\r\n    public static void main(String[] args) {\r\n        try {\r\n            Process process = Runtime.getRuntime().exec(\"python3 LongestCommonPrefixGen.py gen\");\r\n            String jsonData = new String(process.getInputStream().readAllBytes()).trim();\r\n            JSONObject jsonObject = new JSONObject(jsonData);\r\n            JSONArray jsonArray = jsonObject.getJSONArray(\"strs\");\r\n            List<String> strsList = new ArrayList<>();\r\n            for (int i = 0; i < jsonArray.length(); i++) {\r\n                strsList.add(jsonArray.getString(i));\r\n            }\r\n            String[] strs = strsList.toArray(new String[0]);\r\n            String prefix = longestCommonPrefix(strs);\r\n            System.out.println(prefix);\r\n        } catch (IOException e) {\r\n            e.printStackTrace();\r\n        }\r\n    }\r\n}\r\n'),
(50, 10, 'JavaScript', 'const { execSync } = require(\'child_process\');\r\n\r\nfunction longestCommonPrefix(strs) {\r\n    // your code here :\r\n}\r\n\r\nfunction main() {\r\n    const jsonData = execSync(\'python3 LongestCommonPrefixGen.py gen\', { encoding: \'utf-8\' });\r\n    const { strs } = JSON.parse(jsonData.trim());\r\n    const prefix = longestCommonPrefix(strs);\r\n    console.log(prefix);\r\n}\r\n\r\nmain();\r\n'),
(51, 11, 'C', '#include <stdio.h>\r\n#include <stdlib.h>\r\n#include <stdbool.h>\r\n#include <json-c/json.h>\r\n\r\nbool isValidSudoku(char** board, int boardSize) {\r\n    // your code here :\r\n}\r\n\r\nint main() {\r\n    char buffer[4096];\r\n    FILE *fp = popen(\"python3 ValidSudokuGen.py gen\", \"r\");\r\n    fread(buffer, sizeof(char), sizeof(buffer), fp);\r\n    pclose(fp);\r\n\r\n    struct json_object *parsed_json;\r\n    struct json_object *board_json;\r\n\r\n    parsed_json = json_tokener_parse(buffer);\r\n    board_json = json_object_object_get(parsed_json, \"board\");\r\n\r\n    int boardSize = 9;\r\n    char* board[boardSize];\r\n    for (int i = 0; i < boardSize; ++i) {\r\n        board[i] = json_object_get_string(json_object_array_get_idx(board_json, i));\r\n    }\r\n\r\n    bool isValid = isValidSudoku(board, boardSize);\r\n    printf(\"%s\\n\", isValid ? \"True\" : \"False\");\r\n\r\n    return 0;\r\n}\r\n'),
(52, 11, 'PHP', '<?php\r\nfunction isValidSudoku($board) {\r\n    // your code here :\r\n}\r\n\r\n$jsonData = exec(\'python3 ValidSudokuGen.py gen\');\r\n$data = json_decode($jsonData, true);\r\n$board = $data[\'board\'];\r\n\r\n$isValid = isValidSudoku($board);\r\necho $isValid ? \"True\\n\" : \"False\\n\";\r\n?>\r\n'),
(53, 11, 'Python', 'import sys\r\nimport json\r\nimport subprocess\r\n\r\ndef isValidSudoku(board):\r\n    # your code here :\r\n\r\ndef main():\r\n    json_data = subprocess.check_output([\'python3\', \'ValidSudokuGen.py\', \'gen\']).decode(\'utf-8\').strip()\r\n    data = json.loads(json_data)\r\n    board = data[\'board\']\r\n    isValid = isValidSudoku(board)\r\n    print(\"True\" if isValid else \"False\")\r\n\r\nif __name__ == \"__main__\":\r\n    main()\r\n'),
(54, 11, 'Java', 'import org.json.JSONArray;\r\nimport org.json.JSONObject;\r\nimport java.io.IOException;\r\nimport java.nio.file.Files;\r\nimport java.nio.file.Paths;\r\nimport java.util.Arrays;\r\n\r\npublic class ValidSudoku {\r\n    public static boolean isValidSudoku(char[][] board) {\r\n     //your code here :\r\n    }\r\n\r\n    public static void main(String[] args) {\r\n        try {\r\n            Process process = Runtime.getRuntime().exec(\"python3 ValidSudokuGen.py gen\");\r\n            String jsonData = new String(process.getInputStream().readAllBytes()).trim();\r\n            JSONObject jsonObject = new JSONObject(jsonData);\r\n            JSONArray jsonArray = jsonObject.getJSONArray(\"board\");\r\n            char[][] board = new char[9][9];\r\n            for (int i = 0; i < 9; i++) {\r\n                String[] row = jsonArray.getString(i).split(\"\");\r\n                for (int j = 0; j < 9; j++) {\r\n                    board[i][j] = row[j].charAt(0);\r\n                }\r\n            }\r\n            boolean isValid = isValidSudoku(board);\r\n            System.out.println(isValid ? \"True\" : \"False\");\r\n        } catch (IOException e) {\r\n            e.printStackTrace();\r\n        }\r\n    }\r\n}\r\n'),
(55, 11, 'JavaScript', 'const { execSync } = require(\'child_process\');\r\n\r\nconst isValidSudoku = (board) => {\r\n    const isValidUnit = (unit) => {\r\n    //your code here :\r\n};\r\n\r\nconst jsonData = execSync(\'python3 ValidSudokuGen.py gen\', { encoding: \'utf-8\' });\r\nconst { board } = JSON.parse(jsonData.trim());\r\n\r\nconst result = isValidSudoku(board);\r\nconsole.log(result ? \"True\" : \"False\");\r\n');


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
