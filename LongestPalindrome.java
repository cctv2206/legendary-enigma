/**
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

public class Solution {
    public int longestPalindrome(String s) {
        Set<Character> charSet = new HashSet<Character>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!charSet.add(s.charAt(i))) {
                res += 2;
                charSet.remove(s.charAt(i));
            }
        }
        if (!charSet.isEmpty()) {
            res++;
        }
        return res;
    }
}

public class Solution {
    public int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        int[] chars = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[c]++;
        }
        
        int res = 0;
        boolean single = false;
        for (int num : chars) {
            if (num % 2 == 1) {
                single = true;
                res += num - 1;
            } else {
                res += num;
            }
        }
        
        if (single) {
            res++;
        }
        
        return res;
    }
}
