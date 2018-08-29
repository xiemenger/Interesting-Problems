class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length == 0){
            return res;
        }
        Map<String, Integer> indices = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            indices.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++){
            for (int j = 0; j <= words[i].length(); j++){
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                if (isPalindrome(s1)){
                    String s2Rev = new StringBuilder(s2).reverse().toString();
                    if (indices.containsKey(s2Rev) && indices.get(s2Rev) != i){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(indices.get(s2Rev));
                        tmp.add(i);
                        res.add(tmp);
                    }
                }
                
                if (s2.length() != 0 && isPalindrome(s2)){
                    String s1Rev = new StringBuilder(s1).reverse().toString();
                    if (indices.containsKey(s1Rev) && indices.get(s1Rev) != i){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(i);
                        tmp.add(indices.get(s1Rev));
                        res.add(tmp);
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if (s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}