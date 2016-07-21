/**
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < cols; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        
        return grid[rows - 1][cols - 1];
    }
}


public class Solution {
    public int minPathSum(int[][] grid) {
        
        if (grid.length == 0 || grid[0].length == 0) return 0;
        
        int cols = grid[0].length;
        
        int[] dp = grid[0];
        for (int i = 1; i < cols; i++) {
            dp[i] += dp[i - 1];
        }
        
        for (int row = 1; row < grid.length; row++) {
            dp[0] += grid[row][0];
            for (int i = 1; i < cols; i++) {
                dp[i] = grid[row][i] + Math.min(dp[i - 1], dp[i]);
            }
        }
        
        return dp[cols - 1];
    }
}
