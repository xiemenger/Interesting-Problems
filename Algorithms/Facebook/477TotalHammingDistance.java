class Solution {
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        int count = 0;
        int val = 1;
        int n = nums.length;
        for (int i = 0; i < 32; i++){ 
            for (int num : nums){
                if ((num&val) == val){
                    count++;
                }
            }
            sum += count * (n - count);
            count = 0;
            val <<= 1;
        }
        return sum;
    }
}