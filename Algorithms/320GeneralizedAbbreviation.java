class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        backtrack(word.toCharArray(), 0, new StringBuilder(), res, 0);
        return res;
    }
    
    public void backtrack(char[] word, int pos, StringBuilder sb, List<String> res, int count){
        if (pos == word.length){
            if (count > 0){
                res.add(sb.toString() + count);
            } else {
                res.add(sb.toString());
            }
            return;
        }
        int len = sb.length();
        backtrack(word, pos+1, sb, res, count+1);
        
        sb.setLength(len);
        if (count > 0){
            sb.append(count);
        }
        sb.append(word[pos]);
        backtrack(word, pos+1, sb, res, 0);
        sb.setLength(len);
    }
}