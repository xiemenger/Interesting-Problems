class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        SearchFactors(n, 2, res, new ArrayList<>(), (int)Math.sqrt(n));
        return res;
    }
    
    public void SearchFactors(int n, int start, List<List<Integer>> res, List<Integer> list, int upper){
        System.out.println("n:"+n+"  start:"+start+"  upper:"+upper);
        if (n < 2){
            if (list.size() > 1){
                System.out.println("  add result  ");
                res.add(new ArrayList<>(list));
            }
            return;
        }
        
        for (int i = start; i <= n; i++){
            if (i > upper){
                i = n;
            }
            if (n % i == 0){
                list.add(i);
                System.out.print("  add i="+i+"   ");
                SearchFactors(n / i, i, res, list, (int)Math.sqrt(n / i));
                list.remove(list.size() - 1);
            }
        }
    }
}