/**

A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

*/

public class Solution {
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        
        if (length == 1) {
            return 0;
        }
        
        if (length == 2) {
            return (nums[0] > nums[1]) ? 0 : 1;
        }
        
        for (int i = 0; i < length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                return i;
            }
        }
        return length - 1;
    }
}
