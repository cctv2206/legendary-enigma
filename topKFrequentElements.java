/**

Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

*/


public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> numToCount = new HashMap<Integer, Integer>();
        
        for (int num : nums) {
            if (numToCount.containsKey(num)) {
                numToCount.put(num, numToCount.get(num) + 1);
            } else {
                numToCount.put(num, 1);
            }
        }
        
        List<Integer> [] counts = new ArrayList [nums.length + 1];
        
        for (int num : numToCount.keySet()) {
            int count = numToCount.get(num);
            if (counts[count] == null) counts[count] = new ArrayList();
            counts[count].add(num);
        }
        
        List<Integer> res = new ArrayList<Integer>();
        
        for (int i = nums.length, j = 0; i > 0 && k > 0; k--) {
            while (counts[i] == null || j == counts[i].size()) {
                i--;
                j = 0;
            }
            res.add(counts[i].get(j));
            j++;
        }
        
        return res;
    }
}

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> numToCount = new HashMap<Integer, Integer>();
        
        for (int num : nums) {
            if (numToCount.containsKey(num)) {
                numToCount.put(num, numToCount.get(num) + 1);
            } else {
                numToCount.put(num, 1);
            }
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        
        for (Map.Entry<Integer, Integer> entry : numToCount.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }
        
        List<Integer> res = new ArrayList<Integer>();
        
        while (!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }
        
        return res;

    }
}
