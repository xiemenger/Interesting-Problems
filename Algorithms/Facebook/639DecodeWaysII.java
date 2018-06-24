class Solution {
    static int M = 1000000007;
    public int numDecodings(String s) {
        int n = s.length();
        long first = 1;
        long second = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0'? 0 : 1;
        
        for (int i = 1; i < n; i++){
            char c = s.charAt(i);
            char prec = s.charAt(i - 1);
            long third = 0;
            if (c == '*'){
                third = second * 9;
                
                if ( prec == '1'){
                    third = (third + 9 * first) % M;
                } else if (prec == '2'){
                    third = (third + 6 * first) % M;
                } else if (prec == '*'){
                    third = (third + 15 * first) % M;
                }
                
            } else {
                third = c == '0' ? 0 : second;
                
                if (prec == '1'){
                    third = (third + first) % M;
                } else if (prec == '2' && c < '7'){
                    third = (third + first) % M;
                } else if (prec == '*'){
                    if (c <= '6'){
                        third = (third + 2 * first) % M;
                    } else {
                        third = (third + first) % M;
                    }
                }
            }
            
            first = second;
            second = third;
        }
        return (int)second;
    }
}