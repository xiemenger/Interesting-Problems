class Solution {
    int count;
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        
        for (int i = 1; i <= target; i++){
            for (int k = 0; k < nums.length; k++){
                if (i - nums[k] >= 0){
                    dp[i] += dp[i - nums[k]];
                }
            }
        }
        return dp[target];
    }
}