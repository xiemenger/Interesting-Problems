class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num:nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        for(Integer num: freqMap.keySet()){
            int freq = freqMap.get(num);
            if (bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        
        for (int i = nums.length; i >= 0 && res.size() < k; i--){
            if (bucket[i] != null){
                for (int j = 0; j < bucket[i].size() && res.size() < k; j++){
                    res.add(bucket[i].get(j));
                }
            }
        }
        return res;
    }
}