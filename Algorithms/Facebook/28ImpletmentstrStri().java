class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.isEmpty() && needle.isEmpty()){
            return 0;
        }
        if (haystack.isEmpty()){ return -1; }
        if (needle.isEmpty()){ return 0; }
        
        for (int i = 0; i < haystack.length(); i++){
            for (int j = 0; j <= needle.length(); j++){
                if (j == needle.length()){ return i; }
                if (i + j >= haystack.length()){ return -1; }
                if (haystack.charAt(i + j) != needle.charAt(j)){ break; }
            }
        }
        return -1;
    }
}