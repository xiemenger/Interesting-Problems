class Solution {
    public int maxProfit(int[] prices) {
        int T_i0 = 0;
        int T_i1 = Integer.MIN_VALUE;
        
        for (int price : prices){
            int tmp = T_i0;
            T_i0 = Math.max(T_i0, T_i1 + price);
            T_i1 = Math.max(T_i1, tmp - price);
        }
        return T_i0;
    }
}