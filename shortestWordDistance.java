/**

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

Show Company Tags
Show Tags
Show Similar Problems


*/

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = words.length;
        int index2 = - words.length;
        int res = words.length;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
                res = Math.min(res, Math.abs(index1 - index2));
            } else if (words[i].equals(word2)) {
                index2 = i;
                res = Math.min(res, Math.abs(index1 - index2));
            }
        }
        
        return res;
    }
}
