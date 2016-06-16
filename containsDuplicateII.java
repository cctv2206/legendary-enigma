/**

Given an array of integers and an integer k, 
find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
and the difference between i and j is at most k.

*/

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numToIndex = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(nums[i]) && (i - numToIndex.get(nums[i])) <= k) {
                return true;
            }
            numToIndex.put(nums[i], i);
        }
        
        return false;
    }
}


public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Set<Integer> numSet = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (!numSet.add(nums[i])) return true;
            if (numSet.size() > k) numSet.remove(nums[i - k]);
        }
        
        return false;
    }
}
