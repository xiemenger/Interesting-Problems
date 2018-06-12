class Solution {
    public boolean isPowerOfFour(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++){
            if ((num & 1) == 1){
                count++;
                if (count > 1 || i % 2 == 1){ return false; }
            }
            num >>>= 1;
        }
        return count != 0;
    }
}