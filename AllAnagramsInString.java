/**

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/


public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        if (p.length() > s.length()) {
            return new ArrayList<Integer>();
        }
        
        int[] pArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;
        }
        
        int[] sArr = new int[26];
        
        List<Integer> res = new ArrayList<Integer>();
        
        for (int left = 0, right = 0; right < s.length(); left++) {
            while (right < s.length() && left + p.length() > right) {
                sArr[s.charAt(right) - 'a']++;
                right++;
            }
            if (count(sArr, pArr)) {
                res.add(left);
            }
            sArr[s.charAt(left) - 'a']--;
        }
        
        return res;
    }
    
    public boolean count(int[] s, int[] p) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] != p[i]) {
                return false;
            }
        }
        return true;
    }
}
