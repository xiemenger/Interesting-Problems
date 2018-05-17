class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = digitsquare(slow);
            fast = digitsquare(fast);
            fast = digitsquare(fast);
            if (fast == 1){
                return true;
            }
        } while (fast != slow);
        return false;
    }
    
    public int digitsquare(int n){
        int sum = 0;
        int tmp = 0;
        while (n != 0){
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }
}