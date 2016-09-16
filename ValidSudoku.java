/**
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) {
            return false;
        }
        
        Set<String> numSet = new HashSet<String>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!numSet.add(c + "row" + i) || !numSet.add(c + "col" + j) || !numSet.add(c + "s" + i / 3 + j / 3)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
        
    }
}


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) {
            return false;
        }
        
        // rows
        for (char[] row : board) {
            int[] nums = new int[10];
            for (char c : row) {
                if (c != '.') {
                    int num = c - '0';
                    if (nums[num] == 1) {
                        return false;
                    }
                    nums[num] = 1;
                }
            }
        }
        
        // cols
        for (int i = 0; i < 9; i++) {
            int[] nums = new int[10];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int num = board[j][i] - '0';
                    if (nums[num] == 1) {
                        return false;
                    }
                    nums[num] = 1;
                }
            }
        }
        
        
        // squares
        int[] indexX = {0, 0, 0, 3, 3, 3, 6, 6, 6};
        int[] indexY = {0, 3, 6, 0, 3, 6, 0, 3, 6};
        
        for (int i = 0; i < 9; i++) {
            int[] nums = new int[10];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    char c = board[indexX[i] + j][indexY[i] + k];
                    if (c != '.') {
                        int num = c - '0';
                        if (nums[num] == 1) {
                            return false;
                        }
                        nums[num] = 1;
                    }
                }
            }
        }
        
        return true;
        
    }
}
