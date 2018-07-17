public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int bufIdx = 0;
    private int bufCnt = 0;
    private char[] tmp = new char[4];
    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n){
            if (bufIdx == bufCnt){
                bufIdx = 0;
                bufCnt = read4(tmp);
            }
            if (bufCnt == 0){
                return i;
            }
            
            buf[i++] = tmp[bufIdx++];
        }
        return i;
    }
}