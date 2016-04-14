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
