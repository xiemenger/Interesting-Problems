class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0){
            return new int[0];
        }
        int n = digits.length;
        int idx = n - 1;
        while (idx >= 0){
            if (digits[idx] < 9){
                digits[idx]++;
                break;
            }
            digits[idx] = 0;
            idx--;
        }
        
        if (idx == -1){
            int[] res = new int[n + 1];
            res[0] = 1;
            return res;
        }
        int[] res = new int[n];
        
        for(int i = 0; i < n; i++){
            res[i] = digits[i];
        }
        return res;
    }
}