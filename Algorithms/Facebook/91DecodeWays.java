class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty()){
            return 0;
        }
        int len = s.length();
        int[] cnt = new int[len + 1];
        cnt[0] = 1;
        cnt[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i <= len; i++){
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            cnt[i] = first == 0 ? 0 : cnt[i - 1];
            if (second >= 10 && second <= 26){
                cnt[i] += cnt[i - 2];
            }
        }
        return cnt[len];
    }
}