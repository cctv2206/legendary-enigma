/**

Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

*/

public class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        if (nums[start] == target || nums[end] == target) {
            return true;
        }
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            
            if (nums[mid] > nums[start]) {
                if (nums[mid] >= target && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                } 
            } else if (nums[mid] < nums[start]){
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                } 
            } else {
                start++;
            }
        }

        if (nums[start] == target || nums[end] == target) {
            return true;
        }
        return false;
    }
}
