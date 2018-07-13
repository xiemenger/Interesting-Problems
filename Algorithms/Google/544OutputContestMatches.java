class Solution {
    public String findContestMatch(int n) {
        String[] member = new String[n];
        for (int i = 1; i <= n; i++){
            member[i-1] = "" + i;
        }
        
        for (; n > 1; n /= 2){
            for (int i = 0; i < n / 2; i++){
                member[i] = "("+member[i]+","+member[n - i - 1]+")";
            }
        }
        return member[0];
    }
}