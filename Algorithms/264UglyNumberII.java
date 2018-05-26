class Solution {
    public int nthUglyNumber(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for (int i = 1; i < n; i++){
            int num2 = uglyNums[i2] * 2;
            int num3 = uglyNums[i3] * 3;
            int num5 = uglyNums[i5] * 5 ;
            uglyNums[i] = Math.min(Math.min(num2, num3), num5);
            if (uglyNums[i] == num2){ i2++; }
            if (uglyNums[i] == num3){ i3++; }
            if (uglyNums[i] == num5){ i5++; }
        }
        return uglyNums[n - 1];
    }
}