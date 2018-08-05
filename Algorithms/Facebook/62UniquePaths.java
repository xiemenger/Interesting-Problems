class Solution {
    public int uniquePaths(int m, int n) {
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                cnt[j] += cnt[j - 1];
            }
        }
        return cnt[n - 1];
    }
}