class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int F = 0;
        int sum = 0;
        int n = A.length;
        for (int i = 0; i < n; i++){
            F += A[i] * i;
            sum += A[i];
        }
        
        int max = F;
        for (int i = 1; i < n; i++){
            F = F + sum - A[n - i] * n;
            max = Math.max(max, F);
        }
        return max;
    }
}