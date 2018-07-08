/**
 * When build a valid word sqaure, before we add a new word into the list, 
 * we know its prefix. 
 * for example, for the second word, we know its first character must be 
 *  = the first word's second character.
 * Thus, Insteading try every word to check the validation, we can 
 * narrow down the checking range : the range only cover words whose
 * prefix meets requirement.
 * 
 * To find the words whose prefix meets requirement, we can use Trie
 * Datastructure to do so.
 * 
 * TireNode{
 * Children[26]: for 26 charaxters.
 * startWith: stores the words' idx where the word start with the prefix.
 * }
 * 
 * then, we use dfs to search check word square validation.
 * 
 */
class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        TrieNode root = BuildTree(words);
        for (int i = 0; i < words.length; i++){
            List<String> list = new ArrayList<>();
            list.add(words[i]);
            search(root, words, res, list);
        }
        return res;
    }
    
    private void search(TrieNode root, String[] words, List<List<String>> res, List<String> list){
        if (list.size() == list.get(0).length()){
            res.add(new ArrayList<>(list));
            return;
        }
        
        int idx = list.size();
        String prefix = "";
        for (String word : list){
            prefix += word.charAt(idx);
        }
        
        List<Integer> indexes = getWordByPrefix(root, words, prefix);
        for (int i : indexes){
            list.add(words[i]);
            search(root, words, res, list);
            list.remove(list.size() - 1);
        }
    
    }
    
    private List<Integer> getWordByPrefix(TrieNode root, String[] words, String prefix){
        TrieNode node = root;
        for (char c : prefix.toCharArray()){
            if (node.children[c - 'a'] == null){
                return new ArrayList<>();
            }
            node = node.children[c - 'a'];
        }
        return node.startWith;
    }
    
    private TrieNode BuildTree(String[] words){
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++){
            TrieNode node = root;
            for (char c : words[i].toCharArray()){
                int idx = c - 'a';
                if (node.children[idx] == null){
                    node.children[idx] = new TrieNode();
                }
                node.startWith.add(i);
                node = node.children[idx];
            }
        }
        return root;
    }
    
    class TrieNode{
        List<Integer> startWith;
        TrieNode[] children;
        
        public TrieNode(){
            startWith = new ArrayList<>();
            children = new TrieNode[26];
        }
    }
}