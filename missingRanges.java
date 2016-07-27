/**
Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
*/

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > lower) {
                if (nums[i] - 1 > lower) {
                    res.add(lower + "->" + (nums[i] - 1));
                } else {
                    res.add(lower + "");
                }
            }
            
            while (i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1) i++;
            
            lower = nums[i] + 1;
        }
        if (lower < upper) {
            res.add(lower + "->" + upper);
        } else if (lower == upper) {
            res.add(lower + "");
        }
        return res;
    }
}
