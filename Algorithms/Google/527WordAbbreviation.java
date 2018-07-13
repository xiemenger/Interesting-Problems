class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        int n = dict.size();
        String[] abbrs = new String[n];
        int k = 0;
        for (String s : dict){
            abbrs[k++] = abbrv(s, 0);
        }
        int[] prefix = new int[n];
        
        for (int i = 0; i < n; i++){
            while(true) {
                Set<Integer> sames = new HashSet<>();
                for (int j = i + 1; j < n; j++){
                    if (abbrs[i].equals(abbrs[j])){
                        sames.add(j);
                    }
                }

                if (sames.isEmpty()){
                    break;
                }
                
                sames.add(i);
                for (int idx : sames){
                    abbrs[idx] = abbrv(dict.get(idx), ++prefix[idx]);
                }
            } 
        }
        return Arrays.asList(abbrs);
    }
    
    private String abbrv(String word, int idx){
        int n = word.length();
        if (n - idx <= 3){
            return word;
        }
        
        return word.substring(0, idx+1) + (word.length() - idx - 2) + word.charAt(word.length() - 1);
    }
}