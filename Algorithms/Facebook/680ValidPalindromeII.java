class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int n = s.length();
        int r = n - 1;
        while (l < r){
            if (s.charAt(l) != s.charAt(r)){
                return isPalindrome(s.substring(l + 1, r + 1)) 
                    || isPalindrome(s.substring(l, r));
            }
            l++;
            r--;
        }
        return true;
    }
    
    private boolean isPalindrome(String s){
        int l = 0;
        int r = s.length() - 1;
        while (l < r){
            if (s.charAt(l++) != s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
}