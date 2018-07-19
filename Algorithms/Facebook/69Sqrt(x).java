class Solution {
    public int mySqrt(int x) {
        int l = 1;
        int r = x;
        while (l <= r){
            int m = l + (r - l) / 2;
            if (m == x / m){
                return m;
            } 
            
            if (m > x / m){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}