class Solution {
    public String solveEquation(String equation) {
        String[] strs = equation.split("=");
        int[] res1 = compute(strs[0]);
        int[] res2 = compute(strs[1]);
        res1[0] -= res2[0];
        res1[1] -= res2[1];
        if (res1[0] == 0){
            if (res1[1] == 0){
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
        return "x="+(-res1[1] / res1[0]);
        
    }
    
    private int[] compute(String str){
        int[] res = new int[2]; //res[0] store the cnt of x, res[1] stores sum.
        String[] s = str.split("(?=[+-])"); // () means regular expression, 
                                            // ?= mean positive lookahead which will include seperator 
                                            // in the result strings. 
                                            // [+-] means "+" or "-".
        
        for (String t : s){
            //System.out.println(t);
            if (t.equals("+x") || t.equals("x")){res[0]++; }
            else if (t.equals("-x")){res[0]--; }
            else if (t.contains("x")){
                res[0] += Integer.parseInt(t.substring(0, t.indexOf("x"))); }
            else { res[1] += Integer.parseInt(t);}
        }
        return res;
    }
}