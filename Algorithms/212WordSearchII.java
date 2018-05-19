class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        TrieNode root = buidTrieTree(words);
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (root.children[board[i][j] - 'a'] != null){
                    dfs(board, root, visited, i, j, res, "");
                }
            }
        }
        return res;  
    }
    
    public void dfs(char[][] board, TrieNode root, boolean[][] visited, int i, int j, List<String> res, String word){
        if (i < 0 || i >= board.length 
            || j < 0 || j >= board[0].length 
            || root.children[board[i][j] - 'a'] == null 
            || visited[i][j]){
            return;
        }
        
        word = word + board[i][j];
        root = root.children[board[i][j] -'a'];
        
        if (root.isEnd){
            res.add(word);
            root.isEnd = false;
        }
        
        visited[i][j] = true;

        dfs(board, root, visited, i - 1, j, res, word);
        dfs(board, root, visited, i + 1, j, res, word);
        dfs(board, root, visited, i, j - 1, res, word);
        dfs(board, root, visited, i, j + 1, res, word);
        
        visited[i][j] = false;
        //root.isEnd = true;
    }
    
    public TrieNode buidTrieTree(String[] words){
        TrieNode root = new TrieNode();
        TrieNode node = root;
        int idx = 0;
        for (String word : words){
            node = root;
            idx = 0; 
            for (int i = 0; i < word.length(); i++){
                idx = word.charAt(i) - 'a';
                if (node.children[idx] == null){
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }
        return root;
    }
    
    class TrieNode{
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
    }
    
}