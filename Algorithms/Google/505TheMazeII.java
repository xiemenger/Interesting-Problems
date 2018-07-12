class Solution {
    class Point{
        int x;
        int y;
        int len;
        
        public Point(int x, int y, int len){
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int minDist = Integer.MAX_VALUE;
        Queue<Point> q = new LinkedList<>();
        int[][] lens = new int[m][n];
        
        for (int i = 0; i < m; i++){
            Arrays.fill(lens[i], Integer.MAX_VALUE);
        }
        
        q.offer(new Point(start[0], start[1], 0));
        lens[start[0]][start[1]] = 0;
        
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()){
            Point cur = q.poll();
            //if (cur.len >= lens[cur.x][cur.y]){continue; }
            
            for (int k = 0; k < dir.length; k++){
                int x = cur.x;
                int y = cur.y;
                int l = cur.len;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1){
                    x += dir[k][0];
                    y += dir[k][1];
                    l++;
                }
                x -= dir[k][0];
                y -= dir[k][1];
                l--;
                
                if (x == destination[0] && y == destination[1]){
                    minDist = Math.min(minDist, l);
                    continue;
                }
                
                if (l < lens[x][y]){
                    lens[x][y] = l;
                    q.offer(new Point(x, y, l));
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}