class Solution {
    public boolean isValidSerialization(String preorder) {
        int diff = 1;
        String[] nodes = preorder.split(",");
        for (String node : nodes){
            diff -= 1;
            if (diff < 0){ return false; }
            
            if(!node.equals("#")){
                diff += 2;
            }  
        }
        return diff == 0;
    }
    
    public boolean isValidSerialization2(String preorder) {
        Queue<String> q = new LinkedList<>();
        String[] nodes = preorder.split(",");
        int n = nodes.length;
        q.offer(nodes[0]);
        int i = 1;
        
        while (!q.isEmpty() && i <= n){
            int size = q.size();
            for (int j = 0; j < size; j++){
                String cur = q.poll();
                if (!cur.equals("#")){
                    if (i >= n - 1){ return false; }
                    q.offer(nodes[i]);
                    i++;
                    q.offer(nodes[i]);
                    i++;
                }
            }
        }
        return i == n && q.isEmpty();
    }
}