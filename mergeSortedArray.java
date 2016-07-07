/**
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int num : nums2) {
            nums1[m] = num;
            m++;
        }
        Arrays.sort(nums1);
    }
}

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        for (int i = 0; i < m; i++) {
            nums3[i] = nums1[i];
        }
        
        int p2 = 0;
        int p3 = 0;
        int i = 0;
        while (p2 < n && p3 < m) {
            if (nums2[p2] < nums3[p3]) {
                nums1[i] = nums2[p2];
                p2++;
            } else {
                nums1[i] = nums3[p3];
                p3++;
            }
            i++;
        }
        
        while (p2 < n) {
            nums1[i] = nums2[p2];
            i++;
            p2++;
        }
        while (p3 < m) {
            nums1[i] = nums3[p3];
            i++;
            p3++;
        }
    }
}

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }
        
        int i = 0;
        int p1 = n;
        int p2 = 0;
        
        while (p1 < nums1.length && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                nums1[i] = nums1[p1];
                p1++;
            } else {
                nums1[i] = nums2[p2];
                p2++;
            }
            i++;
        }
        
        while (p2 < n) {
            nums1[i] = nums2[p2];
            i++;
            p2++;
        }
    }
}
