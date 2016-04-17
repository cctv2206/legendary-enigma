/**
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
The algorithm should run in linear time and in O(1) space.
*/

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList();
        }
        
        int num1 = nums[0];
        int num2 = nums[0];
        int count1 = 0;
        int count2 = 0;

        // pass 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            } else { // new num
                if (count1 == 0) {
                    num1 = nums[i];
                    count1++;
                } else if (count2 == 0) {
                    num2 = nums[i];
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            } // end if
        } // end for
        
        // pass 2
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            }
        }
        
        ArrayList result = new ArrayList();
        if (count1 > nums.length / 3) result.add(num1);
        if (count2 > nums.length / 3) result.add(num2);
        
        return result;
    }
}
