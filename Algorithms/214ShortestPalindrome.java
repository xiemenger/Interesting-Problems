class Solution {
    // Time O(n), Space: O(n);
    public String shortestPalindrome(String s) {
        String sRev = new StringBuilder(s).reverse().toString();
        String tmp = s + "#" + sRev;
        int[] lspTable = computeKMPLPS(tmp);
        int len = lspTable[lspTable.length - 1];
        return sRev.substring(0, s.length() - len) + s;
    }
    
    public int[] computeKMPLPS(String s){
        int n = s.length();
        int[] table = new int[n];
        table[0] = 0;
        
        int i = 1;
        int len = 0;
        while (i < n){
            if (s.charAt(i) == s.charAt(len)){
                len++;
                table[i] = len;
                i++;
            } else {
                if (len == 0){
                    table[i] = len;
                    i++;
                } else {
                    len = table[len - 1];
                }
            }
        }
        return table;
    }
}