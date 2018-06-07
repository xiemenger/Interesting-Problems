class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        int[] cnt = new int[m];
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 1; i < n; i++){
            nums[i] = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++){
                nums[i] = Math.min(nums[i], primes[j] * nums[cnt[j]]);
            }
            
            for (int j = 0; j < m; j++){
                if (nums[i] == primes[j] * nums[cnt[j]]){
                    cnt[j]++;
                }
            }
            
        }
        return nums[n - 1];
    }
}