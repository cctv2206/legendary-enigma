/**

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

*/

public class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }
        int[][] pathSum = new int[n][m];
        
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += grid[0][i];
            pathSum[0][i] = sum;
        }
        
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += grid[i][0];
            pathSum[i][0] = sum;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                pathSum[i][j] = Math.min(pathSum[i][j - 1], pathSum[i - 1][j]) + grid[i][j];
            }
        }
        return pathSum[n - 1][m - 1];
    }
}
