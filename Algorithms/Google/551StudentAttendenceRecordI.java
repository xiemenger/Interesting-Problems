class Solution {
    public boolean checkRecord(String s) {
        int countA = 0;
        for (char c : s.toCharArray()){
            if (c == 'A'){
                countA++;
            }
            if (countA > 1){
                return false;
            }
        }
        return s.indexOf("LLL") < 0;
    }
}