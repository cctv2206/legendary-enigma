/**

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

*/

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        
        int res = nums[0];
        int max = res;
        int min = res;
        
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            
            max = Math.max(Math.max(nums[i] * temp, nums[i] * min), nums[i]);
            min = Math.min(Math.min(nums[i] * temp, nums[i] * min), nums[i]);
            
            if (max > res) {
                res = max;
            }
        }
        
        return res;
    }
}
