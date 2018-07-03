class Solution {
    public int minSwap(int[] A, int[] B) {
        int swp = 1;
        int noswp = 0;
        
        for (int i = 1; i < A.length; i++){
            if (A[i - 1] >= B[i] || B[i - 1] >= A[i]){
                swp = swp + 1;
            } else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]){
                int oldswp = swp;
                swp = noswp + 1;
                noswp = oldswp;
            } else {
                int min = Math.min(noswp, swp);
                swp = min + 1;
                noswp = min;
            }
        }
        return Math.min(swp, noswp);
    }
}