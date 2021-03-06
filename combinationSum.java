/** 

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        Arrays.sort(candidates); // sort first!
        combinationSumHelper(result, solution, candidates, target, 0);
        return result;
    }
    
    public void combinationSumHelper(List<List<Integer>> result, List<Integer> solution, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(solution);
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            List<Integer> temp = new ArrayList<Integer>(solution);
            if (target - candidates[i] < 0) {
                return;
            }
            temp.add(candidates[i]);
            combinationSumHelper(result, temp, candidates, target - candidates[i], i);
        }
    }
}



public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        
        helper(candidates, target, 0, result, solution);
        
        return result;
        
    }
    
    private void helper(int[] candidates, int target, int pos, List<List<Integer>> result, List<Integer> solution) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(solution));
            return;
        } 
        
        
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            
            solution.add(candidates[i]);
            helper(candidates, target - candidates[i], i, result, solution);
            solution.remove(solution.size() - 1);
            
        }
        
    }
}
