/**

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

*/

public class Solution {
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == result) {
                count++;
            } else { // nums[i] != result
                if (count == 0) {
                    result = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            } // end if
            if (count > nums.length / 2) break;
        } // end for
        return result;
    }
}

