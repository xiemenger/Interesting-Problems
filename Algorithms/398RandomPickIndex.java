class Solution {
    int[] nums;
    java.util.Random rand;
    public Solution(int[] nums) {
        this.nums = nums;
        rand = new java.util.Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int idx = -1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target && rand.nextInt(++count) == 0){
               idx = i;
            }
        }
        return idx;
    }
}
