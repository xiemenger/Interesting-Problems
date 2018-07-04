class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int idx = 0;
        char pre = chars[0];
        int count = 1;
        for (int i = 1; i <= n; i++){
            if (i < n && chars[i] == pre){
                count++;
            } else {
                chars[idx++] = pre;
                if (count >= 2){
                    for (char c : String.valueOf(count).toCharArray()){
                        chars[idx++] = c;
                    }
                }
                
                System.out.println(pre+" : "+count);
                if (i < n){ pre = chars[i]; }
                count = 1;
            }
        }
        return idx;
    }
}