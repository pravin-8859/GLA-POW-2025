package Week1.problem3;
public class RubySecondHouse {
    public static int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        
        int n = costs.length; 
        int k = costs[0].length;
        
      
        int[][] dp = new int[n][k];
        
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
        }
    
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int minPrev = Integer.MAX_VALUE;
                for (int prevColor = 0; prevColor < k; prevColor++) {
                    if (prevColor != j) {
                        minPrev = Math.min(minPrev, dp[i-1][prevColor]);
                    }
                }
                dp[i][j] = costs[i][j] + minPrev;
            }
        }
        
        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            minCost = Math.min(minCost, dp[n-1][j]);
        }
        
        return minCost;
    }

    public static void main(String[] args) {
        int[][] costs = {{1, 5, 3}, {2, 9, 4}};
        System.out.println("Example Output: " + minCost(costs)); 

        int[][] costs2 = {{1, 2}, {2, 1}};
        System.out.println("Test Case 1 Output: " + minCost(costs2)); 
    }
}
