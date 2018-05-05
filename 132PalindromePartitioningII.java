// Inspired by this top vote, rewrite myself in Java, DP solution beats 100% :-)
// We can have a int[] f, where f[i] means the minumum cuts needed for a palindrome partitioning of s.substring(0, i+1). 
// So we can just return f[len-1]. 
// We can assume the maximum cuts, so the base cases are f[i] = i. 
// (Inspring by LC 5. Longest Palindromic Substring), 
// we can expand from the center to left and right. 
// If s.charAt(left) == s.charAt(right), that means the s.substring.(left, right + 1) is palindrom, 
// then f[right] = f[left - 1] + 1, adding 1 because the substring between left and right needed that 1 cut.
//  And if left == 0, that means s.substring(0, right + 1) is palindrom, so no cut will be needed, so f[right] = 0. 
//  We need to consider both even and odd length of the string so we expand from [i, i] and [i, i+1]

 class Solution {
    public int minCut(String s) {
        if (s.isEmpty()){
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++){
            dp[i] = i;
        }
        
        for (int i = 0; i < n; i++){
            checkPalindrome(s, i, i, dp);
            checkPalindrome(s, i, i + 1, dp);
        }
        return dp[n - 1];
        
    }
    
    public void checkPalindrome(String s, int left, int right, int[] dp){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            if (left == 0){
                dp[right] = 0;
            } else {
                dp[right] = Math.min(dp[right], dp[left - 1] + 1);
            }
            left--;
            right++;
        }
    }
}