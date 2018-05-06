class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxWordLen = 0;
        Set<String> wordPool = new HashSet<>();
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (String word : wordDict){
            wordPool.add(word);
            if (word.length() > maxWordLen){
                maxWordLen = word.length();
            }
        }
        
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; i - j >= 0 && j <= maxWordLen; j++){
                String curWord = s.substring(i-j, i + 1);
                if (wordPool.contains(curWord) && dp[i - j]){
                    dp[i + 1] = true;
                }
            }
        }
        
        return dp[s.length()];
    }
}