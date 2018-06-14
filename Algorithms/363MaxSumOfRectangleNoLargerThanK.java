class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        
        // iterate cols: i is left.
        for (int i = 0; i < n; i++){
            
            // compute the sum, each cell value is the sum from i to j;
            int[] sum = new int[m];
            
            // iterate cols: j is right;
            for (int j = i; j < n; j++){
                
                // add cur value to sum[i];
                for (int r = 0; r < m; r++){
                    sum[r] += matrix[r][j];
                }
                
                // for cur area cols from i to j, find maxmum rectanglar that sum is most less and close to k;
                res = findSumCloseToK(sum, res, k);
                if (res == k){ return k;}
            }
        }
        return res;
    }
    
    public int findSumCloseToK(int[] num, int res, int k){
        TreeSet<Integer> treeSet = new TreeSet<>();
        int m = num.length;
        int sum = 0;
        treeSet.add(0);
        
        for (int i = 0; i < m; i++){
            sum += num[i];
            Integer presum = treeSet.ceiling(sum-k);
            if (presum != null){
                res = Math.max(res, sum-presum);
            }
            treeSet.add(sum);
        }
        return res;
    }
}