class Solution {
    public int maxProduct(int[] nums) {
        int imax = nums[0];
        int imin = nums[0];
        int max = imax;
        
        for (int i = 1; i < nums.length; i++){
            
            if (nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);
            
            max = Math.max(max, imax);
        }
        return max;
    }
}