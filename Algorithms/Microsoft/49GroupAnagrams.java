/**
 Time : O(nk) where n is the number of string, k is the average length of string in strs.
 Space: O(nk)
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0){
            return res;
        }
        Map<String, List<String>> matches = new HashMap<>();
        int[] cnts = new int[26];
        for (String s : strs){
            for (char c : s.toCharArray()){ cnts[c - 'a']++; }
            StringBuilder match = new StringBuilder();
            for (int cnt: cnts){ match.append(cnt).append(","); }
            
            String w = match.toString();
            if (!matches.containsKey(w)){
                matches.put(w, new ArrayList<>());
            }
            matches.get(w).add(s);
            Arrays.fill(cnts, 0);
        }
        
        for (List<String> list : matches.values()){
            res.add(list);
        }
        return res;
    } 
}