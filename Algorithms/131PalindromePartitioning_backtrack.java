class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, res, new ArrayList<>());
        return res;
    }
    
    public void backtrack(String s, List<List<String>> res, List<String> list){
        if (s.length() == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < s.length(); i++){
            if(isPalindrome(s.substring(0, i + 1))){
                list.add(s.substring(0, i + 1));
                backtrack(s.substring(i + 1), res, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s){
        int l = 0; 
        int r = s.length() - 1;
        while (l < r){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}