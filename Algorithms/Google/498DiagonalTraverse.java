class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return new int[0];
        }
        int i = 0;
        int j = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        
        for (int k = 0; k < res.length; k++){
            res[k] = matrix[i][j];
            if ((i + j) % 2 == 0){ // move up
                if (j == n - 1){ i++; }
                else if (i == 0){ j++; }
                else {
                    i--;
                    j++;
                }
            } else {  // move down
                if (i == m - 1){ j++; }
                else if (j == 0){ i++; }
                else {
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}