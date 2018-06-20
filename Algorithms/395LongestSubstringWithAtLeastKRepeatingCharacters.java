class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n == 0 || n < k || k < 0){
            return 0;
        }
        if (k == 1){
            return n;
        }
        
        int max = 0;
        int[] counts = new int[26];
        
        for (int i = 0; i < s.length(); i++){
            counts[s.charAt(i) - 'a']++;
        }  
        
        char badchar = 0;
        for (int i = 0; i < 26; i++){
            if (counts[i] > 0 && counts[i] < k){
                badchar = (char)(i+'a');
                break;
            }
        }
        
        if (badchar == 0){ return n;}
        
        for (String str : s.split(badchar+"")){
            max = Math.max(max, longestSubstring(str, k));
        }
        return max;
    } 
}