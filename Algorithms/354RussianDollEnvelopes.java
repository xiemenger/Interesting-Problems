class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if (a[0] != b[0]){
                    return a[0] - b[0];
                } else {
                    return b[1] - a[1];
                }
            }
        });
        
        // find longest increasing subsequence
        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int[] e : envelopes){
            int idx = Arrays.binarySearch(dp, 0, len, e[1]);
            if (idx < 0){
                idx = -(idx+1);
            }
            dp[idx] = e[1];
            if (idx == len){
                len++;
            }
        }
        return len;
    }
}