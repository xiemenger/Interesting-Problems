class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words == null || words.length == 0 || s.length() < words.length * words[0].length()){
            return res;
        }
        
        Map<String, Integer> map = new HashMap<>();
        
        int n = s.length();
        int m = words.length; 
        int swl = words[0].length();
        for (int i = 0; i < m; i++){
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        
        for (int i = 0; i < swl; i++){
            Map<String, Integer> haveSeen = new HashMap<>();
            int count = 0;
            int l = i;
            for (int r = i; r + swl <= n ; r += swl){
                String word = s.substring(r, r + swl);
                if (!map.containsKey(word)){
                    haveSeen.clear();
                    count = 0;
                    l = r + swl;
                } else {
                    haveSeen.put(word, haveSeen.getOrDefault(word, 0) + 1);
                    if (haveSeen.get(word) <= map.get(word)){
                        count++;
                    }
                    
                    while (l <= r && haveSeen.get(word) > map.get(word)){
                        String delWord = s.substring(l, l + swl);
                        haveSeen.put(delWord, haveSeen.get(delWord) - 1);
                        l += swl;
                        if (haveSeen.get(delWord) < map.get(delWord)){
                            count--;
                        }
                    }
                    
                    if (count == m){
                        res.add(l);
                        String delWord = s.substring(l, l + swl);
                        haveSeen.put(delWord, haveSeen.get(delWord) - 1);
                        l += swl;
                        count--;
                    }
                }
            }
            
        }
        return res;
    }
}