/**
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        return plusOneHelper(digits, digits.length - 1);
    }
    
    private int[] plusOneHelper(int[] digits, int pos) {
        if (pos < 0) {
            int[] result = new int[1 + digits.length];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
        
        if (digits[pos] == 9) {
            digits[pos] = 0;
            return plusOneHelper(digits, pos - 1);
        }
        
        digits[pos] += 1;
        return digits;    
    }
    
}

public class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                break;
            }
        }
        
        if (digits[0] != 0) {
            return digits;
        }
        
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
    
}
