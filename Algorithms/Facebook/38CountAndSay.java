class Solution {
    public String countAndSay(int n) {
        if (n <= 0){ return ""; }
        if (n == 1){ return "1"; }
        
        String res = countAndSay(n - 1);
        StringBuilder tmp = new StringBuilder();
        int cnt = 1;
        char prev = res.charAt(0);
        for (int i = 1; i < res.length(); i++){
            if (res.charAt(i) == prev){
                cnt++;
            } else {
                tmp.append(cnt);
                tmp.append(prev);
                prev = res.charAt(i);
                cnt = 1;
            }
        }
        tmp.append(cnt);
        tmp.append(prev);
        return tmp.toString();
    }
}