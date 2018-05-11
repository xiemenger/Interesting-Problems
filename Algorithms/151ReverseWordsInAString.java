public class Solution {
    public String reverseWords(String s) {
        s = cleanSpaces(s);
        char[] str = s.toCharArray();
        reverseString(str, 0, str.length - 1);
        int i = 0; 
        int j = 0;
        int n = str.length;
        while (j < n){
            while (j < n && str[j] != ' '){ j++; }
            reverseString(str, i, j - 1);
            j++;
            i = j;
        }
        return new String(str);
    }
    
    public void reverseString(char[] str, int s, int e){
        System.out.println("s="+s+"  e="+e);
        while (s < e){
            char tmp = str[s];
            str[s] = str[e];
            str[e] = tmp;
            
            s++;
            e--;
        }
    }
    
    public String cleanSpaces(String s){
        char[] str = s.toCharArray();
        int n = str.length;
        int i = 0; 
        int j = 0;
        while (j < n){
            while (j < n && str[j] == ' '){ j++; }
            while (j < n && str[j] != ' '){ str[i++] = str[j++]; }
            while (j < n && str[j] == ' '){ j++; }
            if (j < n){
                str[i++] = ' ';
            }
        }
         return new String(str).substring(0, i);
    }
    
    
}