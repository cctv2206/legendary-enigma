/**

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> com = new ArrayList<Integer>();
        combineHelper(result, com, 1, n, k);
        return result;
    }
    
    public void combineHelper(List<List<Integer>> result, List<Integer> com, int location, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(com)); // create new instance
            return;
        }
        
        for (int i = location; i <= n - k + 1; i++) {
            com.add(i);
            combineHelper(result, com, i + 1, n, k - 1);
            com.remove(com.size() - 1);
        }
    }
}
