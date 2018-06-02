class Solution {
    int[] d = {0,1,0,-1};
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0){
            return;
        }
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (rooms[i][j] == 0){
                    q.offer(i*n+j);
                }
            }
        }
        bfs(rooms, q);
    }
    
    public void bfs(int[][] rooms, Queue<Integer> q){
        while(!q.isEmpty()){
            int pos = q.poll();
            int x = pos / rooms[0].length;
            int y = pos % rooms[0].length;
            for (int k = 0; k < 4; k++){
                int xx = x + d[k];
                int yy = y + d[3-k];
                if (0 <= xx && xx < rooms.length 
                    && 0 <= yy && yy < rooms[0].length 
                    && rooms[xx][yy] == Integer.MAX_VALUE){
                    rooms[xx][yy] = rooms[x][y] + 1;
                    q.offer(xx*rooms[0].length + yy);
                }
            }
        }
    }
    
    public void dfs2(int[][] rooms, int x, int y){
        for (int i = 0; i < 4; i++){
            int xx = x + d[i];
            int yy = y + d[3-i];
            if (0 <= xx && xx < rooms.length && 0 <= yy && yy < rooms[0].length && rooms[xx][yy] > rooms[x][y] + 1){
                rooms[xx][yy] = rooms[x][y] + 1;
                dfs2(rooms, xx, yy);
            }
        }
    }
}