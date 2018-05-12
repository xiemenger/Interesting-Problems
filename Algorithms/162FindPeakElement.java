class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            int mid1 = (l + r) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2]){
                l = mid2;
            } else {
                r = mid1;
            }
        }
        return l;
    }
}