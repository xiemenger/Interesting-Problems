class Solution {
    // Time O(n * m), Space O(n) - p's length;  
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[] pre = new boolean[n + 1];
        
        pre[0] = true;
        for (int i = 1; i <= n; i++){
            if (p.charAt(i -1) != '*'){ break; }
            pre[i] = true;
        }
        
        for (int i = 1; i <= m; i++){
            char schar = s.charAt(i - 1);
            boolean[] cur = new boolean[n + 1];
            for (int j = 1; j <= n; j++){
                char pchar = p.charAt(j - 1);
                if (schar == pchar || pchar == '?'){
                    cur[j] = pre[j - 1];
                } else if (pchar == '*'){
                    cur[j] = pre[j - 1] || pre[j] || cur[j - 1];
                }
            }
            pre = cur;
        }
        return pre[n];
    }
}