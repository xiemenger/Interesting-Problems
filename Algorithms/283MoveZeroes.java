class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        
        for (int i = 0, idx = 0; i < nums.length; i++){
            if (nums[i] != 0){
                swap(nums, i, idx);
                idx++;
            }
        }
        
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}