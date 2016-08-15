/**

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.

For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

A solution set is:
(-1,  0, 0, 1)
(-2, -1, 1, 2)
(-2,  0, 0, 2)

*/

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (nums[i] << 2 > target) {
                break;
            }
            int threeSum = target - nums[i];
            
            // three sum
            for (int j = i + 1; j < length - 2; j++) {
                int k = j + 1;
                int l = length - 1;
                while (k < l) {
                    int sum = nums[j] + nums[k] + nums[l];
                    if (sum == threeSum) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < threeSum) {
                        k++;
                        // while (k < l && nums[k] == nums[k - 1]) k++;
                    } else { // sum > threeSum
                        l--;
                        // while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                } // end while k < l
                while (j < length - 2 && nums[j] == nums[j + 1]) j++; // avoid duplicates
            } // end for j
            while (i < length - 3 && nums[i] == nums[i + 1]) i++; // avoid duplicates
        } // end for i

        return result;
    }
}


public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        int i = 0;
        while (i < nums.length - 3) {
            
            if (nums[i] << 2 > target) { // nums[i] * 4
                break;
            }
            
            int j = i + 1;
            while (j < nums.length - 2) {
                
                int k = j + 1;
                int l = nums.length - 1;
                
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    
                    if (sum > target) {
                        l--;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        l--;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                    
                }
                
                j++;
                while (j < nums.length - 2 && nums[j] == nums[j - 1]) j++;
            }
            
            i++;
            while (i < nums.length - 3 && nums[i] == nums[i - 1]) i++;
        }
        
        return res;
        
    }
}
