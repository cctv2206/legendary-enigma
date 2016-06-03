/**
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to num2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/


public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if (nums1.length == 0 || nums2.length == 0) return new int [0];
        
        Map<Integer, Integer> numToCount = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums1.length; i++) {
            if (numToCount.containsKey(nums1[i])) {
                numToCount.put(nums1[i], numToCount.get(nums1[i]) + 1);
            } else {
                numToCount.put(nums1[i], 1);
            }
        }
        
        int[] res = new int [nums2.length];
        int index = 0;
        
        for (int i = 0; i < nums2.length; i++) {
            if (numToCount.containsKey(nums2[i])) {
                res[index] = nums2[i];
                index++;
                numToCount.put(nums2[i], numToCount.get(nums2[i]) - 1);
                if (numToCount.get(nums2[i]) == 0) {
                    numToCount.remove(nums2[i]);
                }
            }
        }
        
        return Arrays.copyOfRange(res, 0, index);
    }
}
