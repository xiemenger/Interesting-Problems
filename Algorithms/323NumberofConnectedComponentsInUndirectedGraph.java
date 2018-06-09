class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        int[] rank = new int[n];
        int count = 0;
        
        for (int i = 0; i < n; i++){
            root[i] = i;
        }
        
        for (int[] e : edges){
            union(root, rank, e[0], e[1]);
        }
        
        for (int i = 0; i < n; i++){
            if (root[i] == i){
                count++;
            }
        }
        return count;
    }
    
    public int find(int[] root, int i){
        if (root[i] != i){
            root[i] = find(root, root[i]);
        }
        return root[i];
    }
    
    public void union(int[] root, int[] rank, int i, int j){
        int root1 = find(root, i);
        int root2 = find(root, j);
        if (root1 != root2){
            if (rank[root1] == rank[root2]){
                root[root2] = root1;
                rank[root1]++;
            } else if (rank[root1] > rank[root2]){
                root[root2] = root1;
            } else {
                root[root1] = root2;
            }
        }
    }
}