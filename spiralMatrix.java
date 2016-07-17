/**

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5].

*/

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int start = 0;
        
        int n = matrix.length - 1;
        if (n < 0) {
            return result;
        }
        
        int m = matrix[0].length - 1;
        if (m < 0) {
            return result;
        }
        
        while (start <= n && start <= m) {
            for (int i = start; i <= m; i++) result.add(matrix[start][i]);
            if (start + 1 > n) {
                break;
            }
            for (int i = start + 1; i <= n; i++) result.add(matrix[i][m]);
            if (m - 1 < start) {
                break;
            }
            for (int i = m - 1; i >= start; i--) result.add(matrix[n][i]);
            if (n - 1 < start + 1) {
                break;
            }
            for (int i = n - 1; i >= start + 1; i--) result.add(matrix[i][start]);
            
            start++;
            n--;
            m--;
        }
        return result;
    }
}


public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // go right
            for (int i = colStart; i <= colEnd; i++) {
                res.add(matrix[rowStart][i]);
            }
            rowStart++;
            
            // go down
            for (int i = rowStart; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            // go left
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    res.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            
            // go up
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    res.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        
        return res;
    }
}
