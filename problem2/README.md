# Subarray Sum Equals K

## Problem Description
This project implements a solution for the "Subarray Sum Equals K" problem, designed for a fitness app. Given an array of integers `nums` representing calories burned each day and a target calorie goal `k`, the task is to find the number of continuous subarrays (streaks of days) where the total calories burned exactly equal `k`. This helps the app identify goal-based calorie-burning streaks to enhance user engagement.

### Input
- `n`: Number of days (length of `nums`).
- `nums`: Array of integers representing calories burned each day.
- `k`: Target calorie goal (integer).

### Output
- A single integer representing the total number of continuous subarrays with a sum equal to `k`.

### Constraints
- `1 <= nums.length <= 2 * 10^4`
- `-1000 <= nums[i] <= 1000`
- `-10^7 <= k <= 10^7`

### Examples
1. **Example 1**:
   - Input: `nums = [1, 2, 3], k = 3`
   - Output: `2`
   - Explanation: Subarrays `[1, 2]` and `[3]` sum to `3`.

2. **Example 2**:
   - Input: `nums = [1, 1, 1], k = 2`
   - Output: `2`
   - Explanation: Subarrays `[1, 1]` at indices (0,1) and (1,2) sum to `2`.

## Solution
The solution uses a **Prefix Sum + HashMap** approach for efficiency:
- **Time Complexity**: O(n), where `n` is the length of `nums`.
- **Space Complexity**: O(n) for the HashMap storing prefix sums.

### Approach
1. Use a `HashMap` to store the frequency of prefix sums (cumulative calories burned).
2. Initialize `sumMap` with `{0: 1}` to handle subarrays starting from index 0.
3. For each day’s calories (`num`):
   - Update the running `prefixSum` by adding `num`.
   - Check if `prefixSum - k` exists in `sumMap`. If it does, add its frequency to the count (each represents a valid subarray).
   - Update the frequency of the current `prefixSum` in `sumMap`.
4. Return the total count of valid subarrays.

### Key Insight
A subarray from index `i` to `j` sums to `k` if:  
`sum(j) - sum(i-1) = k`  
Thus, we check for `sum(j) - k` in the `HashMap` to find valid subarrays ending at `j`.

## Code
The solution is implemented in Java. The main file is `SubarraySumEqualsK.java`.
