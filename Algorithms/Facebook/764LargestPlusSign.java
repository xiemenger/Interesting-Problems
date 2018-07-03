class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> zeros = new HashSet<>();
        int res = 0;
        for (int[] pos : mines){
            zeros.add(pos[0] * N + pos[1]);
        }
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++){
            
            // left to right
            int cnt = 0;
            for (int j = 0; j < N; j++){
                cnt = zeros.contains(i * N + j) ? 0 : cnt + 1;
                dp[i][j] = cnt;
            }
            
            // right to left
            cnt = 0;
            for (int j = N - 1; j >= 0; j--){
                cnt = zeros.contains(i * N + j) ? 0 : cnt + 1;
                dp[i][j] = Math.min(dp[i][j], cnt);
            }
        }
        
        for (int j = 0; j < N; j++){
            int cnt = 0;
            // top to bottom
            for (int i = 0; i < N; i++){
                cnt = zeros.contains(i * N + j) ? 0 : cnt + 1;
                dp[i][j] = Math.min(dp[i][j], cnt);
            }
            
            // bottom to top
            cnt = 0;
            for (int i = N - 1; i >= 0; i--){
                cnt = zeros.contains(i * N + j) ? 0 : cnt + 1;
                dp[i][j] = Math.min(dp[i][j], cnt);
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}