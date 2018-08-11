class Solution {
    public String customSortString(String S, String T) {
        int[] freq = new int[26];
        for (char c : T.toCharArray()){
            freq[c - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        for (char c : S.toCharArray()){
            while (freq[c - 'a']-- > 0){
                res.append(c);
            }
        }
        
        for (char c = 'a'; c <= 'z'; c++){
            while (freq[c - 'a']-- > 0){
                res.append(c);
            }
        }
        return res.toString();
    }
}