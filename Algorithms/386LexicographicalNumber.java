class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++){
            dfs(n, i, res);
        }
        return res;
    }
    
    public void dfs(int n, int cur, List<Integer> res){
        if (cur > n){
            return;
        }
        res.add(cur);
        for (int i = 0; i <= 9; i++){
            int next = cur*10 + i;
            if (next > n){
                return;
            }
            dfs(n, next, res);
        }
    }
}