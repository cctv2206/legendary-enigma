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
        
        List<Integer> intersection = new ArrayList<Integer>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                intersection.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] res = new int[intersection.size()];
        for (int k = 0; k < intersection.size(); k++) {
            res[k] = intersection.get(k);
        }
        
        return res;
    }
}

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        List<Integer> intersection = new ArrayList<Integer>();
        
        for (int num : nums1) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }
        
        for (int num : nums2) {
            if (count.containsKey(num) && count.get(num) > 0) {
                intersection.add(num);
                count.put(num, count.get(num) - 1);
            }
        }
        
        int[] res = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            res[i] = intersection.get(i);
        }
        
        return res;
    }
}

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
