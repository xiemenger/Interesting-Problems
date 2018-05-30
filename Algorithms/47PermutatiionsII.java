class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, res, new ArrayList<>(), visited, "");
        return res;
    }
    
    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited, String tab){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++){
            
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && (!visited[i -1]))){
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            backtrack(nums, res, list, visited, tab+"\t");
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}