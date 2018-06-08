class Solution {
    public List<Integer> countSmaller(int[] nums) {
        
        int n = nums.length;
        int[] tmp = new int[n];
        
        // get the sorted list without duplicate
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            set.add(nums[i]);
        }
        int[] sorted = new int[set.size()];
        int k = 0;
        for (int num : set){
            sorted[k++] = num;
        }
        Arrays.sort(sorted);
        
        // Build rank after sorting
        Map<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < sorted.length; i++){
            rank.put(sorted[i], i+1);
        }
        
        // Binary Idexed Tree to compute sum
        int[] BIT = new int[sorted.length + 1];
        int[] freq = new int[sorted.length + 1];
        for (int i = n - 1; i >= 0; i--){
            int r = rank.get(nums[i]);
            tmp[i] = getSum(BIT,r-1);
            update(freq, r, 1, BIT);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < tmp.length; i++){
            res.add(tmp[i]);
        }
        return res;
        
    }
    
    public void update(int[] freq, int idx, int diff, int[] BIT){
        freq[idx] += diff;
        for (int i = idx; i < BIT.length; i += i & -i){
            BIT[i] += diff;
        }
    }
    
    public int getSum(int[] BIT, int idx){
        int sum = 0;
        for(int i = idx; i > 0; i -= i & -i){
            sum += BIT[i];
        }
        return sum;
    }
}