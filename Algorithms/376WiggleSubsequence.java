class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null){ return 0;}
        int n = nums.length;
        if (n < 2){ return n;}
        int pre = 1;
        int presign = 0;
        int cur = 0;
        int cursign = 0;
        for (int i = 1; i < n; i++){
            if (nums[i] > nums[i-1] && (presign == -1 || presign == 0)){
                cur = pre + 1;
                cursign = 1;
            } else if (nums[i] < nums[i - 1] && (presign == 1 || presign == 0)){
                cur = pre + 1;
                cursign = -1;
            } else {
                cur = pre;
                cursign = presign;
            }
            pre = cur;
            presign = cursign;
        }
        return pre;
    }
}