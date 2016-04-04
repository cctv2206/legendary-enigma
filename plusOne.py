"""
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
"""

class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        if not digits:
            return None
        
        index = len(digits) - 1
        while digits[index] == 9:
            digits[index] = 0
            index -= 1
            if index < 0:
                digits.insert(0, 1)
                return digits
        digits[index] += 1 
        return digits
