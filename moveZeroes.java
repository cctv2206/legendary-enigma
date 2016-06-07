/**

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

*/

public class Solution {
    public void moveZeroes(int[] nums) {
        
        int zero = 0;
        
        while (zero < nums.length) {
            while (zero < nums.length && nums[zero] != 0) zero++;
            
            int nonZero = zero + 1;
            while (nonZero < nums.length && nums[nonZero] == 0) nonZero++;
            
            // swap
            if (zero < nums.length && nonZero < nums.length) {
                int temp = nums[zero];
                nums[zero] = nums[nonZero];
                nums[nonZero] = temp;
                zero++;
            } else {
                break;
            }
        }
        
    }
}

public class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int nonZero = 0;
        
        while (nonZero < nums.length) {
            
            while (nonZero < nums.length && nums[nonZero] == 0) nonZero++;
            
            if (nonZero != index && nonZero < nums.length) {
                nums[index] = nums[nonZero];
                nums[nonZero] = 0;
            }
            
            index++;
            nonZero++;
            
        }
    }
}
