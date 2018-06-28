class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        change(S.toCharArray(), 0, res);
        return res;
    }
    
    private void change(char[] s, int idx, List<String> res){
        if (idx == s.length){
            res.add(new String(s));
            return;
        }
        if (Character.isLetter(s[idx])){
            s[idx] = Character.toLowerCase(s[idx]);
            change(s, idx+1, res);
            s[idx] = Character.toUpperCase(s[idx]);
        }
        change(s, idx+1, res);
    }
    
}