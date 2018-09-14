class solution{
    private static String mergeString(String s1, String s2) {
        if (s1.isEmpty()) {return s2; }
        if (s2.isEmpty()) {return s1; }
        int i1 = 0;
        int i2 = 0;
        StringBuilder res = new StringBuilder();
        while (i1 < s1.length() || i2 < s2.length()) {
            if (i1 < s1.length()) {
                res.append(s1.charAt(i1++));
            }
            if (i2 < s2.length()) {
                res.append(s2.charAt(i2++));
            }
        }
        return res.toString();
    }
}
    
    