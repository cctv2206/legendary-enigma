/*
This is one of the Parentheses problems.

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

class Solution {
public:
    bool isValid(string s) {
        int len = s.size();
        if (len == 0) {
            return true;
        }
        if (len % 2 != 0) {
            return false;
        }
        
        vector<char> stack;
        
        for (int i = 0; i < len; i++)
        {
            if (stack.empty() || stack.back() - s[i] == 0 || abs(stack.back() - s[i]) > 2) {
                stack.push_back(s[i]);
            }else{
                stack.pop_back();
            }
        }
        return stack.empty();
    }
};
