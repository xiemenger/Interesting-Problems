class Solution {
    public boolean validTicTacToe(String[] board) {
        int xc = 0;
        int oc = 0;
        for (String s : board){
            for (char c : s.toCharArray()){
                if (c == 'X'){ xc++; }
                else if (c == 'O'){ oc++; }
            }
        }
        
        if (xc != oc && xc != oc + 1){ return false; }
        if (win(board, 'X') && xc != oc + 1){ return false; }
        if (win(board, 'O') && xc != oc){ return false; }
        return true;
    }
    
    private boolean win(String[] b, char p){
        for (int i = 0; i < b.length; i++){
            if (b[i].charAt(0) == p && b[i].charAt(1) == p && b[i].charAt(2) == p){
                return true;
            }
            if (b[0].charAt(i) == p && b[1].charAt(i) == p && b[2].charAt(i) == p){
                return true;
            }
        }
        if (b[0].charAt(0) == p && b[1].charAt(1) == p && b[2].charAt(2) == p){
            return true;
        }
        if (b[0].charAt(2) == p && b[1].charAt(1) == p && b[2].charAt(0) == p){
            return true;
        }
        return false;
    }
}