class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int d1 = -1;
        int d2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++){
            if (word1.equals(words[i])){
                d1 = i;
                if (d2 != -1){
                    min = Math.min(Math.abs(d1 - d2), min);
                }
            }
            if (word2.equals(words[i])){
                d2 = i;
                if (d1 != -1){
                    min = Math.min(Math.abs(d1 - d2), min);
                }
            }
        }
        return min;
    }
}