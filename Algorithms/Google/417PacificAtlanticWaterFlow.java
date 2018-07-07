class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix){
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0){ return res; }
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pacificReach = new boolean[m][n];
        boolean[][] atlanticReach = new boolean[m][n];
        for (int i = 0; i < m; i++){
            bfs(matrix, i, 0, pacificReach);
            bfs(matrix, i, n - 1, atlanticReach);
        }
        
        for (int j = 0; j < n; j++){
            bfs(matrix, 0, j, pacificReach);
            bfs(matrix, m - 1, j, atlanticReach);
        }
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (pacificReach[i][j] && atlanticReach[i][j]){
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }
    
    private void bfs(int[][] matrix, int i , int j, boolean[][] visited){
        if (visited[i][j]){ return; }
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        int[][] dir = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        visited[i][j] = true;
        
        while(!q.isEmpty()){
            int[] pos = q.poll();
            for (int k = 0; k < dir.length; k++){
                int x = pos[0] + dir[k][0];
                int y = pos[1] + dir[k][1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] 
                    && matrix[x][y] >= matrix[pos[0]][pos[1]]){
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
        }
    }
}