class Solution {
    public int maxProfit(int[] prices) {
        int T_i0 = 0;
        int T_i1 = Integer.MIN_VALUE;
        
        for (int i = 0; i < prices.length; i++){
            T_i0 = Math.max(T_i0, T_i1 + prices[i]);
            T_i1 = Math.max(T_i1, -prices[i]);
        }
        
        return T_i0;
    }
}