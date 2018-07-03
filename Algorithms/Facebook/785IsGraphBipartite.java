class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        
        for (int i = 0; i < n; i++){
            if (colors[i] != 0){ continue; }
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            colors[i] = 1;
            
            while (!stack.isEmpty()){
                int cur = stack.pop();
                for (int nei : graph[cur]){
                    if (colors[nei] == 0){
                        stack.push(nei);
                        colors[nei] = colors[cur] * -1;
                        System.out.println(nei+":"+colors[nei]);
                    } else if (colors[nei] == colors[cur]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}