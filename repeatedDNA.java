/**

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].

*/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> hashmap = new HashMap<String, Integer>();
        List<String> result = new ArrayList<String>();
        
        for (int i = 0; i <= s.length() - 10; i++) {
            String subString = s.substring(i, i + 10);
            if (hashmap.containsKey(subString) ) { // repeated
                if (hashmap.get(subString) == 1) {
                    result.add(s.substring(i, i + 10));
                    hashmap.put(subString, hashmap.get(subString) + 1);
                } else {
                    continue;
                }
                
            } else { //first time
                hashmap.put(subString, 1);
            }
        }
        return result;
    }
}
