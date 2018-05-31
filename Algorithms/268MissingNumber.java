class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++){
            while (nums[i] >= 0 && nums[i] < n && nums[i] != nums[nums[i]]){
                swap(nums, i, nums[i]);
            }
        }
        for (int i = 0; i < n; i++){
            if (i != nums[i]){
                return i;
            }
        }
        return n;
    }
    
    public void swap(int[] nums, int i , int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}