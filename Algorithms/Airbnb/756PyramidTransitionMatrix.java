class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, Set<Character>> matches = new HashMap<>();
        for (String s : allowed){
            String key = s.substring(0,2);
            if (!matches.containsKey(key)){
                matches.put(key, new HashSet<>());
            }
            matches.get(key).add(s.charAt(2));
        }
        return check(bottom, matches);
    }
    
    // check layer by layer by BFS
    private boolean check(String bottom, Map<String, Set<Character>> matches){
        if (bottom.length() == 1){return true; }
        List<String> nextBottoms = new ArrayList<>();
        getNextBottoms(bottom, matches, 0, new StringBuilder(), nextBottoms);
        for (String nextBottom : nextBottoms){
            if (check(nextBottom, matches)){
                return true;
            }
        }
        return false;
    }
    
    // get Next layers by DFS backtracking
    private void getNextBottoms(String bottom, Map<String, Set<Character>> matches, int pos,
                                StringBuilder nextBottom, List<String> nextBottoms){
        if (pos == bottom.length() - 1){
            nextBottoms.add(nextBottom.toString());
            return;
        }
        String key = bottom.substring(pos, pos + 2);
        int len = nextBottom.length();
        if (matches.containsKey(key)){
            for (Character c : matches.get(key)){
                nextBottom.append(c);
                getNextBottoms(bottom, matches, pos+1, nextBottom, nextBottoms);
                nextBottom.setLength(len);
            }
        }
    }
}