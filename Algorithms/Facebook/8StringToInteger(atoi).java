class Solution {
    public int myAtoi(String str) {
        if (str.isEmpty()){ return 0; }
        int idx = 0;
        int n = str.length();
        int num = 0;
        int maxNum = Integer.MAX_VALUE;
        int sign = 1;
        while (idx < n && str.charAt(idx) == ' '){ idx++; } // skip space
        if (idx < n && (str.charAt(idx) == '+' || str.charAt(idx) == '-')){
            sign = str.charAt(idx++) == '+' ? 1 : -1;
        }
        
        while (idx < n && Character.isDigit(str.charAt(idx))){
            if (num > maxNum / 10 || (num == maxNum / 10 && str.charAt(idx) - '0' > maxNum % 10)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + str.charAt(idx) - '0';
            idx++;
        }
        return sign * num;
    }
}