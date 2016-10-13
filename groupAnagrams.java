/**

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.

*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<String, List<String>>();
        for (String s : strs) {
            String key = sortString(s);
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<String>());
            }
            groups.get(key).add(s);
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        for (List<String> group : groups.values()) {
            res.add(group);
        }
        return res;
    }
    
    public String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> strMap = new HashMap<String, List<String>>();
        List<List<String>> result = new ArrayList<List<String>>();
        
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String strKey = String.valueOf(charArray);
            if (strMap.containsKey(strKey)) {
                strMap.get(strKey).add(str);
            } else {
                strMap.put(strKey, new ArrayList<String>());
                strMap.get(strKey).add(str);
            }
        }
        
        for (List<String> strList : strMap.values()) {
            Collections.sort(strList);
            result.add(strList);
        }
        
        return result;
        
    }
}
