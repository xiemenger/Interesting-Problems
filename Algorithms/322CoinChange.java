class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = amount;
        int m = coins.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < m; j++){
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]+1);
                }
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1: dp[n];
    }
}