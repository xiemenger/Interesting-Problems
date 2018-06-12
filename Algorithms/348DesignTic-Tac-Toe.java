class TicTacToe {

    /** Initialize your data structure here. */
    int[] Row;
    int[] Col;
    int diagonal;
    int antidiagonal;
    public TicTacToe(int n) {
        Row = new int[n];
        Col = new int[n];
        diagonal = 0;
        antidiagonal = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int val = player == 1 ? 1 : -1;
        int n = Row.length;
        Row[row] += val;
        Col[col] += val;
        if (row == col){
            diagonal += val;
        }
        
        if (row + col == n - 1){
            antidiagonal += val;
        }
        
        if (Math.abs(Row[row]) == n || 
            Math.abs(Col[col]) == n ||
            Math.abs(diagonal) == n ||
            Math.abs(antidiagonal) == n){
            return player;
        }
        return 0;
    }
}