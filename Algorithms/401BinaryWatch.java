class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; h++){
            int hbits = Integer.bitCount(h);
            for (int m = 0; m < 60; m++){
                if (hbits + Integer.bitCount(m) == num){
                    //System.out.println(hbits+", "+mbits);
                    res.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return res;
    }   
}