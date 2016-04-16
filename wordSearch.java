/**

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existHelper(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean existHelper(char[][] board, String word, int charIndex, int n, int m) {
        if (charIndex == word.length()) {
            return true;
        }
        if (n < 0 || n >= board.length || m < 0 || m >= board[0].length) {
            return false;
        }
        
        if (board[n][m] != word.charAt(charIndex)) {
            return false;
        }
        
        char temp = board[n][m];
        board[n][m] = '1';
        
        boolean result = existHelper(board, word, charIndex + 1, n - 1, m) || existHelper(board, word, charIndex + 1, n, m - 1) || existHelper(board, word, charIndex + 1, n, m + 1) || existHelper(board, word, charIndex + 1, n + 1, m);
        
        board[n][m] = temp;
        
        return result;
        
    }
}
