/**

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 

*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSum2Helper(result, solution, candidates, target, 0);
        return result;
    }
    
    public void combinationSum2Helper(List<List<Integer>> result, List<Integer> solution, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(solution));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) { // rule out duplicates
                continue;
            }
            if (target - candidates[i] < 0) {
                return;
            }
            solution.add(candidates[i]);
            // go to deeper level with next index
            combinationSum2Helper(result, solution, candidates, target - candidates[i], i + 1);
            solution.remove(solution.size() - 1);
        }
    }
}
