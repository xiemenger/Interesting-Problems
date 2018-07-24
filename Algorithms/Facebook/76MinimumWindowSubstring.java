/**
 Key Idea is:
 1) move r pointer to find a valid string.
 2) if we find a valide string, then we move l pointer to find a min string.
 
*/

class Solution {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int minl = 0;
        int l = 0;
        int r = 0;
        int slen = s.length();
        int cnt = t.length();
        int[] freq = new int[256];
        for (char c : t.toCharArray()){
            freq[c]++;
        }

        while (r < slen){
            char c = s.charAt(r);
            if (freq[c] > 0){
                cnt--;
            }
            freq[c]--;
            r++;
            
            while (cnt == 0){
                if (minLen > r - l){
                    minLen = r - l;
                    minl = l;
                }
                c = s.charAt(l);
                if (freq[c] >= 0){
                    cnt++;
                }
                freq[c]++;
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE? "" : s.substring(minl, minl + minLen);
    }
}