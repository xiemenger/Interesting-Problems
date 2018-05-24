class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int d = -1; 
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++){
            if (words[i].equals(word1) || words[i].equals(word2)){
                if (d != -1 && (word1.equals(word2) || !words[i].equals(words[d]))){
                    min = Math.min(min, i - d);
                }
                d = i;
                
            }
        }
        return min;
    }
}