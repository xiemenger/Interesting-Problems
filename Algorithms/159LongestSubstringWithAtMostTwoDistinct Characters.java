class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null){
            return 0;
        }
        int l = 0;
        int r = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        while (r < s.length()){
            char cur = s.charAt(r);
            if (map.containsKey(cur)){
                map.put(cur, map.get(cur) + 1);
                r++;
            } else {
                if (map.size() < 2){
                    map.put(cur, 1);
                    r++;
                } else {
                    while (map.size() >= 2){
                        char leftChar = s.charAt(l);
                        int count = map.get(leftChar) - 1;
                        map.put(leftChar, count);
                        l++;
                        if(count == 0){
                            map.remove(leftChar);
                        }
                    }
                }
            }
            max = Math.max(max, r - l);
        
        }
        return max;
    }
}