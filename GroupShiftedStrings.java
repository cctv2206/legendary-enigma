/**
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
A solution is:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
*/

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String s : strings) {
            String key = "";
            if (s.length() == 0) {
                key = "zero";
            } else if (s.length() == 1) {
                key = "one";
            } else {
                for (int i = 0; i < s.length() - 1; i++) {
                    int distance = s.charAt(i + 1) - s.charAt(i);
                    if (distance < 0) {
                        distance += 26;
                    }
                    key += "" + distance;
                }
            }
            
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> group = new ArrayList<String>();
                group.add(s);
                map.put(key, group);
            }
        }
        
        List<List<String>> res = new ArrayList<List<String>>(map.values());
        
        return res;
        
    }
}
