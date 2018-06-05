class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n/2; i++){
            for (int j = 1; Math.max(i, j) <= n - i - j; j++){
                if (isValid(i, j, num)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isValid(int i, int j, String num){
        if (num.charAt(0) == '0' && i > 1){ return false; }
        if (num.charAt(i) == '0' && j > 1){ return false; }
        Long num1 = Long.parseLong(num.substring(0, i));
        Long num2 = Long.parseLong(num.substring(i, i+j));
        String sum;
        for (int k = i+j; k < num.length(); k += sum.length()){
            num2 = num1 + num2;
            num1 = num2 - num1;
            sum = num2.toString();
            System.out.println(num1+"   "+num2);
            if (!num.startsWith(sum, k)){ return false; }
        }
        return true;
    }
}