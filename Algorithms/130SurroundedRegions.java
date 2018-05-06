class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board.length == 1 || board[0].length == 1){
            return ;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++){
            dfs(board, i, 0);
        }
        for (int i = 0; i < m; i++){
            dfs(board, i, n - 1);
        }
        for (int j = 0; j < n; j++){
            dfs(board, 0, j);
        }
        for (int j = 0; j < n; j++){
            dfs(board, m - 1, j);
        }
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if (board[i][j] == '1'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void dfs(char[][] board, int i, int j){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = '1';
        dfs(board, i - 1, j);
        dfs(board, i, j - 1);
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
    }
}