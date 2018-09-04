class Solution {
    public void solveSudoku(char[][] board) {
       if (board == null || board.length == 0){
           return;
       }
       solve(board, 0, 0);
    }
    
    public boolean solve(char[][] board, int row, int col){
        if (row == 9){return true; }
        if (board[row][col] != '.'){
            if (col == 8){
                return solve(board, row + 1, 0);
            } else {
                return solve(board, row, col + 1);
            }
        }
        
        for (char c = '1'; c <= '9'; c++){
            if (isValid(board, c, row, col)){
                board[row][col] = c;
                if (solve(board, col == 8 ? row + 1 : row, col == 8 ? 0 : col + 1)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    
    public boolean isValid(char[][] board, char c, int i, int j){
        for (int k = 0; k < 9; k++){
            if (board[i][k] == c || board[k][j] == c){return false; }
            int cubei = 3 * (i / 3) + k / 3;
            int cubej = 3 * (j / 3) + k % 3;
            if (board[cubei][cubej] == c){return false; }
        }
        return true;
    }
}