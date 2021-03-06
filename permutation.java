/**
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

// generate permutations by growing
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> element = new ArrayList<Integer>();
        permuteHelper(result, element, nums, 0);
        return result;
    }
    // grow the permutation
    public void permuteHelper(List<List<Integer>> result, List<Integer> element, int[] nums, int n) {
        if (n == nums.length) {
            result.add(element);
            return;
        }

        int size = element.size();
        for (int i = 0; i <= size; i++) {
            List<Integer> temp = new ArrayList<Integer>(element);
            temp.add(i, nums[n]);
            permuteHelper(result, temp, nums, n + 1);
        }
    }
}

// using swap array to generate permutations
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permuteHelper(result, nums, 0);
        return result;
    }

    public void permuteHelper(List<List<Integer>> result, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> oneSolution = new ArrayList<Integer>();
            for (int num : nums) {
                oneSolution.add(num);
            }
            result.add(oneSolution);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(index, i, nums);
            permuteHelper(result, nums, index + 1);
            swap(index, i, nums);
        }
    }

    public void swap(int n, int m, int[] nums) {
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }
}

// same as the first solution
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        
        helper(res, solution, nums, 0);
        
        return res;
        
    }
    
    private void helper(List<List<Integer>> res, List<Integer> solution, int[] nums, int i) {
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


public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        helper(res, nums, 0);
        
        return res;
        
    }
    
    private void helper(List<List<Integer>> res, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> solution = new ArrayList<Integer>();
            for (int num : nums) {
                solution.add(num);
            }
            res.add(solution);
            return;
        }
        
        helper(res, nums, start + 1);
        
        for (int i = start + 1; i < nums.length; i++) {
            swap(nums, start, i);
            helper(res, nums, start + 1);
            swap(nums, start, i);
        }
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
