class ValidWordAbbr {
    Map<String, Set<String>> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        
        for (int i = 0; i < dictionary.length; i++){
            String abr = getabbr(dictionary[i]);
            if (!map.containsKey(abr)){
                Set<String> tmp = new HashSet<>();
                map.put(abr, tmp);
            }
            map.get(abr).add(dictionary[i]);
        }
    }
    
    public String getabbr(String w){
        int n = w.length();
        if (n <= 2) {
            return w;
        }
        return ""+ w.charAt(0) + (n-2) + w.charAt(n - 1);
    }
    
    public boolean isUnique(String word) {
        String abr = getabbr(word);
        Set<String> set = map.get(abr);        
        return set == null || (set.size() == 1 && set.contains(word));
    }
}
