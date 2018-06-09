class Solution {
    int[] dq = {-1, 0, 1, 0};
    public int shortestDistance(int[][] grid) {
        int min = Integer.MAX_VALUE;
        //Map<Integer, List<Integer>> map = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        int walk = 0;
        int[][] sum = new int[m][n];
        int[][] buildingCount = new int[m][n];
        int buildingNum = 0;
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    buildingNum++;
                    //System.out.println("come to building "+i+","+j+"  walk:"+walk);
                    bfs(grid, i, j, walk, sum, buildingCount);
                    walk--;
                }
            }
        }
        
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                //System.out.print(" "+sum[i][j]);
                
                if (grid[i][j] < 0 && buildingCount[i][j] == buildingNum){
                    min = Math.min(sum[i][j], min);
                }
            }
            //System.out.println("  ");
        }
        return min == Integer.MAX_VALUE? -1 : min;
    
    }
    
    public void bfs(int[][] grid, int x, int y, int walk,int[][] sum,  int[][] buildingCount){
        //System.out.println("-----------------x="+x+" y="+y+"  walk:"+walk+"-------------");
        int layer = -1;
        int nextwalk = walk - 1;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(x*n+y);
        
        while(!q.isEmpty()){
            int size = q.size();
            layer++;
            for (int i = 0; i < size; i++){
                int curX = q.peek() / n;
                int curY = q.poll() % n;
                for (int k = 0; k < 4; k++){
                    int xx = curX + dq[k];
                    int yy = curY + dq[3-k];
                    if (xx >= 0 && xx < m && yy >= 0 && yy < n && grid[xx][yy] == walk){
                        sum[xx][yy] += layer + 1;
                        buildingCount[xx][yy]++;
                        //System.out.println("["+xx+"]["+yy+"]"+"add "+layer+"  total distance:"+sum[xx][yy]);
                        grid[xx][yy] = nextwalk;
                        
                        int point = xx * n + yy;
                        q.offer(point);
                    }
                }
            
            }        
        }
    }
}