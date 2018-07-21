class Solution {
    public void sortColors(int[] nums) {
        int redIdx = 0;
        int blueIdx = nums.length - 1;
        int i = 0;
        while(i <= blueIdx){
            if (nums[i] == 0){
                swap(nums, i, redIdx);
                redIdx++;
                i++;
            } else if (nums[i] == 2){
                swap(nums, i, blueIdx);
                blueIdx--;
            } else {
                i++;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}