class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        int[] cnt = new int[n];
        int maxLen = 0;
        int res = 0;
        
        for (int i = 0; i < n; i++){
            len[i] = 1;
            cnt[i] = 1;
            
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    if (len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (len[i] == len[j] + 1){
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (maxLen == len[i]){
                res += cnt[i];
            } else if (maxLen < len[i]){
                maxLen = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}