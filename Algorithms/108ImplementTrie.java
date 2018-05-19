class Trie {

    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        int idx = 0;
        for (int i = 0; i < word.length(); i++){
            idx = word.charAt(i) - 'a';
            if (node.children[idx] == null){
                return false;
            }
            node = node.children[idx];
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int idx = 0;
        for (int i = 0; i < prefix.length(); i++){
            idx = prefix.charAt(i) - 'a';
            if (node.children[idx] == null){
                return false;
            }
            node = node.children[idx];
        }
        return true;
    }
    
    
    class TrieNode{
        Boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */