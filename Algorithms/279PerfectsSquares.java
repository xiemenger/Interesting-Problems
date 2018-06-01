class Solution {
    //DP
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j *j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
    
    
    //BFS
    public int numSquares2(int n) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited.add(0);
        int depth = 0;
        while (!q.isEmpty()){
            depth++;
            int size = q.size();
            while (size-- > 0){
                int u = q.poll();
                for (int i = 1; i * i <= n; i++){
                    int v = u + i*i;
                    if (v == n){
                        return depth;
                    } else if (v > n){
                        break;
                    } else {
                        if(!visited.contains(v)){
                            visited.add(v);
                            q.offer(v);
                        }
                    }
                }
            }
        }
        return depth;
    }
}