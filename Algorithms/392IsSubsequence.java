class Solution {
    
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] charIdxs = new List[256];
        int m = s.length();
        int n = t.length();
        for (int i = 0; i < n; i++){
            if(charIdxs[t.charAt(i)] == null){
                charIdxs[t.charAt(i)] = new ArrayList<>();
            }
            charIdxs[t.charAt(i)].add(i);
        }
        
        int prev = 0;
        for (int i = 0; i < m; i++){
            if (charIdxs[s.charAt(i)] == null){
                return false;
            }
            
            int idx = Collections.binarySearch(charIdxs[s.charAt(i)], prev);
            if (idx < 0){
                idx = -(idx + 1);
            }
            if (idx == charIdxs[s.charAt(i)].size()){
                return false;
            }
            prev = charIdxs[s.charAt(i)].get(idx) + 1;
        }
        return true;
    }
    
    
    public boolean isSubsequence2(String s, String t) {
        if (s.isEmpty()){ return true; }
        if (t.length() < s.length()){ return false; }
        int m = s.length();
        int n = t.length();
        int sIdx = 0;
        int tIdx = 0;
        
        while (tIdx < n){
            if (t.charAt(tIdx) == s.charAt(sIdx)){
                sIdx++;
            }
            if (sIdx == m){
                return true;
            }
            tIdx++;
        }
        return false;
    }
}