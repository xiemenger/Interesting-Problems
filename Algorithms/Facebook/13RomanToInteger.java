class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        if (s.indexOf("IV") >= 0 ){ ans -= 2; }
        if (s.indexOf("IX") >= 0){ ans -= 2; }
        if (s.indexOf("XL") >= 0){ ans -= 20; }
        if (s.indexOf("XC") >= 0){ ans -= 20; }
        if (s.indexOf("CD") >= 0){ ans -= 200; }
        if (s.indexOf("CM") >= 0){ ans -= 200; }
        System.out.println("ans:"+ans);
        for (int i = 0; i < s.length(); i++){
            switch (s.charAt(i)) {
                case 'M' :
                    ans += 1000;
                    continue;
                case 'D' :
                    ans += 500;
                    continue;
                case 'C' :
                    ans += 100;
                    continue;
                case 'L' :
                    ans += 50;
                    continue;
                case 'X' :
                    ans += 10;
                    continue;
                case 'V' :
                    ans += 5;
                    continue;
                case 'I' :
                    ans += 1;
                    continue;
            }
        }
        return ans;
    }
}