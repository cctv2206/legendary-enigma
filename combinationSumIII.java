/**

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]

*/

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        combinationSum3Helper(result, solution, 1, k, n);
        return result;
    }
    
    public void combinationSum3Helper(List<List<Integer>> result, List<Integer> solution, int num, int k, int target) {
        if (k == 0 && target == 0) {
            result.add(new ArrayList<Integer>(solution));
            return;
        }
        
        for (int i = num; i < 10; i++) {
            if (target - i < 0) {
                return;
            }
            solution.add(i);
            combinationSum3Helper(result, solution, i + 1, k - 1, target - i);
            solution.remove(solution.size() - 1);
        }
    }
}
