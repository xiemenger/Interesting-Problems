class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[256];
        for (char c : magazine.toCharArray()){
            count[c]++;
        }
        for (char c: ransomNote.toCharArray()){
            count[c]--;
            if (count[c] < 0){
                return false;
            }
        }
        return true;
    }
}