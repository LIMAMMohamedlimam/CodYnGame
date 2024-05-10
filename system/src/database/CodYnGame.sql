
CREATE DATABASE codyngame;
USE  codyngame ;

CREATE TABLE Problem (
    id            INTEGER PRIMARY KEY AUTO_INCREMENT,
    title         TEXT NOT NULL,
    description   TEXT NOT NULL,
    solutionFile  TEXT NOT NULL
);

CREATE TABLE Datatype (
    problemId INTEGER NOT NULL,
    argNumber INTEGER NOT NULL,
    dataType  TEXT NOT NULL,
    PRIMARY KEY (problemId, argNumber),
    FOREIGN KEY (problemId) REFERENCES Problem(id)
);


INSERT INTO Problem (title , description,solutionFile) values (
	"Two Sum" ,
	"Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

	You may assume that each input would have exactly one solution, and you may not use the same element twice.

	You can return the answer in any order.

	

	Example 1:

	Input: nums = [2,7,11,15], target = 9
	Output: [0,1]
	Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
	Example 2:

	Input: nums = [3,2,4], target = 6
	Output: [1,2]
	Example 3:

	Input: nums = [3,3], target = 6
	Output: [0,1]" ,
	"/home/mohamed/Java_IHM/CodYnGame/solutionFiles/TwoSum.py" )


INSERT INTO Problem (title , description , solutionFile) values (
	"Longest Substring Without Repeating Characters",
	"Given a string s, find the length of the longest 
	substring
 without repeating characters.

 

Example 1:

Input: s = 'abcabcbb'
Output: 3
Explanation: The answer is 'abc', with the length of 3.
Example 2:

Input: s = 'bbbbb'
Output: 1
Explanation: The answer is 'b', with the length of 1.
Example 3:

Input: s = 'pwwkew'
Output: 3
Explanation: The answer is 'wke', with the length of 3.
Notice that the answer must be a substring, 'pwke' is a subsequence and not a substring.",


)