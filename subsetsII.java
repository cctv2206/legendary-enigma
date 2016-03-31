/**

Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        Arrays.sort(nums);
        subsetsHelper(result, solution, nums, 0);
        return result;
    }
    
    public void subsetsHelper(List<List<Integer>> result, List<Integer> solution, int[] nums, int index) {
        if (index <= nums.length) {
            result.add(new ArrayList<Integer>(solution));
        }
        
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            solution.add(nums[i]);
            subsetsHelper(result, solution, nums, i + 1);
            solution.remove(solution.size() - 1);
            
        }
        
    }
}
