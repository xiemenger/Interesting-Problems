class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0){
            return 1;
        }
        
        int res = 10;
        int unique = 9;
        int availableNum = 9;
        
        while (n > 1 && availableNum > 1){
            unique = unique * availableNum;
            availableNum--;
            res += unique;
            n--;
        }
        return res;
    }
}