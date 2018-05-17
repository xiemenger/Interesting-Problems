class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[] amount = new int[nums.length + 1];
        amount[0] = 0;
        amount[1] = nums[0];
        for (int i = 2; i <= nums.length; i++){
            amount[i] = Math.max(nums[i - 1] + amount[i - 2], amount[i - 1]);
        }
        return amount[nums.length];
    }
}