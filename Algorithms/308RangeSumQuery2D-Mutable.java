class NumMatrix {
    int[][] BIT;
    int[][] nums;
    
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0){ return; }
        int m = matrix.length;
        int n = matrix[0].length;
        BIT = new int[m+1][n+1];
        nums = matrix;
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                updateBST(i, j, matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int diff = val - nums[row][col];
        nums[row][col] = val;
        updateBST(row, col, diff);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) - getSum(row2, col1 -1) - getSum(row1 - 1, col2) + getSum(row1-1, col1-1);
    }
    
    private void updateBST(int x, int y, int val){
        x++;
        y++;
        for (int i = x; i < BIT.length; i += (i & -i)){
            for (int j = y; j < BIT[0].length; j += (j & -j)){
                BIT[i][j] += val;
            }           
        }
    }
    
    private int getSum(int x, int y){
        x++;
        y++;
        int sum = 0;
        for (int i = x; i > 0; i -= (i & -i)){
            for (int j = y; j > 0; j -= (j & -j)){
                sum += BIT[i][j];
            }           
        }
        return sum;
    }
}