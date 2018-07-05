class AutocompleteSystem {
    TrieNode curNode;
    TrieNode root;
    String curSentence;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        curSentence = "";
        for (int i = 0; i < sentences.length; i++){
            insert(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#'){
            insert(curSentence, 1);
            curSentence = "";
            return res;
        }
        curSentence += c;
        List<Node> list = lookup(root, curSentence);
        Collections.sort(list, (a, b) -> (a.freq != b.freq ? b.freq - a.freq : a.set.compareTo(b.set)));
        
        for (int i = 0; i < Math.min(3, list.size()); i++){
            res.add(list.get(i).set);
        }
        return res;
    }
    
    private void insert(String s, int freq){
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++){
            int pos = getPos(s.charAt(i));
            if (node.branch[pos] == null){
                node.branch[pos] = new TrieNode();
            }
            node = node.branch[pos];
        }
        node.freq += freq;
    }
    
    private int getPos(char c){
        if (c == ' '){
            return 26;
        }
        return c - 'a';
    }
    
    private List<Node> lookup(TrieNode node, String s){
        List<Node> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            int pos = getPos(s.charAt(i));
            if (node.branch[pos] == null){
                return new ArrayList<>();
            }
            node = node.branch[pos];
        }
        traverse(node, s, res);
        
        return res;
    }
    
    private void traverse(TrieNode node, String s,  List<Node> res){
        if (node.freq > 0){
            res.add(new Node(s, node.freq));
        }        
        
        for (int i = 'a'; i <= 'z'; i++){
            if (node.branch[i - 'a'] != null){
                traverse(node.branch[i - 'a'], s+(char)i, res);
            }
        }
        
        if (node.branch[26] != null){
            traverse(node.branch[26], s+" ", res);
        }
    }
    
    class Node {
        int freq;
        String set;
        
        public Node(String set, int freq){
            this.set = set;
            this.freq = freq;
        }
    }
    
    class TrieNode{
        TrieNode[] branch = new TrieNode[27];
        int freq;
    }
}