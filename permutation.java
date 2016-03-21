/**
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/
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
