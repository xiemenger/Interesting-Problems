class Solution {
    // find common prefix of m and n in bit code
    public int rangeBitwiseAnd(int m, int n) {
        int moveSteps = 1;
        while (m != n){
            m >>= 1;
            n >>= 1;
            moveSteps <<= 1;
        }
        return m * moveSteps;
    }
}