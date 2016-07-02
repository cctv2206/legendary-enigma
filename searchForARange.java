/**
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        // search left
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target <= nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int left = -1;
        if (nums[start] == target) {
            left = start;
        } else if (nums[end] == target){
            left = end;
        } else {
            return new int[]{-1, -1};
        }
        
        
        // search right
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target >= nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int right = -1;
        if (nums[end] == target) {
            right = end;
        } else {
            right = start;
        }
        
        return new int[]{left, right};
        
    }
}
