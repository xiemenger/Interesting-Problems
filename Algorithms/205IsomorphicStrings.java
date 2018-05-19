class Solution {
    
    public boolean isIsomorphic(String s, String t) {
        if (s == null){
            return t == null;
        }
        
        if (t == null || s.length() != t.length()){
            return false;
        }
        int n = s.length();
        int[] s1 = new int[256];
        int[] t1 = new int[256];
        for (int i = 0; i < n; i++){
            if (s1[s.charAt(i)] != t1[t.charAt(i)]){
                return false;
            }
            
            s1[s.charAt(i)] = i + 1;
            t1[t.charAt(i)] = i + 1;
        }
        return true;
    }
    
    public boolean isIsomorphic2(String s, String t) {
        if (s == null){
            return t == null;
        }
        
        if (t == null || s.length() != t.length()){
            return false;
        }
        
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            if (map.containsKey(schar)){
                if (map.get(schar) != tchar){
                    return false;
                }
            } else {
                if (map.containsValue(tchar)){
                    return false;
                } else {
                    map.put(schar, tchar);
                }
            }
        }
        return true;
    }
}