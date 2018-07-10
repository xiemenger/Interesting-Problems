/**
 * It's a two-demention backpack problems.
 * dp[i][j] means for the max num of strings to fix in i zeros and j ones.
 * for example: for string 10, we have 1 '1', 1 '0'.
 * we need to update dp[1][1] and any dp[i][j] where m > i > 1 and n> j > 1 .
 * Since it might fix into dp[i][j] too.
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String s : strs){
            int zeros = 0;
            int ones = 0;
            for (char c : s.toCharArray()){
                if (c == '0'){
                    zeros++;
                }
            }
            ones = s.length() - zeros;
            
            for (int i = m; i >= zeros; i--){
                for (int j = n; j >= ones; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}