/**
 * To get the smallest num,  we scan the dights from left to right.
 * if the digits' value is climbing, that means we dont delete any 
 * digits so far, since we delete one, we will get a larget number.
 * 
 * Only if we see a number which is smaller than previous number, 
 * we can delete previous number to generate a larger number.
 * 
 */
class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length() - k;
        char[] digits = new char[num.length()];
        int top = 0;
        
        for (int i = 0; i < num.length(); i++){
            char cur = num.charAt(i);
            while (k > 0 && top > 0 && cur < digits[top - 1] ){
                top--;
                k--;
            }
            digits[top++] = cur;
        }
        
        top = 0;
        while (top < len && digits[top] == '0'){
            top++;
        }
        return top == len ? "0" : new String(digits, top, len-top);
    }
}