class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
        }
        int ans = 0;
        boolean odd = false;
        for (int i = 0; i < 256; i++){
            ans += (count[i] / 2) * 2;
            if (!odd && count[i] % 2 == 1){
                odd = true;
            }
        }
        return odd ? ans + 1 : ans;
    }
}