/**

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. 
You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

*/

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                } else { // sum > target
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            } // end while
        } // end for
        
        return best;
    }
}
