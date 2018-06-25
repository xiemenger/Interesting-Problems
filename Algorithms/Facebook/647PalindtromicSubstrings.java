class Solution {
    
    public int countSubstrings(String s) {
        if (s.isEmpty()){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            count += extend(s, i, i);
            count += extend(s, i, i + 1);
        }
        return count;
    }
    
     private int extend(String s , int l, int r){
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l--) == s.charAt(r++)){
            count++;
        }
        return count;
    }
    
    
    public int countSubstrings2(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++){
            for (int l = i + 1; l <= n; l++){
                if (isPalin(s.substring(i, l))){
                    count++;
                }
            }
        }
        return count;
    }
    
   
    
    private boolean isPalin(String s){
        int i = 0; 
        int j = s.length() - 1;
        while (i < j){
            if (s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}