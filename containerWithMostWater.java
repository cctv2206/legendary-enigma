/**

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

*/

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > res) {
                res = area;
            }
            
            if (height[left] < height[right]) {
                int h = height[left];
                while (left < right && height[left] <= h) left++;
            } else {
                int h = height[right];
                while (left < right && height[right] <= h) right--;
            }
        }
        return res;
    }
}
