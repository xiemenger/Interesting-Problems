class Solution {
    public String reverseString(String s) {
        int n = s.length();
        char[] chars = new char[n];
        int i = 0;
        int j = n - 1;
        while (i <= j){
            chars[i] = s.charAt(j);
            chars[j] = s.charAt(i);
            i++;
            j--;
        }
        return new String(chars);
    }
}