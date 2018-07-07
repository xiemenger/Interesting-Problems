class Solution {
    
    class Cell{
        int row;
        int col;
        int wallHeight;
        
        public Cell(int row, int col, int wallHeight){
            this.row = row;
            this.col = col;
            this.wallHeight = wallHeight;
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0){
            return 0;
        }
        int water = 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> (a.wallHeight - b.wallHeight));
        for (int i = 0; i < m; i++){
            visited[i][0] = true;
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][n - 1] = true;
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        
        for (int j = 0; j < n; j++){
            visited[0][j] = true;
            pq.offer(new Cell(0, j, heightMap[0][j]));
            visited[m - 1][j] = true;
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
        }
        
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!pq.isEmpty()){
            Cell cur = pq.poll();
            for (int k = 0; k < dir.length; k++){
                int row = cur.row + dir[k][0];
                int col = cur.col + dir[k][1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]){
                    if (heightMap[row][col] < cur.wallHeight){
                        water += cur.wallHeight - heightMap[row][col];
                    }
                    visited[row][col] = true;
                    pq.offer(new Cell(row, col, Math.max(cur.wallHeight, heightMap[row][col])));
                }
            } 
        }
        return water;
    }
}