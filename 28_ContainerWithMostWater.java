class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int l = 0;
        int r = heights.length - 1;

        while (l < r) { 
            int area = Integer.min(heights[l], heights[r]) * (r - l);
            max = Integer.max(area, max);
            if (heights[l] < heights[r]) {
                l++;
            }
            else {
                r--;
            }
        }
        return max;
    }
}
