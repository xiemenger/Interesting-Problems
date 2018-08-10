class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int l = 0, r = 0;
        int product = 1;
        int cnt = 0;
        while (l <= r && r <= n){
            if (r == n ){
                if (product >= k){
                    break;
                }
                cnt += r - l;
                l++;
            }
            
            product = product * nums[r];
            while (l <= r && product >= k ){
                cnt += r - l;
                product /= nums[l++];
            }
            r++;
        }
        return cnt;
    }
}