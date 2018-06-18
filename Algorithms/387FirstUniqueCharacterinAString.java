class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        int res = -1;
        int[] count = new int[26];
        for (int i = 0; i < n; i++){
            count[s.charAt(i)-'a']++;
        }
        
        for (int i = 0; i < n; i++){
            if (count[s.charAt(i)-'a'] == 1){
                res = i;
                break;
            }
        }
        return res;
    }
}