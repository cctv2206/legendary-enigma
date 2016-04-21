/**
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
*/

public class Solution {
    public int calculate(String s) {
        int num = 0, result = 0, sign = 1, op = 0, temp = 0;
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else { // +-*/
                if (op == 1) num = temp * num;
                if (op == -1) num = temp / num;
                op = 0;
                
                if (c == '*' || c == '/') {
                    temp = num;
                    op = c == '*' ? 1 : -1;
                } else { // +-
                    result += sign * num;
                    sign = c == '+' ? 1 : -1;
                }
                num = 0;
            }
        } // end for
        
        // num is the last num
        if (op == 1) {
            result += sign * temp * num;
        } else if (op == -1) {
            result += sign * temp / num;
        } else {
            result += sign * num;
        }
        return result;
    }
}
