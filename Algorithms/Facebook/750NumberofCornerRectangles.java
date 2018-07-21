class Solution {
    public int countCornerRectangles(int[][] grid){
        if (grid == null || grid.length == 0){
            return 0;
        }
        int res = 0;
        for (int row1 = 0; row1 < grid.length; row1++){
            for (int row2 = row1 + 1; row2 < grid.length; row2++){
                int cnt = 0;
                for (int col = 0; col < grid[0].length; col++){
                    if (grid[row1][col] == 1 && grid[row2][col] == 1){
                        cnt++;
                    }
                }
                res += cnt * (cnt - 1) / 2;
            }
        }
        return res;
    }

}