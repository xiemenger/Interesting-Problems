class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1){ 
            res.add (0); 
            return res;
        }
        List<Set<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++){
            map.add(new HashSet<>());
        }
        for (int[] e: edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++){
            if (map.get(i).size() == 1){
                q.offer(i);
            }
        }
        
        int curNode = 0;
        while (n > 2){
            int count = q.size();
            n -= count;
            for (int i = 0; i < count; i++){
                curNode = q.poll();
                for (int neib : map.get(curNode)){
                    map.get(neib).remove(curNode);
                    if (map.get(neib).size() == 1){
                        q.offer(neib);
                    }
                }
            }
            
        }
    
       while(!q.isEmpty()){
           res.add(q.poll());
       }
        return res;
    }
}