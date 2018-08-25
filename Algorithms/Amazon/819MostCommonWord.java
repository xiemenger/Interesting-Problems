class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.replaceAll("[!?',;.]","").toLowerCase().split(" ");
        Set<String> bannedWords = new HashSet<>();
        for (String word : banned){
            bannedWords.add(word);
        }
        Map<String, Integer> freqs = new HashMap<>();
        int maxCnt = 0;
        String resWord = "";
        for (String word : words){
            if (!bannedWords.contains(word)){
                freqs.put(word, freqs.getOrDefault(word, 0) + 1);
                if (freqs.get(word) > maxCnt){
                    maxCnt = freqs.get(word);
                    resWord = word;
                }
            }
        }
        return resWord;
    }
}