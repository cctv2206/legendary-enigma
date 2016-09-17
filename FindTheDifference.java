/**
Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:

Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.

*/

public class Solution {
    public char findTheDifference(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i) - 'a';
        }
        for (int i = 0; i < t.length(); i++) {
            res ^= t.charAt(i) - 'a';
        }
        return (char) (res + (int) 'a');
    }
}
