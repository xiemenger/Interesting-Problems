class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        int l = 0;
        int h = nums.length;
        while (l < h){
            int m = (l + h) / 2;
            if (nums[m] == target){
                return m;
            }else if (nums[m] > target){
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}