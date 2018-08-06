class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> plusAB = new HashMap<>();
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                plusAB.put(A[i]+B[j], plusAB.getOrDefault(A[i]+B[j], 0) + 1);
            }
        }
        
        for (int i = 0; i < C.length; i++){
            for (int j = 0; j < D.length; j++){
                res += plusAB.getOrDefault(-(C[i]+D[j]), 0);
            }
        }
        return res;
    }
}