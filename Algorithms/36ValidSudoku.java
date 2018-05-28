class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] cubes = new boolean[9][9];
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '.'){ continue; }
                int num = board[i][j] - '0' - 1;
                int k = i / 3 * 3 + j / 3;
                if (rows[i][num] || columns[j][num] || cubes[k][num]){
                    return false;
                }
                rows[i][num] = true;
                columns[j][num] = true;
                cubes[k][num] = true;
            }
        }
        
        return true;
    }
}