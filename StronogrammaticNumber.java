/**
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
*/

public class Solution {
    public boolean isStrobogrammatic(String num) {
        
        int left = 0;
        int right = num.length() - 1;
        
        while (left <= right) {
            char c = num.charAt(left);
            if (c == '1' || c == '8' || c == '0') {
                if (num.charAt(right) != c) {
                    return false;
                }
            } else if (c == '6') {
                if (num.charAt(right) != '9') {
                    return false;
                }
                
            } else if (c == '9') {
                if (num.charAt(right) != '6') {
                    return false;
                }
            } else {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
