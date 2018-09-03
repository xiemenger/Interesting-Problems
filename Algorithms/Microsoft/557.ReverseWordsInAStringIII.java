class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int l = 0;
        int r = 0;
        while (i < chars.length){
            while (i < chars.length && chars[i] == ' '){i++; }
            l = i;
            while (i < chars.length && chars[i] != ' '){i++; }
            r = i - 1;
            rangeSwap(chars, l, r);
        }
        return new String(chars);
    }
    
    private void rangeSwap(char[] s, int i , int j){
        while (i < j){
            char tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }
    }
}