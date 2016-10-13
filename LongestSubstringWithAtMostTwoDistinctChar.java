/**
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.
*/

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char c1 = 0;
        char c2 = 0;
        int i1 = 0;
        int i2 = 0;
        int res = 0;
        
        for (int right = 0, left = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (c == c1 || c1 == 0) {
                i1 = right;
                c1 = c;
            } else if (c == c2 || c2 == 0) {
                i2 = right;
                c2 = c;
            } else if (i1 < i2) {
                left = i1 + 1;
                c1 = c;
                i1 = right;
            } else { // i1 > i2
                left = i2 + 1;
                c2 = c;
                i2 = right;
            }
        
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
