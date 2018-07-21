class Solution {
    public List<String> letterCombinations(String digits){
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()){ return res; }
        String[] match = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combinate(digits, 0, new StringBuilder(), res, match);
        return res;
    }
    
    private void combinate(String digits, int pos, StringBuilder str, List<String> res, String[] match){
        if (pos == digits.length()){
            res.add(str.toString());
            return;
        }
        //System.out.println(pos);
        int cur = digits.charAt(pos) - '0';
        int len = str.length();
        for (int i = 0; i < match[cur].length(); i++){
            str.append(match[cur].charAt(i));
            combinate(digits, pos + 1, str, res, match);
            str.setLength(len);
        }
    }

}