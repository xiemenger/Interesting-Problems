class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        if (numerator < 0 ^ denominator < 0){
            res.append("-");
        }
        
        // convert to long or elase abs (-2147483648) will overflow
        long divident = Math.abs(Long.valueOf(numerator));
        long dividor = Math.abs(Long.valueOf(denominator));
        res.append(divident / dividor);
        long remainder = divident % dividor;
        if (remainder == 0){
            return res.toString();
        }
        
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0){
            if (map.containsKey(remainder)){
                res.insert(map.get(remainder), "(");
                res.append(")");
                return res.toString();
            }
            map.put(remainder, res.length());
            remainder *= 10;
            res.append(remainder / dividor);
            remainder = remainder % dividor;
        }
        return res.toString();   
    }
}