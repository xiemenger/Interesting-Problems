class Solution {
    public String intToRoman(int num) {
        String[] Ms = new String[]{"", "M", "MM", "MMM"};
        String[] Cs = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] Xs = new String[]{"", "X","XX", "XXX", "XL", "L", "LX", "LXX","LXXX","XC"};
        String[] Is = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return Ms[num /1000] + Cs[(num%1000)/100] + Xs[(num%100)/10] + Is[(num%10)];
    }
}