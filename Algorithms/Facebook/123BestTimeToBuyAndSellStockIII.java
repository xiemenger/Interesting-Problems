class Solution {
    public int maxProfit(int[] prices) {
        int T_i20 = 0;
        int T_i21 = Integer.MIN_VALUE;
        int T_i10 = 0;
        int T_i11 = Integer.MIN_VALUE;
        
        for (int price : prices){
            T_i20 = Math.max(T_i20, T_i21 + price);
            T_i21 = Math.max(T_i21, T_i10 - price);
            T_i10 = Math.max(T_i10, T_i11 + price);
            T_i11 = Math.max(T_i11, -price);
        }
        return T_i20;
    }
}