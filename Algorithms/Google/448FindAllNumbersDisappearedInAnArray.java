class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            while (i < n && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]){
                swap(nums, i, nums[i] - 1);
            }
        }
        
        for (int i = 0; i < n; i++){
            if (nums[i] != i + 1){
                res.add(i + 1);
            }
        }
        return res;
    }
    
    private void swap(int[] nums, int i , int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}