class Solution {
    
    public boolean canWin(String s) {
        Map<String, Boolean> map = new HashMap<>();
        return track(s, map);
       
    }
    
    public boolean track(String s, Map<String, Boolean> map){
        if (s.length() == 0){
            return false;
        }
        if (map.containsKey(s)){
            return map.get(s);
        }
        int n = s.length();
        for (int i = 0; i < n; i++){
            if (s.startsWith("++", i)){
                String t = s.substring(0,i)+"--"+s.substring(i+2);
                if (!track(t, map)){
                    map.put(s, true);
                    return true;
                }
            }
        }  
        map.put(s, false);
        return false;
    }
}