class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0){
            return false;
        }
        
        Map<Long, Long> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++){
            long newNum = (long)nums[i] - Integer.MIN_VALUE;
            long bucketIdx = newNum / ((long)t + 1);
            if (map.containsKey(bucketIdx)
               || (map.containsKey(bucketIdx - 1) && Math.abs(map.get(bucketIdx - 1) - newNum) <= t)
                || (map.containsKey(bucketIdx + 1) && Math.abs(map.get(bucketIdx + 1) - newNum) <= t)){
                return true;
            }
            if (map.size() >= k){
                long lastBucket = ((long)nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1);
                map.remove(lastBucket);
            }
            map.put(bucketIdx, newNum);
        }
        return false;
    }
}