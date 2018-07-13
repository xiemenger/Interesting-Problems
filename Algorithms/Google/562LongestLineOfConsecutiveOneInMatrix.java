class Solution {
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0){
            return 0;
        }
        
        int m = M.length;
        int n = M[0].length;
        int res = 0;
        int[][] dp1 = new int[n + 1][4];
        
        for (int i = 1; i <= m; i++){
            int[][] dp2 = new int[n + 1][4];
            for (int j = 1; j <= n; j++){
                if (M[i - 1][j - 1] == 1){
                    dp2[j][0] = dp1[j][0] + 1;
                    res = Math.max(res, dp2[j][0]);
                    
                    dp2[j][1] = dp2[j - 1][1] + 1;
                    res = Math.max(res, dp2[j][1]);
                    
                    dp2[j][2] = dp1[j - 1][2] + 1;
                    res = Math.max(res, dp2[j][2]);
                    
                    dp2[j][3] = 1 + (j < n ? dp1[j + 1][3] : 0);
                    res = Math.max(res, dp2[j][3]);
                }
            }
            dp1 = dp2;
        }
        return res;
    }
}