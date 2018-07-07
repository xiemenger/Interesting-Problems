class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int count = K;
        for (int i = S.length() - 1; i >= 0; i--){
            if (S.charAt(i) != '-'){
                if (count <= 0){
                    count = K;
                    sb.append("-");
                }
                sb.append(Character.toUpperCase(S.charAt(i)));
                count--;
            }
        }
        return sb.reverse().toString();
    }
}