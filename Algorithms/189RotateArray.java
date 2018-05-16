class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        rotateHelper(nums, 0, nums.length - 1);
        rotateHelper(nums, 0, k - 1);
        rotateHelper(nums, k, nums.length - 1);
    }
    
    public void rotateHelper(int[] nums, int s, int e){
        while(s < e){
            int tmp = nums[s];
            nums[s] = nums[e];
            nums[e] = tmp;
            s++;
            e--;
        }
    }
}