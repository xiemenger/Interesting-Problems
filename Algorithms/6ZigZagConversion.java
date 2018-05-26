class Solution {
    public String convert(String s, int numRows) {
        char[] str = s.toCharArray();
        int n = s.length();
        String res = "";
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        for (int i = 0; i < n;){
            for (int j = 0; j < numRows && i < n; j++){
                sb[j].append(str[i++]);
            }
            for (int j = numRows - 2; j > 0 && i < n; j--){
                sb[j].append(str[i++]);
            }
        }
        
        for (int i = 0; i < numRows; i++){
            res += sb[i].toString();
        }
        return res;
    }
}class Solution {
    public String convert(String s, int numRows) {
        char[] str = s.toCharArray();
        int n = s.length();
        String res = "";
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        for (int i = 0; i < n;){
            for (int j = 0; j < numRows && i < n; j++){
                sb[j].append(str[i++]);
            }
            for (int j = numRows - 2; j > 0 && i < n; j--){
                sb[j].append(str[i++]);
            }
        }
        
        for (int i = 0; i < numRows; i++){
            res += sb[i].toString();
        }
        return res;
    }
}