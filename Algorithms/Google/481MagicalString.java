class Solution {
    public int magicalString(int n) {
        if (n < 1){ return 0; }
        if (n <= 3){ return 1; }
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 2;
        a[2] = 2;
        int h = 2;
        int t = 3; 
        int num = 1;
        int count = 1;
        while (t < n){
            for (int i = 0; i < a[h]; i++){
                a[t] = num;
                if (num == 1 && t < n){
                    count++;
                }
                t++;
            }
            h++;
            num ^= 3;
        }
        return count;
    }
}