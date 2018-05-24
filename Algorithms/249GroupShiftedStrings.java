class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null){
            return res;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings){
            String dist = computeDist(s);
            if (!map.containsKey(dist)){
                ArrayList<String> tmp = new ArrayList<>();
                map.put(dist, tmp);
            }
            map.get(dist).add(s);
        }
        
        for (String dist: map.keySet()){
            List<String> list = map.get(dist);
            Collections.sort(list);
            res.add(list);
        }
        
        return res;
    }
    
    public String computeDist(String s){
        String res = "";
        for (int i = 1; i < s.length(); i++){
            int c = s.charAt(i) - s.charAt(i - 1);
            if (c < 0){
                c += 26;
            }
            res += c;
        }
        return res;
    }
}