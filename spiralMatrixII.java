/**

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:

[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

*/

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n <= 0) {
            return result;
        }
        matrixHelper(result, 0, 0, n, 1, 3);
        return result;
    }
    
    public void matrixHelper(int[][] result, int i, int j, int n, int num, int direction) {
        result[i][j] = num;
        
        if (num == n * n) { // over
            return;
        }
        
        switch (direction) {
            case 1: // left
                if (j - 1 >= 0 && result[i][j - 1] == 0) {
                    matrixHelper(result, i, j - 1, n, num + 1, 1);
                } else if (i - 1 >= 0 && result[i - 1][j] == 0) {
                    matrixHelper(result, i - 1, j, n, num + 1, 2);
                }
                return;
            case 2: // up
                if (i - 1 >= 0 && result[i - 1][j] == 0) {
                    matrixHelper(result, i - 1, j, n, num + 1, 2);
                } else if (j + 1 < n && result[i][j + 1] == 0) {
                    matrixHelper(result, i, j + 1, n, num + 1, 3);
                }
                return;
            case 3: // right
                if (j + 1 < n && result[i][j + 1] == 0) {
                    matrixHelper(result, i, j + 1, n, num + 1, 3);
                } else if (i + 1 < n && result[i + 1][j] == 0) {
                    matrixHelper(result, i + 1, j, n, num + 1, 4);
                }
                return;
            case 4: // down
                if (i + 1 < n && result[i + 1][j] == 0) {
                    matrixHelper(result, i + 1, j, n, num + 1, 4);
                } else if (j - 1 >= 0 && result[i][j - 1] == 0) {
                    matrixHelper(result, i, j - 1, n, num + 1, 1);
                }
                return;
        }
        
    }
}


public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int start = 0;
        int end = n - 1;
        int num = 1;
        while (start <= end) {
            for (int i = start; i <= end; i++) result[start][i] = num++;
            for (int i = start + 1; i <= end; i++) result[i][end] = num++;
            for (int i = end - 1; i >= start; i--) result[end][i] = num++;
            for (int i = end - 1; i >= start + 1; i--) result[i][start] = num++;
            start++;
            end--;
        }
        return result;
    }
}
