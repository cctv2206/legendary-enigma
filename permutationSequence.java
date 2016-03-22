/**
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
*/

public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<Integer>();
        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            factorials[i] = factorial;
            nums.add(i);
        }
        
        k--;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= n; i++) {
            int index = k / factorials[n - i];
            sb.append(nums.get(index));
            nums.remove(index);
            k -= index * factorials[n - i];
        }
        
        return String.valueOf(sb);
    }
}
