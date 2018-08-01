class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.isEmpty() || s.length() < p.length()){
            return res;
        }
        
        Map<Character, Integer> freq = new HashMap<>();
        int counter = p.length();
        int wz = p.length();
        for (char c : p.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        int l = 0;
        for (int r = 0; r < s.length(); r++){
            char cur = s.charAt(r);
            
            if(freq.containsKey(cur)){
                freq.put(cur, freq.get(cur) - 1);
                if (freq.get(cur) >= 0){
                    counter--;
                }
            }
            
            if (r - l + 1 > wz){
                char left = s.charAt(l);
                if (freq.containsKey(left)){
                    freq.put(left, freq.get(left) + 1);
                    if (freq.get(left) > 0){
                    counter++;
                    }
                }
                l++;
            }
            
            if (counter == 0){
                res.add(l);
            }
        }
        return res;
        
    }
}