/**
 * Time O(all characters in the words);
 * Space O(the all characters in the words);
 */

class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0){ return ""; }
        Map<Character, Set<Character>> neibs = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();
        buildGraph(words, neibs, indegrees);
        
        Queue<Character> seq = new ArrayDeque<>();
        for (char letter : indegrees.keySet()){
            if (indegrees.get(letter) == 0){
                seq.offer(letter);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!seq.isEmpty()){
            char cur = seq.poll();
            res.append(cur);
            if (!neibs.containsKey(cur)){continue; }
            for (char neib : neibs.get(cur)){
                int degree = indegrees.get(neib);
                indegrees.put(neib, degree - 1);
                if (degree == 1){
                    seq.offer(neib);
                }
            }
        }
        return res.length() == indegrees.size() ? res.toString() : "";
    }
    
    private void buildGraph(String[] words, Map<Character, Set<Character>> neibs, Map<Character, Integer> indegrees){
        for (String word : words){
            for (char c : word.toCharArray()){
                if (!indegrees.containsKey(c)){
                    indegrees.put(c, 0);
                }
            }
        }
        
        for (int i = 0; i < words.length - 1; i++){
            String word = words[i];
            String next = words[i + 1];
            for (int j = 0; j < Math.min(word.length() , next.length()); j++){
                char c1 = word.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2){
                    if (!neibs.containsKey(c1)){
                        neibs.put(c1, new HashSet());
                    }
                    
                    if (neibs.get(c1).add(c2)){
                        indegrees.put(c2, indegrees.getOrDefault(c2, 0) + 1);
                    }
                    break;
                }
            }
        }
    }
}