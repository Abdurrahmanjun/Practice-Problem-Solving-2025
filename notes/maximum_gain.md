# Maximum Gain

## Problem
You are given a string s and two integers x and y. You can perform two types of operations any number of times.

- Remove substring "ab" and gain x points.
  - For example, when removing "ab" from "cabxbae" it becomes "cxbae".
- Remove substring "ba" and gain y points.
  - For example, when removing "ba" from "cabxbae" it becomes "cabxe".

Return the maximum points you can gain after applying the above operations on s.

## Solution
Use a Stacks to check linear condition

- Time: O(n)
- Space: O(n)

## Code
See: `src/main/kotlin/leetcode/strings/MaximumGain.kt`
