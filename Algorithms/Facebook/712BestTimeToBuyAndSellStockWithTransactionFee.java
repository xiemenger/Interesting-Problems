class Solution {
    public int maxProfit(int[] prices, int fee) {
        int T_ik0 = 0;
        int T_ik1 = Integer.MIN_VALUE;
        
        for (int price : prices){
            int old_T_ik0 = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, old_T_ik0 - price - fee);
        }
        return T_ik0;
    }
}