class Solution {
    private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int maxLen = 1;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                maxLen = Math.max(maxLen, searchLongestIncreasing(matrix, i, j, cache));
            }
        }
        return maxLen;
    }
    
    private int searchLongestIncreasing(int[][] matrix, int i, int j, int[][] cache){
        if (cache[i][j] != 0){ return cache[i][j]; }
        int len = 1;
        for (int[] d : dir){
            int nexti = i + d[0];
            int nextj = j + d[1];
            if (nexti >= 0 && nexti < matrix.length && 
                nextj >= 0 && nextj < matrix[0].length && 
                matrix[nexti][nextj] > matrix[i][j]){
                
                len = 1 + searchLongestIncreasing(matrix, nexti, nextj, cache);  
            }
            cache[i][j] = Math.max(len, cache[i][j]);
        }
        return cache[i][j];
    }
    
    
}