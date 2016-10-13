/**
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charMap = new int[256];
        for (int i = 0; i < charMap.length; i++) {
            charMap[i] = -1;
        }
        int res = 0;
        for (int right = 0, left = 0; right < s.length(); right++) {
            if (charMap[s.charAt(right)] != -1) {
                left = Math.max(left, charMap[s.charAt(right)] + 1);
            }
            
            res = Math.max(res, right - left + 1);
            charMap[s.charAt(right)] = right;
        }
        return res;
    }
}

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Set<Character> charSet = new HashSet<Character>();
        int res = 0;
        
        while (right < s.length()) {
            while (right < s.length() && charSet.add(s.charAt(right))) {
                right++;
            }
            res = Math.max(res, right - left);
            
            if (right < s.length()) {
                while (s.charAt(left) != s.charAt(right)) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                left++;
                right++;
            }
        }
        
        return res;
    }
}

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> letter = new HashSet<Character>();
        char[] sArray = s.toCharArray();
        int left = 0;
        int length = 0;
        for (int right = 0; right < s.length(); right++) {
            if (letter.add(sArray[right])) {
                length = Math.max(length, right - left + 1);
            } else {
                while (sArray[left] != sArray[right]) {
                    letter.remove(sArray[left]);
                    left++;
                }
                left++;
            }
        } // end for
        
        return length;
    }
}
