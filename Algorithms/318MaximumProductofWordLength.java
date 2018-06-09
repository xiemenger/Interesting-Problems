class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0){
            return 0;
        }
        
        int n = words.length;
        int[] val = new int[n];
        for (int i = 0; i < n; i++){
            String word = words[i];
            for (int j = 0; j < word.length(); j++){
                val[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if ((val[i] & val[j]) == 0 && (words[i].length() * words[j].length() > max)){
                    max = words[i].length() * words[j].length();
                }
            }
        }
        return max;
    }
}