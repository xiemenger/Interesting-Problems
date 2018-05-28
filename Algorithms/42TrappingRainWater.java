class Solution {
     // DP, three passes
     // O(n), O(n)
     public int trap(int[] height) {
         if (height == null || height.length < 2){
            return 0;
         }
         int n = height.length;
         int water = 0;

         int[] leftmax = new int[n];
         int[] rightmax = new int[n];
         leftmax[0] = height[0];
         for (int i = 1; i < n; i++){
             leftmax[i] = Math.max(height[i], leftmax[i - 1]);
         }
         
         rightmax[n - 1] = height[n - 1];
         for (int i = n - 2; i >= 0; i--){
             rightmax[i] = Math.max(height[i], rightmax[i + 1]);
         }
         
         for (int i = 0; i < n; i++){
             water += Math.min(leftmax[i], rightmax[i]) - height[i];
         }
         
         return water;
     }
    
    // two pointer, one pass
    // O(n), O(1)
    public int trap2(int[] height) {
        if (height == null || height.length < 2){
            return 0;
        }
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int lWall = height[0];
        int rWall = height[n - 1];
        int waters = 0;
        
        while (l < r){
            if (height[l] < height[r]){
                if (lWall <= height[l]){
                    lWall = height[l];
                } else {
                    waters += lWall - height[l];
                }
                l++;
            } else {
                if (rWall <= height[r]){
                    rWall = height[r];
                } else {
                    waters += rWall -height[r]; 
                }
                r--;
            }
        }
        return waters;
    }
}