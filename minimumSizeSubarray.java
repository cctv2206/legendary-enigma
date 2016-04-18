/**

Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            if (sum >= s) {
                while (sum - nums[start] >= s && start < end) {
                    sum -= nums[start];
                    start++;
                }
                result = Math.min(result, end - start + 1);
            }
        }
        
        return result != Integer.MAX_VALUE ? result : 0;
    }
}
