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
