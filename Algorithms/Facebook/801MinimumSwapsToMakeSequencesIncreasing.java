/**
 * Three cases:
 * 1) when A[i - 1] >= B[i] || B[i - 1] >= A[i]. 
 *    In this case, no matter what following case is , 
 *    Swap may break the increasing . 
 *    So, if swap the pos i - 1, then must keep the pos i  swap
 *    or if don't swap the post i - 1, neither pos i.
 *    So swp = swp + 1;
 *       noswp = noswp;
 * 
 * 2) When A[i - 1] >= B[i] || B[i - 1] >= B[i]
 *     In this case, In pos i - 1 and i , we must swap one pos.
 *     oldswp = swp;
 *      swp = noswp + 1;
 *      noswp = oldswp;
 * 3) Other cases: swap or keep same, it does not matter.
 *    int min = Math.min(swp, noswp)
 *     swp = min + 1;
 *     noswp = min;
 * 
 */

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