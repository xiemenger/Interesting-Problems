class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int l = s.length();
        int start = 0;
        for (int i = 0; i < rows; i++){
            start += cols;
            while (start > 0 && s.charAt(start % l) != ' '){
                start--;
            }
            start++;
        }
        return start / l;
    }
}