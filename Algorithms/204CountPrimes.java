class Solution {
    public int countPrimes(int n) {
        if (n < 2){
            return 0;
        }
        int count = 0;
        boolean[] notprime = new boolean[n];
        notprime[0] = true;
        notprime[1] = true;
        for (int i = 2; i < Math.sqrt(n); i++){
            if (!notprime[i]){
                for (int j = 2; i * j < n; j++){
                    notprime[i * j] = true;
                }
            }
        }
        
        for (int i = 2; i < n; i++){
            if (!notprime[i]){
                count++;
            }
        }
        return count;
    }
}