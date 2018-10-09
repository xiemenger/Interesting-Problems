class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        
        for (int j = 1; j < n; j++){
            dp[j] = dp[j - 1] + grid[0][j];
        }
        
        for (int i = 1; i < m; i++){
            int[] row2 = new int[n];
            row2[0] = dp[0] + grid[i][0]; 
            for (int j = 1; j < n; j++){
                row2[j] = Math.min(dp[j], row2[j - 1]) + grid[i][j];
            }
            dp = row2;
        }
        return dp[n - 1];
    }
}