class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        int n = 1;
        while (!s.isEmpty()){
            res = res + (s.charAt(s.length() - 1) - 'A' + 1) * n;
            s = s.substring(0, s.length() - 1);
            n *= 26;
        }
        return res;
    }
}