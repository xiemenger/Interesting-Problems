class Solution {
    public String alienOrder(String[] words) {
        String res = "";
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, Set<Character>> map = new HashMap<>();
        for (String word : words){
            for (int i = 0; i < word.length(); i++){
                if (!indegree.containsKey(word.charAt(i))){
                    indegree.put(word.charAt(i), 0);
                }
            }
        }
        
        BuildDirectGraph(words, map, indegree);
        Queue<Character> q = new LinkedList<>();
        for (Map.Entry<Character, Integer> e : indegree.entrySet()){
            if (e.getValue() == 0){
                q.offer(e.getKey());
            }
        }
        
        while(!q.isEmpty()){
            Character cur = q.poll();
            res += cur;
            if (!map.containsKey(cur)){ continue; }
            for (Character e : map.get(cur)){
                indegree.put(e, indegree.get(e) - 1);
                if(indegree.get(e) == 0){
                    q.offer(e);
                }
            }
        }
        return res.length() == indegree.size() ? res : "";
        
    }
    
    
    
    public void BuildDirectGraph(String[] words, Map<Character, Set<Character>> map, Map<Character, Integer> indegree){
        for (int i = 0; i < words.length - 1; i++){
            int len = Math.min(words[i].length(), words[i + 1].length());
            for (int j = 0; j < len; j++){
                char c1 = words[i].charAt(j);
                char c2 = words[i + 1].charAt(j);
                if (c1 != c2){
                    if (!map.containsKey(c1)){
                        Set<Character> set = new HashSet<>();
                        map.put(c1, set);
                    }
                    if (map.get(c1).add(c2)){
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
    }
}