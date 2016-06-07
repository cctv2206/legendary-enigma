/**

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.

*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                return new int[] {numToIndex.get(target - nums[i]), i};
            }
            numToIndex.put(nums[i], i);
        }
        
        return null;

    }
}

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums2);
        
        int left = 0;
        int right = nums2.length - 1;
        
        while (left + 1 < right) {
            if (nums2[left] + nums2[right] == target) break;
            
            if (nums2[left] + nums2[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        
        int[] res = new int [2];
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums2[left]) {
                res[0] = i;
            }
        }
        
        if (nums2[left] != nums2[right]) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == nums2[right]) {
                    res[1] = i;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == nums2[right] && i != res[0]) {
                    res[1] = i;
                }
            }
        }
        
        return res;
    }
}
