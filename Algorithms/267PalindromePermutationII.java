class Solution {
    public List<String> generatePalindromes(String s) {
        int[] map = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++){
            map[s.charAt(i)]++;
        }
        
        int odd = 0;
        String mid = "";
        char[] st = new char[n / 2];
        int k = 0;
        for (int i = 0; i < map.length; i++){
            if (map[i] % 2 == 1){ 
                odd++;
                mid = (char)i + "";
            }
            for (int j = 0; j < map[i] / 2; j++){
                st[k++] = (char)i;
            }
        }
        
        if (odd > 1){ return new ArrayList<>(); } 
        
        List<String> res = new ArrayList<>();
        boolean[] used = new boolean[st.length];
        permute(st, res, mid, new StringBuilder(), used);
        
        return res;
        
    }
    
    public void permute(char[] s, List<String> res, String mid, StringBuilder sb, boolean[] used){
        if (sb.length() == s.length){
            System.out.println(sb.toString());
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }
        
        for (int i = 0; i < s.length; i++){
            if (used[i] || (i > 0 && s[i] == s[i - 1]  && !used[i - 1])){
                continue;
            }
            used[i] = true;
            sb.append(s[i]);
            permute(s, res, mid, sb, used);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
            //System.out.println("sb:"+sb.toString());
        }
        
    }
    
    public void permute2(char[] s, int l, Set<String> set, char oddChar){
        if (l == s.length){
            String str = new String(s);
            if (oddChar == 0){
                set.add(str + new StringBuilder(str).reverse().toString());
            } else {
                set.add(str + oddChar + new StringBuilder(str).reverse().toString());
            }
            
            return;
        }
        
        for (int i = l; i < s.length; i++){
            if (s[l] != s[i] || i == l){
                swap(s, l, i);
                permute2(s, l+1, set, oddChar);
                swap(s, l, i);
            }
        }
    }
    
    public void swap(char[] s, int i, int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}