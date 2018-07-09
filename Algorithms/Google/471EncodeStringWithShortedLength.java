class Solution {
    public String encode(String s) {
        
        int n = s.length();
        String[][] dp = new String[n][n];
        
        for (int len = 0; len < n; len++){
            for (int i = 0; i < n - len; i++){
                int j = i + len;
                String substr = s.substring(i, j + 1);
                dp[i][j] = substr;
                
                if (len < 4 ){
                    continue;
                }
                
                // check if the substring can be composed by sub part from dp table.
                for (int k = i; k < j; k++){
                    String cand = dp[i][k] + dp[k+1][j];
                    if (cand.length() < dp[i][j].length()){
                        dp[i][j] = cand;
                    }
                }
                
                // check if the substring can be compose by sub part from itself.
                int m = substr.length();
                for (int k = 0; k <= m / 2; k++){
                    String subsub = substr.substring(0, k + 1);
                    if (m % subsub.length() == 0 && checkValid(substr, subsub)){
                        String cand = (m / subsub.length()) + "[" + dp[i][i+k] + "]";
                        if (cand.length() < dp[i][j].length()){
                            dp[i][j] = cand;
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
    
    private boolean checkValid(String s, String sub){
        int n = s.length();
        int m = sub.length();        
        for (int i = 0; i < n; i++){
            if (s.charAt(i) != sub.charAt(i % m)){
                return false;
            }
        }
        return true;
    }
}