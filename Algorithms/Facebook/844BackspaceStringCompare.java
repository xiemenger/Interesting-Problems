class Solution {
    public boolean backspaceCompare(String S, String T) {
        // S = "ab##";
        // T = "c#d#";
        int i = S.length() - 1;
        int j = T.length() - 1;
        int backCnt = 0;
        while (i >= 0 || j >= 0){
            while (i >= 0){
                if (S.charAt(i) == '#'){
                    backCnt++; i--;
                } else if (backCnt > 0){
                    backCnt--;
                    i--;
                } else {
                    break;
                }
            }
            
            while (j >= 0){
                if (T.charAt(j) == '#'){
                    backCnt++; j--;
                } else if (backCnt > 0){
                    backCnt--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)){
                return false;
            }
            
            if ((i >= 0) != (j >= 0)){
                return false;
            }
            i--; j--;
        }
        return true;
    }
}