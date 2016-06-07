/**

This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

*/

public class WordDistance {
    
    Map<String, List<Integer>> wordToIndeces;
    
    int length;

    public WordDistance(String[] words) {
        
        wordToIndeces = new HashMap<String, List<Integer>>();
        length = words.length;
        
        for (int i = 0; i < length; i++) {
            String w = words[i];
            
            if (wordToIndeces.containsKey(w)) {
                wordToIndeces.get(w).add(i);
            } else {
                List<Integer> indexList = new ArrayList<Integer>();
                indexList.add(i);
                wordToIndeces.put(w, indexList);
            }
        }
    }

    public int shortest(String word1, String word2) {
        
        List<Integer> list1 = wordToIndeces.get(word1);
        List<Integer> list2 = wordToIndeces.get(word2);
        
        int i1 = 0;
        int i2 = 0;
        int res = length;
        
        while (i1 < list1.size() && i2 < list2.size()) {
            
            // if (res == 1) return 1;
            
            int index1 = list1.get(i1);
            int index2 = list2.get(i2);
            
            // res = Math.min(res, Math.abs(index1 - index2));
            
            if (index1 < index2) {
                res = Math.min(res, index2 - index1);
                i1++;
            } else {
                res = Math.min(res, index1 - index2);
                i2++;
            }
        }
        
        return res;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
