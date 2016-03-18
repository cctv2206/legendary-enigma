/**
This is one of the array problems.

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

*/

public class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] sumFromLeft = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            sumFromLeft[i] = sum;
        }
        int result = Integer.MIN_VALUE;
        int minValue = 0;
        for (int i = 0; i < length; i++) {
            if (sumFromLeft[i] - minValue > result) {
                result = sumFromLeft[i] - minValue;
            }
            if (sumFromLeft[i] < minValue) {
                minValue = sumFromLeft[i];
            }
        }
        return result;
    }
}
