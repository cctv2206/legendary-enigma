/**

This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

Note:
You may assume word1 and word2 are both in the list.

*/

public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int length = words.length;
        int index1 = length;
        int index2 = - length;
        int res = length;
        
        for (int i = 0; i < length; i++) {
            String w = words[i];
            
            if (w.equals(word1)) {
                
                if (word1.equals(word2)) {
                    index2 = index1;
                }
                
                index1 = i;
                res = Math.min(res, Math.abs(index1 - index2));
                
            } else if (w.equals(word2)) {
                index2 = i;
                res = Math.min(res, Math.abs(index1 - index2));
            }
            
        } // end for
        
        return res;
    }
}
