class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return memoryDFS(s, wordDict, new HashMap<String, List<String>>());
    }
    
    public List<String> memoryDFS(String s, List<String> wordDict, Map<String, List<String>> map){
        if (map.containsKey(s)){
            return map.get(s);
        }
        
        List<String> res = new ArrayList<>();
        if(s.length() == 0){
            res.add("");
            return res;
        }
        
        for (String word : wordDict){
            if (s.startsWith(word)){
                List<String> matchedString = memoryDFS(s.substring(word.length()), wordDict, map);
                for (String sub : matchedString){
                    res.add(word + (sub.isEmpty()? "" : (" " + sub)));
                }
            }
        }
        map.put(s, res);
        return res;
    } 
}