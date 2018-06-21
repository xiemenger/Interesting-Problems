class Solution {

    public int splitArray(int[] nums, int m) {
        long l = 0;
        long r = 0;
        long ans = Integer.MAX_VALUE;
        for (int num : nums){
            r += num;
            l = Math.max(l, num);
        }
        
        while (l <= r){
            long mid = (l + r) >> 1;
            if (valid(nums, m, mid)){
                ans = Math.min(mid, ans);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)ans;
    }
    
    private boolean valid(int[] nums, int m, long mid){
        int count = 1;
        long sum = 0;
        for (int num : nums){
            if (sum + num <= mid){
                sum += num;
            } else {
                sum = num;
                count++;
                if (count > m){
                    break;
                }
            }  
        }
        return count > m ? false : true;
    }
    
}