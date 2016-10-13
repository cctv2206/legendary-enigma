/**
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.
*/

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        int res = 0;
        for (int i = 0, left = 0; i < s.length(); i++) {
            charMap.put(s.charAt(i), i);
            if (charMap.size() > k) {
                int minIndex = s.length();
                for (int index : charMap.values()) {
                    minIndex = Math.min(minIndex, index);
                }
                left = minIndex + 1;
                charMap.remove(s.charAt(minIndex));
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
