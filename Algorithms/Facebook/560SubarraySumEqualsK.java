class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        int sum = 0;
        for (int r = 0; r < nums.length; r++){
            sum += nums[r]; 
            if (sums.containsKey(sum - k)){
                cnt += sums.get(sum - k);
            }
            sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}