/**

Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/


public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        Arrays.sort(nums);
        subsetHelper(result, set, nums, 0);
        return result;
    }
    
    public void subsetHelper(List<List<Integer>> result, List<Integer> set, int[] nums, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(set));
            return;
        }
        
        subsetHelper(result, set, nums, index + 1);
        set.add(nums[index]);
        subsetHelper(result, set, nums, index + 1);
        set.remove(set.size() - 1);
    }
}

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        helper(res, set, nums, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> set, int[] nums, int pos) {
        if (pos <= nums.length) {
            res.add(new ArrayList<Integer>(set));
        }
        
        for (int i = pos; i < nums.length; i++) {
            set.add(nums[i]);
            helper(res, set, nums, i + 1);
            set.remove(set.size() - 1);
        }
    }
}
