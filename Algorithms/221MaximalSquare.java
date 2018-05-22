class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int maxlen = 0;
        int dpIJ = 0;
        int[] dp = new int[matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++){
            for (int j = 1; j <= matrix[0].length; j++){
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '0'){
                    dp[j] = 0;
                } else {
                    dp[j] = Math.min(Math.min(dpIJ, dp[j - 1]), dp[j]) + 1;
                    maxlen = Math.max(maxlen, dp[j]);
                }
                dpIJ = temp;
            }
        }
        return maxlen * maxlen;
    }
}