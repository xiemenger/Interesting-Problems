class Solution {
    public void sortColors(int[] nums) {
        int zeroIdx = 0;
        int twoIdx = nums.length - 1;
        int i = 0; 
        while (i <= twoIdx){  // 注意这里要=
            if (nums[i] == 2){
                swap(nums, i, twoIdx--);
            } else if (nums[i] == 0){
                if (i != zeroIdx){
                    swap(nums, i, zeroIdx);
                }
                i++;
                zeroIdx++;
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