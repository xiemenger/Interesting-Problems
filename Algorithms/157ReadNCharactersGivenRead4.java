    public int read(char[] buf, int n) {
        boolean eof = false;
        int len = 0;
        char[] tmp = new char[4];
        
        while (!eof && len < n){
            int count = read4(tmp);
            eof = count < 4;
            
            for (int i = 0; len < n && i < count; i++){
                buf[len++] = tmp[i];
            }
        }
        return len;
    }
}