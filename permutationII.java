/**

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].

Using HashSet so far

*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permuteUniqueHelper(result, nums, 0);
        return result;
    }
    
    public void permuteUniqueHelper(List<List<Integer>> result, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> oneSolution = new ArrayList<Integer>();
            for (int num : nums) {
                oneSolution.add(num);
            }
            result.add(oneSolution);
            return;
        }
        
        Set<Integer> appeared = new HashSet<Integer>();
        for (int i = index; i < nums.length; i++) {
            if (appeared.add(nums[i])) {
                swap(index, i, nums);
                permuteUniqueHelper(result, nums, index + 1);
                swap(index, i, nums);
            }
        }
    }
    
    public void swap(int n, int m, int[] nums) {
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }
}

// using HashSet, super slow
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        
        helper(res, solution, nums, 0);
        
        return new ArrayList<List<Integer>>(res);
    }
    
    private void helper(Set<List<Integer>> res, List<Integer> solution, int[] nums, int i) {
        if (i == nums.length) {
            res.add(solution);
            return;
        }
        
        for (int j = 0; j <= solution.size(); j++) {
            List<Integer> temp = new ArrayList<Integer>(solution);
            temp.add(j, nums[i]);
            helper(res, temp, nums, i + 1);
        }
    }
}
