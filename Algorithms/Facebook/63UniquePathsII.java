class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0){
            return 0;
        }
        int width = obstacleGrid[0].length;
        int[] paths = new int[width];
        paths[0] = 1;
        for (int[] gridRow : obstacleGrid){
            for (int j = 0; j < width; j++){
                if (gridRow[j] == 1){
                    paths[j] = 0;
                } else {
                    if (j > 0){
                        paths[j] += paths[j - 1];
                    }
                }
            }
        }
        return paths[width - 1];
    }
}