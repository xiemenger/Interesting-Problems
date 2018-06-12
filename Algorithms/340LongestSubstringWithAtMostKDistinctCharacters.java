class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0){ return 0; }
        int n = s.length();
        int max = 0;
        if (k > n){ return n; }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int l = 0, r = 0; r < n; r++){
            char cur = s.charAt(r);
            if (map.containsKey(cur)){
                map.put(cur, map.get(cur) + 1);
            } else {
                if (map.size() >= k){
                    while (l < r && map.size() >= k){
                        char left = s.charAt(l);
                        map.put(left, map.get(left) - 1);
                        if (map.get(left) == 0){
                            map.remove(left);
                        } 
                        l++;
                    }
                }
                map.put(cur, 1);
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}