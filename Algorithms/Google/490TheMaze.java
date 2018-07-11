class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        visited[start[0]][start[1]] = true;
        
        while (!q.isEmpty()){
            int[] cur = q.poll();
            for (int k = 0; k < dir.length; k++){
                int x = cur[0] + dir[k][0];
                int y = cur[1] + dir[k][1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0){
                    x += dir[k][0];
                    y += dir[k][1];
                }
                x -= dir[k][0];
                y -= dir[k][1];
                
                if (!visited[x][y]){
                    if (destination[0] == x && destination[1] == y){
                        return true;
                    }
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}