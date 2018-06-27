class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        int[] leftPos = new int[n];
        int[] rightPos = new int[n];
        int[] res = new int[3];
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            sum[i + 1] = sum[i] + nums[i];
        }
        
        for (int l = k, tot = sum[k]; l < n; l++){
            if (sum[l + 1] - sum[l + 1 - k] > tot){
                leftPos[l] = l + 1 - k;
                tot = sum[l + 1] - sum[l + 1 - k];
            } else {
                leftPos[l] = leftPos[l - 1];
            }
        }
        
        rightPos[n - k] = n - k;
        for (int r = n - k - 1, tot = sum[n] - sum[n - k]; r >= 0; r--){
            if (sum[r + k] - sum[r] >= tot){
                rightPos[r] = r;
                tot = sum[r + k] - sum[r];
            } else {
                rightPos[r] = rightPos[r + 1];
            }
        }
        
        for (int i = k; i <= n - 2 * k; i++){
            int l = leftPos[i - 1];
            int r = rightPos[i + k];
            int total = sum[i + k] - sum[i] 
                        + sum[l + k] - sum[l]
                        + sum[r + k] - sum[r];
            if (total > maxSum){
                maxSum = total;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;
    }
}