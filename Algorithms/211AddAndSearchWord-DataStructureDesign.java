class WordDictionary {

    /** Initialize your data structure here. */
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        int idx = 0;
        for (int i = 0; i < word.length(); i++){
            idx = word.charAt(i) - 'a';
            if (node.children[idx] == null){
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    public boolean match(char[] chars, int k, TrieNode node){
        if (k == chars.length){
            return node.isEnd;
        }
        
        if (chars[k] != '.'){
            return node.children[chars[k] - 'a'] != null 
                   && match(chars, k + 1, node.children[chars[k] - 'a']);
        } else {
            for (int j = 0; j < node.children.length; j++){
                    if (node.children[j] != null 
                        && match(chars, k + 1, node.children[j])){
                        return true;
                    }
            }
        }
        return false;
    }
    
    class TrieNode{
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */