class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        String vowels = "aeuioAEUIO";
        int i = 0;
        int j = n - 1;
        while (i < j){
            while(i < j && vowels.indexOf(str[i]) < 0){
                i++;
            }
            while (i < j && vowels.indexOf(str[j]) < 0){
                j--;
            }
            swap(str, i, j);
            i++;
            j--;
        }
        return new String(str);
    }
    
    public void swap(char[] s, int i, int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}