class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        check(nums, 0, new ArrayList<>(), res);
        List result = new ArrayList<>(res);
        return result;
    }
    
    private void check(int[] nums, int pos, List<Integer> path, Set<List<Integer>> res){
        if (path.size() >= 2){
            res.add(new ArrayList<>(path));
        }
        
        for (int i = pos; i < nums.length; i++){
            if (path.size() == 0 || path.get(path.size() - 1) <= nums[i]){
                path.add(nums[i]);
                check(nums, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}