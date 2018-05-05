/**
   1) If length of T is 0, return 1.

   // Else no string can be a sequence of empty S.
   2) Else if S is empty, return 0.
    
   3) Else if last characters of S and T don't match,
      remove last character of S and recur for remaining
        return subsequenceCount(S, T, n-1, m)

   4) Else (Last characters match), the result is sum
      of two counts.
        
        // Remove last character of S and recur.
        a) subsequenceCount(S, T, n-1, m) + 

        // Remove last characters of S and T, and recur.
        b) subsequenceCount(S, T, n-1, m-1)     
*/

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n < m){
            return 0;
        }
        
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < n + 1; i++){
            dp[0][i] = 1;
        }
        
        for (int i = 1; i < m + 1; i++){
            char tChar = t.charAt(i - 1);
            for (int j = 1; j < n + 1; j++){
                char sChar = s.charAt(j - 1);
                if (tChar == sChar){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}