/**
 * 
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinate(candidates, target, 0, res, new ArrayList<>());
        return res;
    }
    
    private void combinate(int[] cand, int target, int pos, List<List<Integer>> res, List<Integer> path){
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0){
            return;
        }
        
        for (int i = pos; i < cand.length; i++){
            path.add(cand[i]);
            combinate(cand, target - cand[i], i, res, path);
            path.remove(path.size() - 1);
        }
    }
    
    
}