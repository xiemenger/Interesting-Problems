class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0){ return 0; }
        int m = grid.length;
        int n = grid[0].length;
        int[] rowhit = new int[m];
        int[] colhit =new int[n];
        int res = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (j == 0 || grid[i][j - 1] == 'W'){
                    rowhit[i] = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++){
                        rowhit[i] += grid[i][k] == 'E' ? 1 : 0;
                    }
                }
                if (i == 0 || grid[i - 1][j] == 'W'){
                    colhit[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++){
                        colhit[j] += grid[k][j] == 'E' ? 1 : 0;
                    }
                }
                if (grid[i][j] == '0'){
                    res = Math.max(res, rowhit[i] + colhit[j]);
                }
            }
        }
        return res;
    }
}