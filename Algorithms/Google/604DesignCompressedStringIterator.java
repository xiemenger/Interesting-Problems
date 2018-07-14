class StringIterator {
    int strIdx;
    int count;
    char curLetter;
    String s;
    public StringIterator(String compressedString) {
        s = compressedString;
        if (s.isEmpty()){
            return;
        }
        strIdx = 0;
        updateLetterAndNum(strIdx);
    }
    
    private boolean updateLetterAndNum(int idx){
        if (idx >= s.length()){
            count = 0;
            curLetter = ' ';
            return false;
        }
        curLetter = s.charAt(idx++);
        int num = 0;
        while (idx < s.length() && s.charAt(idx) - '0' <= 9){
            num = num * 10 + s.charAt(idx++) - '0';
        }
        count = num;
        strIdx = idx;
        return true;
    }
    
    public char next() {
        if (count <= 0){
            updateLetterAndNum(strIdx);
        }
        count--;
        return curLetter;
    }
    
    public boolean hasNext() {
        return count > 0 || updateLetterAndNum(strIdx);
    }
}