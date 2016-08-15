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

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = nums.length + 1;
        int left = 0;
        int right = 0;
        int sum = 0;
        
        while (right < nums.length) {
            sum += nums[right];
            right++;
            
            while (sum >= s) {
                res = Math.min(res, right - left);
                
                sum -= nums[left];
                left++;
            }
        }
        
        
        if (res > nums.length) {
            return 0;
        }
        return res;
    }
}
