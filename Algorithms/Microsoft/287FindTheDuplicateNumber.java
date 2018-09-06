class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length){
            while (nums[i] != i + 1){
                int nextIdx = nums[i] - 1;
                if (nextIdx == nums[nextIdx] - 1){
                    return nums[i];
                }
                swap(nums, i, nextIdx);
            }
             i++;
        }
        return -1;
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        
    }
}