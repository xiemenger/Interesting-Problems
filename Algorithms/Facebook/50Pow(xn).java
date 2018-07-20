class Solution {
    public double myPow(double x, int n) {
        return fastPow(x, (long)n );
    }
    
    private double fastPow(double x, long n){
        if (n == 0){
            return 1.0;
        }
        if (n < 0){
            x = 1 / x;
            n = -n;
        }
        return n % 2 == 0 ? fastPow(x * x, n / 2) : x * fastPow(x * x, n / 2);
    }
    
}