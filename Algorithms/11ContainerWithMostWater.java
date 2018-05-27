class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r){
            max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
            if (height[l] <= height[r]){
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}