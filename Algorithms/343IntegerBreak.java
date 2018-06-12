class Solution {
    public int integerBreak(int n) {
        if (n == 1 || n == 2){
            return 1;
        } else if (n == 3){
            return 2;
        } else if (n % 3 == 0){
            return (int)Math.pow(3, n/3);
        } else if (n % 3 == 1){
            return 4 * (int)Math.pow(3, (n-4) / 3);
        } else {
            return 2 * (int)Math.pow(3, (n-2) / 3);
        }
    }
    
    public int integerBreak2(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return backtrack(n,map);
    }

    public int backtrack(int n, Map<Integer, Integer> map){
        if (map.containsKey(n)){ return map.get(n); }
        int curmax = 1;
        for (int i = 1; i < n; i++){
            curmax = Math.max(curmax, i*(n - i));
            curmax = Math.max(curmax, i * backtrack(n - i, map));
            
        }
        map.put(n, curmax);
        return curmax;
    }
}