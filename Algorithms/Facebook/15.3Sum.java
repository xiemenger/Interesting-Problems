class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 2){
            return res;
        }
        
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++){
            if (i > 0 && nums[i] == nums[i - 1]){ continue; }
            int l = i + 1;
            int r = n - 1;
            while (l < r){
                if (nums[l] + nums[r] == -nums[i]){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]){ l++; }
                    while (l < r && nums[r] == nums[r - 1]){ r--; }
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < -nums[i]){
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}