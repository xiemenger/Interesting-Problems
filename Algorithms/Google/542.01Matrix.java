class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        
        int dist = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0){
                    q.offer(new int[]{i, j});
                } else {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dir = new int[][]{{-1, 0},{1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()){
            int[] cur = q.poll();

            for (int k = 0; k < dir.length; k++){
                int x = cur[0] + dir[k][0];
                int y = cur[1] + dir[k][1];

                if (x >= 0 && x < m && y >= 0 && y < n && res[x][y] > res[cur[0]][cur[1]]){
                    res[x][y] = res[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return res;
    }
}