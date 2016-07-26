/**
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        int length = nums.length;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < length) {
            int start = i;
            sb.append(nums[start]);
            
            while (i + 1 < length && nums[i + 1] == (nums[i] + 1)) {
                i++;
            }
            if (i != start) {
                sb.append("->");
                sb.append(nums[i]);
            }
            res.add(sb.toString());
            sb = new StringBuilder();
            i++;
        }
        return res;
    }
}


public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1) i++;
            if (start == nums[i]) {
                res.add(start + "");
            } else {
                res.add(start + "->" + nums[i]);
            }
        }
        return res;
    }
}
