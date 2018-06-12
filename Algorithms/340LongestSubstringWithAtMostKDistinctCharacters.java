class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0){ return 0; }
        int n = s.length();
        int max = 0;
        if (k > n){ return n; }
        int[] count = new int[256];
        int num = 0;
        for (int l = 0, r = 0; r < n; r++){
            char cur = s.charAt(r);
            if (count[cur] == 0){ 
                num++; 
            }
            
            count[cur]++;
            
            if (num > k){
                while(--count[s.charAt(l++)] > 0);
                num--;
            }
           
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}