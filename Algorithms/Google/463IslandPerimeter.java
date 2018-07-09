class Solution {
    public int islandPerimeter(int[][] grid) {
        int cubes = 0;
        int duplicate = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    cubes++;
                    if (j < n - 1 && grid[i][j + 1] == 1){ duplicate++; }
                    if (i < m - 1 && grid[i + 1][j] == 1){ duplicate++; }
                }
            }
        }
        return cubes * 4 - duplicate * 2;
    }
}