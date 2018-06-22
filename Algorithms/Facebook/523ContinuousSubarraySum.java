class Solution {
    // O(n), O(n)
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            int l = sum;
            if (k != 0){
                 l = sum % k;
            } 
            
            if (map.containsKey(l)){
                if (i - map.get(l) > 1){
                    return true;
                }
            } else {
                map.put(l, i);
            }
        }
        return false;
    }
    
    
    // O(n^2), O(n);
    public boolean checkSubarraySum2(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        sums[1] = nums[0];
        for (int i = 2; i <= n; i++){
            sums[i] = sums[i - 1] + nums[i - 1];
            for (int j = i - 2; j >= 0; j--){
                int sum = sums[i] - sums[j];
                if (sum == k || (k != 0 && sum % k == 0)){
                    return true;
                }
            }
            
        }
        return false;
    }
}