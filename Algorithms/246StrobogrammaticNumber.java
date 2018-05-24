class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null){
            return true;
        }

        int i = 0; 
        int j = num.length() - 1;
        while (i <= j){
            if (!"00 11 88 69 96".contains(num.charAt(i++) + "" + num.charAt(j--))){
                return false;
            }
        }
        return true;
    }
}