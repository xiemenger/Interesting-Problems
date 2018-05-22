class Solution {
    public boolean isPowerOfTwo(int n) {
        int count1 = 0;
        while (n > 0){
            count1 += n & 1;
            if (count1 > 1){
                return false;
            }
            n >>= 1;
        }
        return count1 == 1;
    }
}