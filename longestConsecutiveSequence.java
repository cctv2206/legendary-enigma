/**

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

*/

public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        
        int res = 0;
        
        for (int num : nums) {
            if (!count.containsKey(num)) {
                
                int len = 1;
                int left = num;
                int right = num;
                
                if (count.containsKey(num - 1)) {
                    len += count.get(num - 1);
                    left -= count.get(num - 1);
                }
                if (count.containsKey(num + 1)) {
                    len += count.get(num + 1);
                    right += count.get(num + 1);
                }
                
                count.put(num, len);
                count.put(left, len);
                count.put(right, len);
                
                res = Math.max(res, len);
            }
        }
        
        return res;
    }
}
