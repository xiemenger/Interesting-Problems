class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0){
            return;
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                int lcount = checkLives(board, i, j);
                System.out.println("i:"+i+" j:"+j+"  count:"+lcount);
                if (board[i][j] == 1 && (lcount < 2 || lcount > 3)){ 
                    board[i][j] = -1; 
                } else if (board[i][j] == 0 && lcount == 3){
                    board[i][j] = -2;
                }
            }
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == -1){
                    board[i][j] = 0;
                } else if (board[i][j] == -2){
                    board[i][j] = 1;
                }
            }
        }
    }
    
    public int checkLives(int[][] board, int x, int y){
        int[] d = {-1, 0, 1};
        int lcount = 0;
        for (int i = 0; i < 3; i++){
            int xx = x + d[i];
            if (xx < 0 || xx >= board.length){ continue; }
            for (int j = 0; j < 3; j++){
                int yy = y +d[j]; 
                if (yy < 0 || yy >= board[0].length || (xx == x && yy == y)){ continue; }
                if (board[xx][yy] == 1 || board[xx][yy] == -1){ lcount++; } 
            }
        }
        return lcount;
    }
}