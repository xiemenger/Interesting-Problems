class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0){
            return res;
        }
        
        int rs = 0;
        int re = matrix.length - 1;
        int cs = 0;
        int ce = matrix[0].length - 1;
        while (rs <= re && cs <= ce){
            for (int c = cs; c <= ce; c++){res.add(matrix[rs][c]); }
            rs++;
            for (int r = rs; r <= re; r++){res.add(matrix[r][ce]); }
            ce--;
            for (int c = ce; rs <= re && c >= cs; c--){res.add(matrix[re][c]); }
            re--;
            for (int r = re; cs <= ce && r >= rs; r--){res.add(matrix[r][cs]); }
            cs++;
        }
        return res;
    }
}