class Solution {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        String sufex = "a";
        String vowel = "aeiouAEIOU";
        StringBuilder res = new StringBuilder();
        int n = words.length;
        for (int i = 0; i < n; i++){
            if (!vowel.contains("" + words[i].charAt(0))){
                char f = words[i].charAt(0);
                res.append(words[i].substring(1));
                res.append(f);
            } else {
                res.append(words[i]);
            }
            
            res.append("ma");
            res.append(sufex);
            if (i != n - 1){
                res.append(" ");
            }
            sufex += "a";
        }
        
        return res.toString();
    }
}