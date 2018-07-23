d class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        ArrayList<Node>[] schars = new ArrayList[26];
        int ans = 0;
        for (int i = 0; i < schars.length; i++){
            schars[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < words.length; i++){
            schars[words[i].charAt(0) - 'a'].add(new Node(words[i], 0));
        }
        
        for (int i = 0; i < S.length(); i++){
            char cur = S.charAt(i);
            ArrayList<Node> cur_old = schars[cur - 'a'];
            schars[cur - 'a'] = new ArrayList<>();
            
            for (Node node : cur_old){
                 if (node.idx == node.word.length() - 1){
                     ans++;
                 } else {
                     node.idx++;
                     schars[node.word.charAt(node.idx) - 'a'].add(node);
                 } 
            }
        }
        return ans;                                            
        
    }
    
    class Node{
        String word;
        int idx;
        public Node(String w, int i){
            word = w;
            idx = i;
        }
    }
}