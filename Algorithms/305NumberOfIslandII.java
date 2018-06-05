class Solution {
    int[] parent;
    int[] rank;
    int count = 0;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        initializeUF(m*n);
        for (int[] p : positions){
            int x = p[0];
            int y = p[1];
            List<Integer> neib = new ArrayList<>();
            
            if (x - 1 >= 0 && isValid((x - 1) * n + y)){ neib.add((x - 1) * n + y) ; }
            if (x + 1 < m && isValid((x + 1) * n + y)){ neib.add((x + 1) * n + y) ; }
            if (y - 1 >= 0 && isValid(x * n + y - 1)){ neib.add(x * n + y - 1); }
            if (y + 1 < n && isValid(x * n + y + 1)){ neib.add(x * n + y + 1); }
            
            int cur = x * n + y;
            parent[cur] = cur;
            count++;
            for (int i : neib){
                union(cur, i);
            }
            res.add(count);
        }
        return res;
    }
    
    public boolean isValid(int i){
        return parent[i] != -1;
    }
    
    public void union(int x, int y){
        int root1 = find(x);
        int root2 = find(y);
        if (root1 != root2){
            if (rank[root1] > rank[root2]){
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]){
                parent[root1] = root2;
            } else {
                parent[root1] = root2;
                rank[root2]++;
            }
            count--;
        }
        
    }
    
    public int find(int node){
        if (parent[node] == node){
            return node;
        }
        parent[node] = find(parent[node]);
        return parent[node];
    }
    
    public void initializeUF(int N){
        parent = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++){
            parent[i] = -1;
        }
    }
}