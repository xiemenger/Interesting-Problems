class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int n = length;
        int[] res = new int[n];
        
        for (int[] v : updates){
            int s = v[0];
            int e = v[1];
            int val = v[2];
            
            res[s] += val;
            if (e+1 < n){
                res[e+1] += -val;
            }
        }
        
        for (int i = 1; i < n; i++){
            res[i] += res[i-1];
        }
        return res;
    }
}