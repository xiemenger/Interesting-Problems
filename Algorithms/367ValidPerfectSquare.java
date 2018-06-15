class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1;
        long r = num / 2 + 1;
        while (l <= r){
            long m = (l + r) >>> 1 ;
            if (m*m == num){
                return true;
            } else if (m * m < num){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}