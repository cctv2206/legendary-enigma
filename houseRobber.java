/**
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        
        int[] robThis = new int[length];
        int[] noRobThis = new int[length];
        robThis[0] = nums[0];
        
        for (int i = 1; i < length; i++) {
            robThis[i] = nums[i] + noRobThis[i - 1];
            noRobThis[i] = Math.max(robThis[i - 1], noRobThis[i - 1]);
        }
        return Math.max(robThis[length - 1], noRobThis[length - 1]);
    }
}

public class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        
        int[] money = new int[length + 1];
        money[1] = nums[0];
        for (int i = 2; i < length + 1; i++) {
            money[i] = Math.max(nums[i - 1] + money[i - 2], money[i - 1]);
        }
        return money[length];
    }
}
