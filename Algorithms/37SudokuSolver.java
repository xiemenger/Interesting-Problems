class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0){ return; }
        solve(board, 0, 0);
    }
    
    public boolean solve(char[][] board, int row, int col){
        for (int i = row; i < board.length; i++, col = 0){
            for (int j = col; j < board[0].length; j++){
                if (board[i][j] != '.'){ continue; }
                
                for (char c = '1'; c <= '9'; c++ ){
                    if (!isValid(board, c, i, j)){ continue; }
                    board[i][j] = c;
            
                    if (solve(board, i, j + 1)){ return true; }
                    
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, char c, int i, int j){
        for (int k = 0; k < 9; k++){
            if (board[i][k] == c || board[k][j] == c){ return false; }
            int cubei = i / 3 * 3 + k / 3;
            int cubej = j / 3 * 3 + k % 3;
            if (board[cubei][cubej] == c){ return false; }
        }
        return true;
    }
}