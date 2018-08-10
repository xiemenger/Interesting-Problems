class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0;
        int cnt = 0;
        int maxLen = 0;
        for (int i = 2; i < A.length; i++){
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]){
                cnt++;
               // maxLen = Math.max(maxLen, cnt + 2);
                sum += cnt;
            } else {
                cnt = 0;
            }
        }
        //System.out.println(maxLen);
        return sum;
    }
}