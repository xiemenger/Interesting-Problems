class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            int s = i + 1;
            int e = nums.length - 1;
            int sum = 0;
            while (s < e){
                sum = nums[i] + nums[s] + nums[e];
                if (sum > target){
                    e--;
                } else {
                    s++;
                }
                if (Math.abs(res - target) > Math.abs(sum - target)){
                    res = sum;
                }
            }
        }
        return res;
    }
}