
## Solution
The solution uses a **Dynamic Programming (DP)** approach:
- **Time Complexity**: O(n * k * k), where `n` is the number of houses and `k` is the number of colors.
- **Space Complexity**: O(n * k) for the DP table.

### Approach
1. Use a DP table `dp[i][j]` to store the minimum cost to paint houses 0 to `i`, with house `i` painted color `j`.
2. Initialize `dp[0][j] = costs[0][j]` for the first house.
3. For each house `i` (1 to n-1) and color `j`:
   - Compute `dp[i][j] = costs[i][j] + min(dp[i-1][prevColor])` for all `prevColor != j`.
4. Return the minimum value in `dp[n-1][j]` across all colors `j`.

### Key Insight
To ensure no adjacent houses have the same color, we select the minimum cost from the previous house's colors, excluding the current color.

## Code
The solution is implemented in Java. The main file is `RubySecondHouse.java`.
