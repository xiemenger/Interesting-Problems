class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length() - k;
        char[] res = new char[num.length()];
        int idx = 0;
        for (int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            while (k > 0 && idx > 0 && res[idx - 1] > c){
                idx--;
                k--;
            }
            res[idx++] = c;
        }
        
        idx = 0;
        while (idx < len && res[idx] == '0'){
            idx++;
        }
        return idx == len ? "0" : new String(res, idx, len - idx);
    }
}