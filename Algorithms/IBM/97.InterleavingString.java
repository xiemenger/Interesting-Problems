class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 + l2 != s3.length()){ return false; }
        boolean[][] match = new boolean[l1 + 1][l2 + 1];
        match[0][0] = true;
        
        for (int i = 0; i <= l1; i++){
            for (int j = 0; j <= l2; j++){
                if (i == 0 && j == 0){match[i][j] = true;}
                else if (i == 0){
                    match[i][j] = match[i][j - 1] && s3.charAt(j - 1) == s2.charAt(j - 1);
                } else if (j == 0){
                    match[i][j] = match[i - 1][j] && s3.charAt(i - 1) == s1.charAt(i - 1);
                } else {
                    match[i][j] = s3.charAt(i + j - 1) == s1.charAt(i - 1) && match[i - 1][j]
                            || s3.charAt(i + j - 1) == s2.charAt(j - 1) && match[i][j - 1];
                }
            }
        }
        return match[l1][l2];
    }
}