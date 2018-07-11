class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        for (int num : nums){ sum += num; }
        if ((sum & 1) == 1){return false; }
        
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        
        for (int num : nums){
            for (int j = sum; j > 0; j--){
                if (j >= num){
                    dp[j] = dp[j] || dp[j - num];
                }
            }
        }
        return dp[sum];
    }
}