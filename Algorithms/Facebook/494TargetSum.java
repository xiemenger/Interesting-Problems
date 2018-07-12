class Solution {
    
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        
        if (sum < S || ((sum + S) & 1) == 1){
            return 0;
        }
        
        return findTarget(nums, ((sum + S) >>> 1));
    }
    
    private int findTarget(int[] nums, int t){
        int n = nums.length;
        int[] dp = new int[t + 1];
        dp[0] = 1;
        for (int num : nums){
            for (int j = t; j >= num; j--){
                dp[j] += dp[j - num];
            }
        }
        return dp[t];
    }
    
    // recursive with memory
    public int findTargetSumWays2(int[] nums, int S) {
        return backtrack(nums, 0, 0, S, new HashMap<>());
    }
    
    private int backtrack(int[] nums, int idx, int curSum, int S, Map<String, Integer> map){
        if (idx == nums.length ){
            if (curSum == S){
                return 1;
            }
            return 0;
        }
    
        String str = idx+"->"+curSum;
        if (map.containsKey(str)){
            return map.get(str);
        }
        
        int count = backtrack(nums, idx+1, curSum - nums[idx], S, map) 
                    + backtrack(nums, idx+1, curSum + nums[idx], S, map);
        map.put(str, count);
        return count;
    }
}