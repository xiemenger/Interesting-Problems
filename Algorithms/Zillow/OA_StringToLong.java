/**
 * 1) Given a string, write a routine that converts the string to a long, without using the 
built in functions that would do this. Describe what (if any) limitations the code has. For 
example:
long stringToLong(String s){
    code goes here to convert a string to a long 
}
void test(){ 
    long i = stringToLong("123");.本文原创自1point3acres论坛
    if (i == 123)
        // success
    else
        // failure
    }
 * 
 */
class Solution{
    public static long stringToLong(String s) {
        int sign = 1;
        long num = 0;
        int i = 0;
        while (i < s.length()) {
            char cur = s.charAt(i);
            if (i == 0 && (cur == '+' || cur == '-')){
                sign = cur == '-' ? -1 : 1;
            } else if (Character.isDigit(cur)) {
                if (num > Long.MAX_VALUE / 10) { return sign == 1 ? Long.MAX_VALUE: Long.MIN_VALUE; }
                if (sign == 1 && (num == Long.MAX_VALUE / 10) && cur >= Long.MAX_VALUE % 10) { return Long.MAX_VALUE; }
                if (sign == -1 && 
                    (num == Long.MAX_VALUE / 10) && cur >= Long.MAX_VALUE % 10 + 1) { 
                    return Long.MIN_VALUE; 
                }
                num = num * 10 + s.charAt(i) - '0';
            }
            i++;
        }
        return sign * num;
    }
}
