class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        int l = 0; 
        int r = 0;
        int sum = 0;
        int minlen = Integer.MAX_VALUE;
        for (; r < nums.length; r++){
            sum += nums[r];
            while (sum >= s){
                minlen = Math.min(minlen, r + 1 - l);
                sum -= nums[l];
                l++;
            }
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}