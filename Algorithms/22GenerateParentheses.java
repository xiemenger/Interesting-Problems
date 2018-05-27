class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0){
            return res;
        }
        backtrack(n, 0, 0, res, "");
        return res;
    }
    public void backtrack(int n, int open, int close, List<String> res, String path){
        if (path.length() == n*2){
            res.add(path);
            return;
        }
        
        if (open < n){
            backtrack(n, open + 1, close, res, path + "(");
        }
        
        if (close < open){
            backtrack(n, open, close + 1, res, path + ")");
        }
    }
}