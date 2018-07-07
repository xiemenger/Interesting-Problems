class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int num = 0;
        int j = 0;
        int i = 0;
        while (i < word.length() && j < abbr.length()){
            if (Character.isDigit(abbr.charAt(j))){
                num = num * 10 + abbr.charAt(j) - '0';
                if (num == 0){
                    return false;
                }
            } else {
                i += num;
                num = 0;
                if (i >= word.length() || word.charAt(i++) != abbr.charAt(j)){
                    return false;
                }
            }
            j++;
        }
        i += num;
        return j == abbr.length() && i == word.length();
    }
}