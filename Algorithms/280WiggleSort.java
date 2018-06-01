class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2){
            return;
        }
        int n = nums.length;
        for (int i = 1; i < n; i += 2){
            if (i == n - 1){
                if (nums[i] < nums[i - 1]){
                    swap(nums, i, i - 1);
                }
                continue;
            }
            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]){
                swap(nums, i, nums[i-1] > nums[i+1] ? i-1 : i+1);
            } else if (nums[i] < nums[i - 1]){
                swap(nums, i, i-1);
            } else if (nums[i] < nums[i + 1]){
                swap(nums, i, i+1);
            }
        }
    }
    
    public void swap(int[] nums, int i , int j){
        //System.out.println("swap : "+i+"  "+j);
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}