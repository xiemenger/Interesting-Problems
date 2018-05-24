class WordDistance {
    Map<String, ArrayList<Integer>> map = new HashMap<>();
    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++){
            if (!map.containsKey(words[i])){
                ArrayList<Integer> tmp = new ArrayList<>();
                map.put(words[i], tmp);
            }
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> l1 = map.get(word1);
        ArrayList<Integer> l2 = map.get(word2);

        for (int i = 0, j = 0; i < l1.size() && j < l2.size(); ){
            int val1 = l1.get(i);
            int val2 = l2.get(j);
            if (val1 < val2){
                min = Math.min(min, val2 - val1);
                i++;
            } else {
                min = Math.min(min, val1 - val2);
                j++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */