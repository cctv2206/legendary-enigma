/**

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] kLargest = new int[k];
        for (int i = 0; i < k; i++) {
            kLargest[i] = Integer.MIN_VALUE;
        }
        
        for (int num : nums) {
            int i = 0;
            while (i < k && num < kLargest[i]) {
                i++;
            }
            
            if (i < k) {
                int j = k - 1;
                while (j > i) {
                    kLargest[j] = kLargest[j - 1];
                    j--;
                }
                kLargest[i] = num;
            }
        }
        
        return kLargest[k - 1];
    }
}
