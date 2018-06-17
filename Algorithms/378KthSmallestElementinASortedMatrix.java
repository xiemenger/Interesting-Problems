class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || k > matrix.length*matrix[0].length){
            return -1;
        }
        Queue<Element> q = new PriorityQueue<>(new Comparator<Element>(){
            public int compare(Element a, Element b){
                return a.val - b.val;
            }
        });
        int m = matrix.length;
        int n = matrix[0].length;
        
        
        q.offer(new Element(matrix[0][0], new int[]{0,0}));
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        
        while (k -- > 0 && !q.isEmpty()){
            Element cur = q.poll();
            if (k == 0){
                return cur.val;
            }
            int i = cur.pos[0];
            int j = cur.pos[1];
            
            if (j+1 < n && !visited[i][j+1]){
                q.offer(new Element(matrix[i][j+1], new int[]{i, j+1}));
                visited[i][j+1] = true;
            }
            if (i+1 < m && !visited[i+1][j]){
                q.offer(new Element(matrix[i+1][j], new int[]{i+1, j}));
                visited[i+1][j] = true;
            }
        }
        return -1;
    }
    
    class Element{
        int val;
        int[] pos;
        public Element(int val, int[] pos){
            this.val = val;
            this.pos = pos;
        }
    }
}