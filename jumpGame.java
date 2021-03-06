/**

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

*/

public class Solution {
    public boolean canJump(int[] nums) {
        
        int reach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) {
                return false;
            }
            
            if (nums[i] + i > reach) {
                reach = nums[i] + i;
            }
        }
        
        return true;
    }
}

public class Solution {
    public boolean canJump(int[] nums) {
        
        int last = nums.length - 1;
        
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= last) {
                last = i;
            }
        }
        
        return last <= 0;
    }
}
