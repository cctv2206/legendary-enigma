/**

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

*/

public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null && matrix[0].length == 0) {
            return;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        
        int row = 1;
        int col = 1;
        
        // check first row
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                row = 0;
                break;
            }
        }
        
        // check first col
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                col = 0;
                break;
            }
        }
        
        // check the grid, starting from (1, 1)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        // change the rows
        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // change the cols
        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // first row
        if (row == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        // first col
        if (col == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    
    }
}

public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int firstCol = 1;
        
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstCol = 0;
            }
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j > 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (firstCol == 0) {
                matrix[i][0] = 0;
            }
        }
    }
}
