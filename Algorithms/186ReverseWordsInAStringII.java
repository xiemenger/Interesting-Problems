class Solution {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        for (int s = 0, e = 0; e <= str.length; e++){
            if (e == str.length || str[e] == ' '){
                reverse(str, s, e - 1);
                s = e + 1;
            }
        }
    }
    
    public void reverse(char[] str, int s, int e){
        while (s < e){
            char tmp = str[s];
            str[s] = str[e];
            str[e] = tmp;
            
            s++;
            e--;
        }
    }
}