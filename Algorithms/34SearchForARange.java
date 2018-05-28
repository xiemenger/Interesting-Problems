class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int lowBound = extremeInsertionIdx(nums, target, true);
        if (lowBound == nums.length || nums[lowBound] != target){
            return res;
        }
        res[0] = lowBound;
        res[1] = extremeInsertionIdx(nums, target, false) - 1;
        return res;
        
    }
    
    public int extremeInsertionIdx(int[] nums, int target, boolean leftBound){
        int l = 0;
        int h = nums.length;
        while (l < h){
            int mid = (l + h) / 2;
            if (nums[mid] > target || (leftBound && nums[mid] == target)){
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}