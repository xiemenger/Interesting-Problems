class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int carry = 0;
        while (l1 >= 0 || l2 >= 0){
            if (l1 >= 0){
                carry += num1.charAt(l1--) - '0';
            }
            if (l2 >= 0){
                carry += num2.charAt(l2--) - '0';
            }
            sb.append(carry % 10);
            carry /= 10;

        }
        if (carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}