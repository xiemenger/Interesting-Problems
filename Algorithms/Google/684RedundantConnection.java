class Solution {
    // Find and Union
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 0; i <= n; i++){
            parent[i] = i;
        }
        int[] res = new int[2];
        
        for (int[] e : edges){
            int root1 = find(parent, e[0]);
            int root2 = find(parent, e[1]);
            if (root1 == root2){
                res = e;
                break;
            }
            
            if (rank[root1] == rank[root2]){
                parent[root2] = root1;
                rank[root1]++;
            } else if (rank[root1] > rank[root2])  {
                parent[root2] = root1;
            } else {
                parent[root1] = root2;
            }       
            
        }
        return res;                                  
    }
    
    private int find(int[] parent, int idx){
        if (parent[idx] == idx){
            return idx;
        }
        parent[idx] = find(parent, parent[idx]);
        return parent[idx];
    }
    
    
    
    // DFS: Time: O(n^2), Space: O(n)
    public int[] findRedundantConnection2(int[][] edges) {
        int n = edges.length;
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        int[] res = new int[2];
        
        for (int[] e : edges){
             System.out.print("edge:["+e[0]+" "+e[1]+"]   ");
            if (!graph[e[0]].isEmpty() && !graph[e[1]].isEmpty() 
                && dfs(e[0], e[1], graph, new HashSet<>())){
                res = e;
                break;
            }
            
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
            //System.out.println(" ");
        }
        return res;
    }
    
    private boolean dfs(int from, int target, List<Integer>[] graph, Set<Integer> visited){
        //System.out.print(from+"->");
        if (from == target) {
            //System.out.print("  find !"+target);
            return true;
        }
        
        if (!visited.contains(from)){
            visited.add(from);
            for (int neib : graph[from]){
                if (!visited.contains(neib) && dfs(neib, target, graph, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}