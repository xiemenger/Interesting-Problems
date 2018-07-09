class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int len = 1; len <= n / 2; len++){
            if (n % len == 0){
                String cand = s.substring(0, len);
                int j = len;
                for (; j < n; j++){
                    if (s.charAt(j) != cand.charAt(j % len)){
                        break;
                    }
                }
                if (j == n){
                    return true;
                }
            }
        }
        return false;
    }
}