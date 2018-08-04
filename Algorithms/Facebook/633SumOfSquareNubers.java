class Solution {
    public boolean judgeSquareSum(int c) {
        int l = 0;
        int r = (int)Math.sqrt(c);
        while (l <= r){
            int cur = l * l + r * r;
            if (cur == c){
                return true;
            } else if (cur > c){
                r--;
            } else {
                l++;
            }
        }
        return false;
    }
}