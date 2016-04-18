/**
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

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
