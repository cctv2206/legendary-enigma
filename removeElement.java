/**
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

Hint:

Try two pointers.
Did you use the property of "the order of elements can be changed"?
What happens when the elements to remove are rare?
*/

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            while (left < right && nums[left] != val) left++;
            while (left < right && nums[right] == val) right--;
            
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        
        return nums[left] == val ? left : left + 1;
    }
    
}

public class Solution {
    public int removeElement(int[] nums, int val) {
        int pos = 0;
        
        for (int num : nums) {
            if (num != val) {
                nums[pos] = num;
                pos++;
            }
        }
        
        return pos;
    }
}
