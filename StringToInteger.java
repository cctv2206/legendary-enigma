/**
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
*/

public class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        
        if (i == str.length()) {
            return 0;
        }
        
        int sign = 1;
        long res = 0;
        
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            res = res * 10 + sign * (str.charAt(i) - '0');
            i++;
            if (sign < 0 && res < (long) Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (res > (long) Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        
        return (int) res;
    }
}
