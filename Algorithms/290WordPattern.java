class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()){
            return false;
        }
        
        Map<Character, String> strmap = new HashMap<>();
        Map<String, Character> idxmap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if (!strmap.containsKey(c) && !idxmap.containsKey(strs[i])){
                strmap.put(c, strs[i]);
                idxmap.put(strs[i], c);
                //System.out.println("put:"+c+"  "+strs[i]);
            } else {
                // same character matches different words.
                if (strmap.containsKey(c) && !strmap.get(c).equals(strs[i])){
                    return false;
                }
                // differet characters match same word.
                if (idxmap.containsKey(strs[i]) && idxmap.get(strs[i]) != c){
                    return false;
                }
            }
        }
        return true;
    }
}