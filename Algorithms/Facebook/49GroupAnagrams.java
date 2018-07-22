class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0){
            return res;
        }
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs){
            char[] s = str.toCharArray();;
            Arrays.sort(s);
            String sorted = new String(s);
            if(!anagrams.containsKey(sorted)){
                anagrams.put(sorted, new ArrayList<>());
            }
            anagrams.get(sorted).add(str);
        }
        
        for (List<String> list : anagrams.values()){
            res.add(list);
        }
        return res;
    }
}