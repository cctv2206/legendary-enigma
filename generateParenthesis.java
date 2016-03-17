/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }
        helper(result, "", n, n);
        return result;
    }
    
    public void helper(List<String> result, String cur, int left, int right) {
        if (right == 0) {
            result.add(cur);
        }
        if (left > 0) {
            helper(result, cur + "(", left - 1, right);
        }
        if (right > left) {
            helper(result, cur + ")", left, right - 1);
        }
    }
}
