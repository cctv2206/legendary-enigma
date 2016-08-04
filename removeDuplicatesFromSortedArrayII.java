/**
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        
        int pos = 1;
        int cur = 1;
        int num = nums[0];
        int count = 1;
        while (cur < nums.length) {
            if (nums[cur] == num) {
                count++;
            } else {
                num = nums[cur];
                count = 1;
            }
            
            if (count > 2) {
                while (cur < nums.length && nums[cur] == num) {
                    cur++;
                }
                continue;
            }
            
            nums[pos] = nums[cur];
            pos++;
            cur++;
        }
        return pos;
    }
}

public class Solution {
    public int removeDuplicates(int[] nums) {
        int pos = 0;
        for (int num : nums) {
            if (pos < 2 || num > nums[pos - 2]) {
                nums[pos] = num;
                pos++;
            }
        }
        return pos;
    }
}
