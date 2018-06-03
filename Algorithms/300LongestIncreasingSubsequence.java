class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){ return 0; }
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        
        for (int num : nums){
            
            if (len == 0){
                dp[0] = num;
                len++;
                continue;
            } 
            //System.out.print(num+"  ");
            int pos = findInsertPos(dp, num, 0, len);
            dp[pos] = num;
            if (pos == len){
                len++;
            }
        }
        return len;
    }
    
    public int findInsertPos(int[] a, int val, int s, int e){
        
        int l = s;
        int r = e;
        while (l < r){
            int m = (l + r) / 2;
            if (val == a[m]){
                return m;
            } else if (val > a[m]){
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}