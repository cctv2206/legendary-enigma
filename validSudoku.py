"""
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

"""

class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        return self.checkColumn(board) and self.checkRow(board) and self.checkQuare(board)

    def checkColumn(self, board):
        for i in range(9):
            thisList = []
            for j in board:
                thisList.append(j[i])
            if not self.checkNine(thisList):
                return False
        return True

    def checkRow(self, board):
        for i in board:
            if not self.checkNine(i):
                return False
        return True

    def checkQuare(self, board):
        for i in range(3):
            for j in range(3):
                thisList = []
                for k1 in range(3):
                    for k2 in range(3):
                        thisList.append(board[i * 3 + k1][j * 3 + k2])
                if not self.checkNine(thisList):
                    return False
        return True

    def checkNine(self, list):
        s = set()
        for i in list:
            if i in s:
                return False
            if i != '.':
                s.add(i)
        return True
