class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        
        for (int i = 1; i <= n; i++){
            if (sum[i - 1] == sum[n] - sum[i]){
                return i - 1;
            }
        }
        return -1;
    }
}