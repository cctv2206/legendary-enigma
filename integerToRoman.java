/**

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

*/

public class Solution {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String result = "";
        for (int i = 0; i < nums.length; i++) {
            int temp = num / nums[i];
            if (temp != 0) {
                while (temp != 0) {
                    result += roman[i];
                    temp--;
                }
            }
            num = num % nums[i];
        }
        return result;
    }
}
