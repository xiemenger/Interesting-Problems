class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        int n = nums.length;
        int s = 0;
        int e = 0;
        
        for (int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1] + 1){
                e = i;
            } else {
                 if (s == e){
                    res.add(String.valueOf(nums[s]));
                 } else {
                    res.add(nums[s]+"->"+nums[e]);
                 }
                s = i;
                e = i;
            }
               
        }
        
        if (s == e){
            res.add(String.valueOf(nums[s]));
        } else {
            res.add(nums[s]+"->"+nums[e]);
        }
        return res;   
    }
}