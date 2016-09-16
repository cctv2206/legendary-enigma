/**
An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
*/

public class ValidWordAbbr {
    
    private Map<String, String> abbreviationMap;
    

    public ValidWordAbbr(String[] dictionary) {
        
        abbreviationMap = new HashMap<String, String>();
        
        for (String word : dictionary) {
            
            String abbr = toAbbr(word);
            if (abbreviationMap.containsKey(abbr) && !abbreviationMap.get(abbr).equals(word)) {
                abbreviationMap.put(abbr, "");
            } else {
                abbreviationMap.put(abbr, word);
            }
        }

    }

    public boolean isUnique(String word) {
        String abbr = toAbbr(word);
        
        return !abbreviationMap.containsKey(abbr) || abbreviationMap.get(abbr).equals(word);
    }

    private String toAbbr(String word) {
        int len = word.length();
        if (len < 3) {
            return word;
        }
        int gap = len - 2;
        return word.charAt(0) + "" + gap + word.charAt(len - 1);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
