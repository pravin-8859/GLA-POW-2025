package Week1.problem3;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
    
        int n = scanner.nextInt();
        int k = scanner.nextInt();
    
        int[][] costs = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                costs[i][j] = scanner.nextInt();
            }
        }

        System.out.println(minCost(costs));
        scanner.close();
    }
}