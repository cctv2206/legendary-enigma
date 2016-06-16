/**
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

*/

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> numSet = new HashSet<Integer>();
        
        for (int num : nums) {
            if (!numSet.add(num)) return true;
        }
        
        return false;
    }
}

