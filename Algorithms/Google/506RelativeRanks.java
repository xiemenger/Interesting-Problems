class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        String[] res = new String[n];
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++){
            indexes[i] = i;
        }
        
        Arrays.sort(indexes, (a, b) -> (nums[b] - nums[a]));
        
        for (int i = 0; i < n; i++){
             if (i == 0){
                res[indexes[i]] = "Gold Medal";
            } else if (i == 1){
                res[indexes[i]] = "Silver Medal";
            } else if (i == 2){
                res[indexes[i]] = "Bronze Medal";
            } else {
                res[indexes[i]] = ""+(i+1);
             }
            
        }
        
        return res;
    }
}