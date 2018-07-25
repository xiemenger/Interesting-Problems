class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0){
            return 0;
        }
        if (divisor == 0){
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ){
            sign = -1;
        }
        
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        long lans = dividebyAdd(ldividend, ldivisor);
        
        int ans = 0;
        if (lans > Integer.MAX_VALUE){
            ans = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int)(sign * lans);
        }
        return ans;
        
    }
    
    private long dividebyAdd(long dividend, long divisor){
        if (dividend < divisor){
            return 0;
        }
        long sum = divisor;
        long mutiple = 1;
        while (sum + sum <= dividend){
            sum += sum;
            mutiple += mutiple;
        }
        return mutiple + dividebyAdd(dividend - sum, divisor);
    }
}