class MagicDictionary {

    /** Initialize your data structure here. */
    Set<String> set;
    public MagicDictionary() {
        set = new HashSet<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String w : dict){
            set.add(w);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++){
            char old = w[i];
            for (int j = 0; j < 26; j++){
                if (old == 'a' + j){
                    continue; 
                }
                w[i] = (char)('a' + j);
                if (set.contains(new String(w))){
                    return true;
                }
            }
            w[i] = old;
        }
        return false;
    }
}