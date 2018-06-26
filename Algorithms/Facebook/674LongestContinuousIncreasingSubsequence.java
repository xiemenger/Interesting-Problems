class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        int l = 0;
        int max = 1;
        for (int r = 1; r < nums.length; r++){
            if (nums[r] > nums[r - 1]){
                max = Math.max(r - l + 1, max);
            } else {
                l = r;
            }
        }
        return max;
    }
}