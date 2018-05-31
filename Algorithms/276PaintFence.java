class Solution {
    public int numWays(int n, int k) {
        if (n <= 0){ return 0; }
        if (n < 2){ return k; }
        int diff = k* (k - 1);
        int same = k;
        for (int i = 2; i < n; i++){
            int tmp = diff;
            diff = (diff + same) * (k - 1);
            same = tmp;   // same only when previous are diff;
        }
        return diff + same;
    }
}