class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int s = 0;
        int e = 0;
        int t = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++){
            s = i + 1;
            e = nums.length - 1;
            t = target - nums[i];
            while (s < e){
                if (nums[s] + nums[e] < t){
                    count += e - s;
                    s++;
                } else {
                    e--;
                }
            }
        }
        return count;
    }
}