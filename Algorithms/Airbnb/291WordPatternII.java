class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        return isMatch(str, 0, pattern, 0, new HashMap<>(), new HashSet<>());
    }
    
    private boolean isMatch(String str, int sIdx, String pat, int pIdx, 
                            Map<Character, String> pairs, Set<String> used){
        if (sIdx == str.length() && pIdx == pat.length()){
            return true;
        }
        if (sIdx == str.length() || pIdx == pat.length()){
            return false;
        }
        
        char c = pat.charAt(pIdx);
        if (pairs.containsKey(c)){
            String p = pairs.get(c);
            if(!str.startsWith(p, sIdx)){
                return false;
            }
            return isMatch(str, sIdx + p.length(), pat, pIdx+1, pairs, used);
        } else {
            for (int i = sIdx; i < str.length(); i++){
                String p = str.substring(sIdx, i+1);
                if (used.contains(p)){
                    continue;
                }
                
                pairs.put(c, p);
                used.add(p);
                if (isMatch(str, i+1, pat, pIdx+1, pairs, used)){
                    return true;
                }
                pairs.remove(c);
                used.remove(p);
            }
        }
        return false;
    }
}