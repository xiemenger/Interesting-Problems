class Solution {
    private static final int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
    private int m;
    private int n;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                max = Math.max(max, dfs(matrix, cache, i, j));
            }
        }
        return max;
    }
    
    public int dfs(int[][] matrix, int[][] cache, int i, int j){
        if (cache[i][j] != 0){
            return cache[i][j];
        }
        
        for (int[] d : dir){
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]){
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, cache, x, y));
            }
        }
        return ++cache[i][j];
    }
    
}