/**

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.

*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        
        Set<Integer> numsSet = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            numsSet.add(nums1[i]);
        }
        
        int[] res = new int[nums2.length];
        
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (numsSet.contains(nums2[i])) {
                res[index] = nums2[i];
                numsSet.remove(nums2[i]);
                index++;
            }
        }
        
        return Arrays.copyOfRange(res, 0, index);
    }
}


public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        
        Set<Integer> numsSet = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            numsSet.add(nums1[i]);
        }
        
        // use set
        Set<Integer> res = new HashSet<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (numsSet.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        
        int[] result = new int[res.size()];
        int i = 0;
        for (Integer num : res) {
            result[i] = num;
            i++;
        }
        
        return result;
    }
}
