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
        Map<Character, Integer> toBit = new HashMap<Character, Integer>();
        Set<Integer> seen = new HashSet<Integer>();
        Set<String> res = new HashSet<String>();
        
        toBit.put('A', 0);
        toBit.put('C', 1);
        toBit.put('G', 2);
        toBit.put('T', 3);
        
        for (int i = 0; i + 9 < s.length(); i++) {
            int bits = 0;
            for (int j = 0; j < 10; j++) {
                bits <<= 2;
                bits |= toBit.get(s.charAt(i + j));
            }
            if (!seen.add(bits)) {
                res.add(s.substring(i, i + 10));
            }
        }
        return new ArrayList<String>(res);
    }
}

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<String>();
        Set<String> subStr = new HashSet<String>();
        
        for (int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            if (!subStr.add(str)) {
                res.add(str);
            }
        }
        
        return new ArrayList<String>(res);
    }
}

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


public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<String>();
        Set<String> dnaSet = new HashSet<String>();
        
        for (int i = 0; i <= s.length() - 10; i++) {
            String subString = s.substring(i, i + 10);
            if (!dnaSet.add(subString)) {
                result.add(subString);
            }
        }
        return new ArrayList<String>(result);
    }
}
