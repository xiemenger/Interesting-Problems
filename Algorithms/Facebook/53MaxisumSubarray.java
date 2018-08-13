class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] maxSum = new int[n];
        int max = nums[0];
        maxSum[0] = nums[0];
        for (int i = 1; i < n; i++){
            maxSum[i] = nums[i] + Math.max(0, maxSum[i - 1]);
            max = Math.max(max, maxSum[i]);
        }
        return max;
    }
}