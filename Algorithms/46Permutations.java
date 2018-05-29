class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        permutation(nums, res, new ArrayList<>(), set);
        return res;
    }
    
    public void permutation(int[] nums, List<List<Integer>> res, List<Integer> list, Set<Integer> set){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++){
            if (set.contains(nums[i])){ continue; }
            list.add(nums[i]);
            set.add(nums[i]);
            permutation(nums, res, list, set);
            list.remove(list.size() - 1);
            set.remove(nums[i]);
        }
    }
}