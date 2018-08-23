class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return;
        }
        tringleSwap(matrix);
        leftRightSwap(matrix);
    }
    
    private void tringleSwap(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < i; j++){
                swap(matrix, i, j, j, i);
            }
        }
    }
    
    private void leftRightSwap(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n / 2; j++){
                swap(matrix, i, j, i, n - 1 - j);
            }
        }
    }
    
    private void swap(int[][] matrix, int i1, int j1, int i2, int j2){
        int tmp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = tmp;
    }
}