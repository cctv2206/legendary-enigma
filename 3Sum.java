/**

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.

For example, given array S = {-1 0 1 2 -1 -4},
A solution set is:
(-1, 0, 1)
(-1, -1, 2)

*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int index = 0; index < nums.length - 2; index++) {
            if (nums[index] > 0) {
                return result;
            }
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }
            
            int sum = - nums[index];
            // two sum
            for (int i = index + 1; i < nums.length - 1; i++) {
                if (i > index + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int target = sum - nums[i];
                if (nums[i] > target) {
                    break;
                }
                // binary search
                int start = i + 1;
                int end = nums.length - 1;
                int ans = -1;
                while (start + 1 < end) {
                    int mid = start + (end - start) / 2;
                    if (nums[mid] < target) {
                        start = mid;
                    } else if (nums[mid] > target) {
                        end = mid;
                    } else { // nums[mid] == target
                        ans = mid;
                        break;
                    }
                }
                
                if (nums[start] == target) {
                    ans = start;
                } else if (nums[end] == target) {
                    ans = end;
                }
                
                if (ans != -1) { // got the answer
                    ArrayList<Integer> solution = new ArrayList<Integer>();
                    solution.add(nums[index]);
                    solution.add(nums[i]);
                    solution.add(nums[ans]);
                    result.add(solution);
                }
                
                
            } // end for
            
        } // end for
        
        return result;    
    
    }

}


public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (sum > 0) {
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else { // sum < 0
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                }
            } // end while j k
            
        } // end for i
        
        return result;    
    
    }

}


public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) break;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                }
                if (sum <= 0) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
                if (sum >= 0) {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
        
            }
            i++;
            while (i < nums.length - 2 && nums[i] == nums[i - 1]) i++;
        }
        
        return res;
    }
}
