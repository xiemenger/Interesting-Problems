class Solution {
    public int addDigits(int num) {
        int newNum = num;
        int sum = num;
        
        while (newNum > 9){
            sum = 0;
            while (newNum > 0){
                sum += newNum % 10;
                newNum /= 10;
            }
            newNum = sum;
        }
        return sum;
    }
}