/**

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/

public class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        // corner case
        if (length <= 1) {
            return;
        }
        
        // find peak
        int index = length - 1;
        while (index - 1 >= 0) {
            if (nums[index - 1] < nums[index]) { // the peak
                // find the insertion place
                int small = index;
                while (small < length && nums[small] > nums[index - 1]) {
                    small++;
                }
                small--;
                swap(small, index - 1, nums);
                break;
            }
            index--;
        }
        
        // reverse from start to end
        int start = index;
        int end = length - 1;
        while (start < end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }
    
    public void swap(int n, int m, int[] nums) {
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }
}
