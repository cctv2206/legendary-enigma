/**

Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

Example 1:
Given points = [[1,1],[-1,1]], return true.

Example 2:
Given points = [[1,1],[-1,-1]], return false.

Follow up:
Could you do better than O(n2)?

Hint:

Find the smallest and largest x-value for all points.
If there is a line then it should be at y = (minX + maxX) / 2.
For each point, make sure that it has a reflected point in the opposite side.

*/

public class Solution {
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        Set<String> pointSet = new HashSet<String>();
        
        for (int[] point : points) {
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            
            pointSet.add(point[0] + "," + point[1]);
        }
        
        int sum = max + min;
        
        for (int[] point : points) {
            if (!pointSet.contains((sum - point[0]) + "," + point[1])) {
                return false;
            }
        }
        
        return true;
    }
}

public class Solution {
    public boolean isReflected(int[][] points) {
        if (points.length == 0) {
            return true;
        }
        
        int max = points[0][0];
        int min = points[0][0];
        
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        
        for (int[] point : points) {
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);

            if (!map.containsKey(point[0])) {
                map.put(point[0], new HashSet<Integer>());
            }
            map.get(point[0]).add(point[1]);
        }

        int sum = (max + min);
        
        for (int[] point : points) {
            int x = sum - point[0];
            if (!map.containsKey(x) || !map.get(x).contains(point[1])) {
                return false;
            }
        }
        
        return true;
    }
}
