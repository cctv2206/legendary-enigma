/**

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

*/

public class Solution {
    
    Map<Character, Integer> charToNum = new HashMap<Character, Integer>();
    
    public void initMap() {
        
        charToNum.put('I', 1);
        charToNum.put('V', 5);
        charToNum.put('X', 10);
        charToNum.put('L', 50);
        charToNum.put('C', 100);
        charToNum.put('D', 500);
        charToNum.put('M', 1000);
        
    }
    
    public int romanToInt(String s) {
        
        if (charToNum.size() == 0) {
            initMap();
        }
        
        int res = 0;
        int preDigit = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curDigit = charToNum.get(s.charAt(i));
            if (curDigit >= preDigit) {
                res += curDigit;
            } else {
                res -= curDigit;
            }
            preDigit = curDigit;
        }
        
        return res;
    }
}
