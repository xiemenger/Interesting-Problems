class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (S > sum || S < -sum){ return 0; }
        
        int n = nums.length + 1;
        int m = 2*sum+1;
        int[][] dp = new int[n][m];
        dp[0][sum] = 1;
        for (int i = 1; i < n; i++){
            for (int j = 0; j < m; j++){
                if (j-nums[i-1] >= 0 ){ dp[i][j] += dp[i - 1][j - nums[i - 1]]; }
                if (j+nums[i-1] < m){ dp[i][j] += dp[i - 1][j + nums[i - 1]];  }
            }
        }
        return dp[n-1][S+sum];
    }
    
    public int findTargetSumWays2(int[] nums, int S) {
        int[] count = new int[1];
        search(nums, 0, S, count);
        return count[0];
    }
    
    private void search(int[] nums, int i, int S, int[] count){
        if (i == nums.length && S == 0){
            count[0]++;
            return;
        }
        if (i >= nums.length){
            return;
        }
        
        search(nums, i+1, S+nums[i], count);
        search(nums, i+1, S-nums[i], count);
    }
}