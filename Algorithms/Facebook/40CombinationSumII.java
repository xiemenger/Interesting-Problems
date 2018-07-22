class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        combinate(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
    
    private void combinate(int[] cand, int pos, int target, List<Integer> list, List<List<Integer>> res){
        //System.out.println("pos:"+pos+"  target:"+target);
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        
        if (target < 0 || pos == cand.length){
            return;
        }
        for (int i = pos; i < cand.length; i++){
            if (i > pos && cand[i] == cand[i - 1]){ continue; } // skip duplicates.
            list.add(cand[i]);
            combinate(cand, i + 1, target - cand[i], list, res);
            list.remove(list.size() - 1);
        }
    }
}