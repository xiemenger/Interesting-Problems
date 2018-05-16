class Solution {
    // Time: O(n), Space: O(n);
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        if (s == null || s.length() < 10){
            return new ArrayList<>();
        }
        Set<String> strs = new HashSet<>();
        
        for (int i = 0; i < s.length() - 9; i++){
            if (!strs.add(s.substring(i, i + 10))){
                res.add(s.substring(i, i + 10));
            }
        }
        return new ArrayList<String>(res);
    }
}