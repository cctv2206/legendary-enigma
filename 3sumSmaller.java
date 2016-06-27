/**

Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
Follow up:
Could you solve it in O(n2) runtime?

*/

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int i = 0;
        while (i < nums.length - 2) {
            
            int j = i + 1;
            
            while (j < nums.length - 1) {
                
                int k = j + 1;
                
                while (k < nums.length) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum >= target) break;
                    ans++;
                    k++;
                } // end while k
                j++;
            } // end while j
            i++;
            
        } // end while i
        return ans;
    }
}
