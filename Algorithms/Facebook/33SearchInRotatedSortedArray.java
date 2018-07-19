class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        
        // ind the minIdx
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        
        while (l < r){
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]){
                l = m + 1;
            } else {
                r = m;
            }
        }
        int minIdx = l;
        
        // fix the range 
        if (target == nums[minIdx]){
            return minIdx;
        }
        l = target <= nums[n - 1] ? minIdx : 0;
        r = target <= nums[n - 1] ? n - 1 : minIdx;
        
        // search target
        while (l <= r){
            int m = l + (r - l) / 2;
            if (target == nums[m]){
                return m;
            }
            if (target > nums[m]){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        return -1;
    }
}