/**

Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.

*/

public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        
        int len = citations.length;
        int left = 0;
        int right = len - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (citations[mid] == len - mid) {
                return citations[mid];
            }
            
            if (citations[mid] > len - mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (citations[left] >= len - left) {
            return len - left;
        }
        if (citations[right] >= len - right) {
            return len - right;
        }
        return 0;
    }
}
