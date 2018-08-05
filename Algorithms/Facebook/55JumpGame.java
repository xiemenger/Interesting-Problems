class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length && reach <= nums.length - 1 && i <= reach; i++){
            reach = Math.max(reach, i + nums[i]);
        }
        return reach >= nums.length - 1;
    }
}