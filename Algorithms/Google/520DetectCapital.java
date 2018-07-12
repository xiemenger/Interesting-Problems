class Solution {
    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        for (int c : word.toCharArray()){
            if (c >= 'A' && c <= 'Z'){
                capitals++;
            }
        }
        return capitals == 0 || capitals == word.length() || 
            (capitals == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z');
            
    }
}