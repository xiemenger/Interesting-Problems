class Solution {
    public int maxCoins(int[] nums) {
        int[] num = new int[nums.length+2];
        int n = 1;
        for (int x : nums){
            if (x > 0){
                num[n++] = x;
            }
        }
        num[0] = 1;
        num[n++] = 1;
        int[][] dp = new int[n][n];
        for (int dist = 2; dist < n; dist++){
            for (int l = 0; l < n - dist; l++){
                int r = l + dist;
                for (int i = l+1; i < r; i++){
                    int curCoin = num[l]*num[i]*num[r] + dp[l][i]+dp[i][r];
                    dp[l][r] = Math.max(dp[l][r], curCoin);
                }
            }
        }
        return dp[0][n-1];
    }
}