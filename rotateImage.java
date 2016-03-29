/**

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

*/

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int start = 0;
        while (start < (n / 2)) {
            for (int i = 0; i < n - 2*start - 1; i++) {
                // 3 times
                swap(start, start + i, start + i, n - start - 1, matrix);
                swap(n - start - 1 - i, start, start, start + i, matrix);
                swap(n - start - 1, n - start - 1 - i, n - start - 1 - i, start, matrix);
            }
            start++;
        }
    }
    
    public void swap(int i, int j, int k, int h, int[][] matrix) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][h];
        matrix[k][h] = temp;
    }
}
