class Solution {
    public String rearrangeString(String s, int k) {
        char[] str = s.toCharArray();
        int n = s.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        for (char c : str){
            count[c-'a']++;
        }
       
        char[] res = new char[n];
        for (int i = 0; i < n; i++){
            int pos = findmax(count, valid, i);
            if (pos < 0){ return ""; }
            res[i] = (char)('a'+pos);
            count[pos]--;
            valid[pos] = i + k;
        }
        return new String(res);
    }
    
    public int findmax(int[] count, int[] valid, int idx){
        int max = Integer.MIN_VALUE;
        int pos = -1;
        for (int i = 0; i < count.length; i++){
            if (count[i] > 0 && count[i] > max && idx >= valid[i]){
                max = count[i];
                pos = i;
            }
        }
        return pos;
    }
}