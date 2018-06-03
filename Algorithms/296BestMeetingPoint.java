class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> verticalPoints = new ArrayList<>();
        List<Integer> horizontalPoints = new ArrayList<>();
        collectVertical(grid, verticalPoints);
        collectHorizontal(grid, horizontalPoints);
        return minDist(verticalPoints)+minDist(horizontalPoints);
    }
    
    public int minDist(List<Integer> l){
        int m = l.get(l.size() / 2);
        int dist = 0;
        for(int p : l){
            dist += Math.abs(p - m);
        }
        return dist;
    }
    
    public void collectVertical(int[][] grid, List<Integer> verticalPoints){
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    verticalPoints.add(i);
                }
            }
        }
    }
    
    public void collectHorizontal(int[][] grid, List<Integer> horizontalPoints){
        for (int i = 0; i < grid[0].length; i++){
            for (int j = 0; j < grid.length; j++){
                if (grid[j][i] == 1){
                    horizontalPoints.add(i);
                }
            }
        }
    }
}