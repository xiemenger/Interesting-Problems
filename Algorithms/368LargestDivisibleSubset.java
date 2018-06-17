class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        int max = 0;
        int idx = 0;
        
        for (int i = 0; i < n; i++){
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--){
                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0){
                    if (count[j] + 1 > count[i]){
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            
            if (count[i] > max){
                max = count[i];
                idx = i;
            }
        }
        
        while (idx != -1){
            res.add(nums[idx]);
            idx = pre[idx];
        }
        
        return res;
    }
}