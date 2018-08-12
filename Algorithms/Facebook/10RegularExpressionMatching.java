class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean[][] canMatch = new boolean[slen + 1][plen + 1];
        canMatch[0][0] = true;
        for (int i = 1; i <= plen; i++){
            if (p.charAt(i - 1) == '*' && canMatch[0][i - 2]){
                canMatch[0][i] = true;
            }
        }
                
        for (int i = 1; i <= slen; i++){
            char scur = s.charAt(i - 1);
            for (int j = 1; j <= plen; j++){
                char pcur = p.charAt(j  - 1);
                if (scur == pcur || pcur == '.'){
                    canMatch[i][j] = canMatch[i- 1][j - 1];
                } else if (pcur == '*'){
                    if (scur != p.charAt(j - 2) && p.charAt(j - 2) != '.'){
                        canMatch[i][j] = canMatch[i][j - 2];
                    } else {
                        canMatch[i][j] = canMatch[i][j - 2] || canMatch[i][j - 1] || canMatch[i - 1][j];
                    }
                }
            }
        }
        return canMatch[slen][plen];
    }

    public boolean isMatchRecursive(String s, String p) {
        if (p.isEmpty()){
            return s.isEmpty();
        }

        boolean firstCharMatch = s.isEmpty() && 
                                (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*'){
            return isMatchRecursive(s, p.substring(2)) ||
                    (firstCharMatch && isMatchRecursive(s.substring(1), p));
                   
        } 
        return isMatchRecursive(s.substring(1), p.substring(1));
    }
}