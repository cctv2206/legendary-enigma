/**
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/


public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int[] dp = new int [nums.length];
        int len = 0;
        dp[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int pos = binarySearch(dp, len, nums[i]);
            if (dp[pos] > nums[i]) dp[pos] = nums[i];
            if (pos > len) {
                len = pos;
                dp[pos] = nums[i];
            }
        }
        return len + 1;
    }
    
    private int binarySearch(int[] dp, int len, int target) {
        int left = 0;
        int right = len;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (dp[mid] == target) {
                return mid;
            } else {
                if (dp[mid] > target) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        
        if (target > dp[right]) {
            return len + 1;
        }
        if (target <= dp[left]) {
            return left;
        }
        return right;
    }
}
