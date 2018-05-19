class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        
        int n = nums.length;
        return Math.max(robSimpler(nums, 0, n - 2), robSimpler(nums, 1, n - 1));
    }
    
    public int robSimpler(int[] nums, int s, int e){
       
        int pre = nums[s];
        int prepre = 0;
        
        for (int i = s + 1; i <= e; i++){
            int tmp = pre;
            pre = Math.max(nums[i] + prepre, pre);
            prepre = tmp;
        }
        return Math.max(pre, prepre);
    }
}