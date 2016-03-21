/**

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

This is a java solution.

*/

public class Solution {
    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }
        
        Stack<Character> parentheses = new Stack<Character>();
        
        for (int i = 0; i < length; i++) {
            char thisChar = s.charAt(i);
            
            if (parentheses.isEmpty() || parentheses.peek() == thisChar || Math.abs(parentheses.peek() - thisChar) > 2) {
                parentheses.push(thisChar);
            } else {
                parentheses.pop();
            }
        }
        return parentheses.isEmpty();
    }
}
