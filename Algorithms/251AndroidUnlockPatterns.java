class Solution {
    public int numberOfPatterns(int m, int n) {
        boolean[] used = new boolean[9];
        int sum = 0;
        for (int i = m; i <= n; i++){
            sum += backtrack(-1, i, used);
            for (int j = 0; j < used.length; j++){
                used[j] = false;
            }
        }
        return sum;
    }
    
    private int backtrack(int from, int l, boolean[] used){
        if (l == 0){ 
            return 1; 
        }
        
        int sum = 0;
        for (int to = 0; to < 9; to++){
            if (isValid(from, to, used)){
                used[to] = true;
                sum += backtrack(to, l - 1, used);
                used[to] = false;
            }
        }
        return sum;
    }
    
    
    private boolean isValid(int from, int to, boolean[] used){
        
        if (used[to]){ 
            return false; 
        }
        if (from == -1){
            return true;
        }
        
        if ((from + to ) % 2 == 1){
            return true;
        }
        
        int m = (from + to) / 2;
        if (m == 4){
            return used[m];
        }
        
        if(( from % 3 != to % 3) && (from / 3 != to / 3)){
            return true;
        }
        
        return used[m];
        
    }
}