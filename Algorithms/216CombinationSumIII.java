class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0){
            return res;
        }
        
        search(k, n, 1, new ArrayList<>(), res);
        return res;
    }
    
    public void search(int num, int amount, int idx, List<Integer> list, List<List<Integer>> res){
         System.out.println("num="+num+"  amount="+amount+" idx="+idx);
        if (num == 0 && amount == 0){
            System.out.println("   add into res");
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = idx; i <= 9; i++){
            if (num - 1 < 0 || amount - i < 0){ continue; }
            
            list.add(i);
            search(num - 1, amount - i, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}