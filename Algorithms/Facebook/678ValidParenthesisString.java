class Solution {
    public boolean checkValidString(String s) {
        int open = 0;
        for (char c : s.toCharArray()){
            if (c == '*' || c == '('){
                open++;
            } else {
                open--;
            }
            if (open < 0){return false;}
        }
        if (open == 0){return true; }
        
        int close = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if (c == '*' || c == ')'){
                close++;
            } else {
                close--;
            }
            if (close < 0){return false; }
        }
        return true;
    }
}