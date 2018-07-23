class Solution{
    public int largestIslandDiameter(int[][] grid){
        if (grid == null || grid.length == 0){
            return 0;
        }
        int maxDiameter = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    maxDiameter = Math.max(maxDiameter, search(grid, i, j)) ;
                }
            }
        }

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 2){
                    grid[i][j] = 1;
                }
            }
        }
        return maxDiameter;
    }

    private int search(int[][] grid, int x, int y){
        if (x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == 0){
            return 1;
        }
        if (grid[x][y] == 2){
            return 0;
        }
        grid[x][y] = 2;
        int res = 0;
        res += search(grid, x + 1, y);
        res += search(grid, x - 1, y);
        res += search(grid, x, y + 1);
        res += search(grid, x, y - 1);
        return res;
    }
}