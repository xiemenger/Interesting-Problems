class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            map.put(words[i],  i);
        }
        for (int i = 0; i < words.length;i++){
            String w = words[i];
            for (int j = 0; j <= w.length(); j++){
                String s1 = w.substring(0,j);
                String s2 = w.substring(j);
                
                if (isPalindrome(s1)){
                    String r2 = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(r2) && map.get(r2) != i){
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(r2));
                        list.add(i);
                        res.add(list);
                    }
                }
                
                if (s2.length() != 0 && isPalindrome(s2)){
                    String r1 = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(r1) && map.get(r1) != i){
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(r1));
                        res.add(list);
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
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}