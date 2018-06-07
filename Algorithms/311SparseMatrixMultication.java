class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length; 
        int n = B[0].length; 
        int k = A[0].length;   
        int[][] c = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int x = 0; x < k; x++){
                if (A[i][x] == 0){ continue;}
                for (int j = 0; j < n; j++){
                    if (B[x][j] == 0 ){ continue; }
                    c[i][j] += A[i][x] * B[x][j];
                }
            }
        }
        return c;
    }
}