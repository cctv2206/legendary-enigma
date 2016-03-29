/**

According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?

*/

public class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        if (m == 0) {
            return;
        }
        
        int[][] nextState = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                gameHelper(board, nextState, i, j);
            }
        }
        
        // copy
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = nextState[i][j];
            }
        }
        
    }
    
    public void gameHelper(int[][] board, int[][] nextState, int i, int j) {
        int lives = count(board, i, j);
        if (board[i][j] == 1) {
            if (lives == 2 || lives == 3) { // 2, 3
                nextState[i][j] = 1;
            } else {
                nextState[i][j] = 0;
            }
        } else { // dead
            if (lives == 3) {
                nextState[i][j] = 1;
            } else {
                nextState[i][j] = 0;
            }
        }
    }
    
    public int count(int[][] board, int i, int j) {
        int sum = 0;
        int n = board.length;
        int m = board[0].length;
        
        // i - 1
        if (i - 1 >= 0) {
            if (j - 1 >= 0) {
                sum += board[i - 1][j - 1];
            }
            sum += board[i - 1][j];
            if (j + 1 < m) {
                sum += board[i - 1][j + 1];
            }
        }
        
        // i
        if (j - 1 >= 0) {
            sum += board[i][j - 1];
        }
        if (j + 1 < m) {
            sum += board[i][j + 1];
        }
        
        // i + 1
        if (i + 1 < n) {
            if (j - 1 >= 0) {
                sum += board[i + 1][j - 1];
            }
            sum += board[i + 1][j];
            if (j + 1 < m) {
                sum += board[i + 1][j + 1];
            }
        }
        
        return sum;
    }
}


public class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        if (m == 0) {
            return;
        }
        
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                gameHelper(board, i, j);
            }
        }
        
        // shift bit
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] >>= 1;
            }
        }
        
    }
    
    public void gameHelper(int[][] board, int i, int j) {
        int lives = count(board, i, j);
        
        if (board[i][j] == 1) { // 01
            if (lives == 2 || lives == 3) { // 2, 3
                board[i][j] = 3; // 01 -> 11
            }
        } else { // dead
            if (lives == 3) {
                board[i][j] = 2; // 00 -> 10
            }
        }
    }
    
    public int count(int[][] board, int i, int j) {
        int sum = 0;
        int n = board.length;
        int m = board[0].length;
        
        for (int x = Math.max(0, i - 1); x <= Math.min(n - 1, i + 1); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(m - 1, j + 1); y++) {
                sum += board[x][y] & 1;
            }
        }
        sum -= board[i][j] & 1;
        return sum;
    }
}
