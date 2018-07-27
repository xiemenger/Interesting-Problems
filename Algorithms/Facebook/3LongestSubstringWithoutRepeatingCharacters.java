class Solution { 
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()){
            return 0;
        }
        Map<Character, Integer> seen = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (seen.containsKey(c)){
                left = Math.max(seen.get(c) + 1, left);
            }
            seen.put(c, i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}