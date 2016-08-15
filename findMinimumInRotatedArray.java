/**
One of the Array problems? Divide and conquer solution. Log(n). Similar to Binary Search.

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        
        int start = 0;
        int end = length - 1;
        
        if (nums[start] <= nums[end]) { // not rotated
            return nums[start];
        }
        
        // binary search
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= nums[start]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return Math.min(nums[start], nums[end]);
    }
}

public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[start]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}

public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}
