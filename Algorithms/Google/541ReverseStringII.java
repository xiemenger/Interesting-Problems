class Solution {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i += 2 * k){
           swap(str, i, Math.min(n - 1, i + k - 1)); 
        }
        return new String(str);
    }
    
    private void swap(char[] str, int i , int j){
        while (i < j){
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;  
            i++;
            j--;
        }

    }
}