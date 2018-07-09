class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Long> map = new HashMap<>();
        for (int[] trans : transactions){
            map.put(trans[0], map.getOrDefault(trans[0], 0L) + trans[2]);
            map.put(trans[1], map.getOrDefault(trans[1], 0L) - trans[2]);
        }
        
        List<Long> list = new ArrayList<>();
        for (Long val : map.values()){
            if (val != 0){
                list.add(val);
            }
        }
        
        Long[] debts = new Long[list.size()];
        debts = list.toArray(debts);
        return dfs(debts, 0, 0);
    }
    
    private int dfs(Long[] debts, int count, int pos){
        int res = Integer.MAX_VALUE;
        while (pos < debts.length && debts[pos] == 0){
            pos++;
        }
        
        if (pos >= debts.length){
            return count;
        }
        for (int i = pos + 1; i < debts.length; i++){
            if (debts[i] != 0 && debts[i] * debts[pos] < 0){
                debts[i] += debts[pos];
                res = Math.min(res, dfs(debts, count+1, pos+1));
                debts[i] -= debts[pos];
            }
        }
        return res;
    }
}