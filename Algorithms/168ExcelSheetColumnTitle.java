class Solution {
    public String convertToTitle(int n) {
        String res = "";
        while (n > 0){
            n--;
            char remain = (char)('A' + (n % 26));
            res = remain + res;
            n = n / 26;
        }
        return res;
    }
}