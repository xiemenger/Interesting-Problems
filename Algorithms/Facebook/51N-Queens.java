class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0){return res; }
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        solve(n, 0, board, res);
        return res;
    }
    
    private void solve(int n, int row, char[][] board, List<List<String>> res){
        if (row == n){
            res.add(contruct(board));
            return;
        }
        for (int col = 0; col < board[0].length; col++){
            if (valid(board, row, col)){
                board[row][col] = 'Q';
                solve(n, row+1, board, res);
                board[row][col] = '.';
            }
        }
    }
    
    private List<String> contruct(char[][] board){
        List<String> vb = new ArrayList<>();
        for (int i = 0; i < board.length; i++){
            vb.add(new String(board[i]));
        }
        return vb;
    }
    
    private boolean valid(char[][] board, int row, int col){
        // check col
        for (int i = row - 1; i >= 0; i--){
            if (board[i][col] == 'Q'){return false; }
        }
        
        // check 45 degree
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++){
            if (board[i][j] == 'Q'){return false; }
        }
        
        // check 135 degree
        for (int i = row - 1, j = col - 1; i>=0 && j >= 0; i--, j--){
            if (board[i][j] == 'Q'){return false; }
        }
        return true;
    }
}