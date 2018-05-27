class Solution {
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        int s = 0;
        int e = num.length() - 1;
        while (s < e){
            if (num.charAt(s) != num.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}