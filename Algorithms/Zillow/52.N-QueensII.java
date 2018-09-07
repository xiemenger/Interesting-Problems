/**
   在表格里填入值看是否有效.
   典型dfs解法
   
   因为两个queen不能放在同一行, 同一列, 同一45度角的cells, 同135度角的cells.
   所以我们要考虑四个角度的有效性.
   在做DFS, 我们可以考虑采用row来作为一层层的递推. 只有这一行中, 找到了正确的位置, 我们才尝试下一行.  其他三维我们就用三个array来记录是否被占用.
   对于列: 我们有n列, 所以我们可以用cols[n] 的数组来记录 cols[i] 记录 i列是否有queen了.
   对于45°角的:  在n*n的矩阵中, 我们有(2 * n - 1) 45°角的列, 可以用diag45[2*n - 1] 来记录被占用情况.
   对于135°角的: 在n*n的矩阵中, 我们有(2 * n - 1) 135°角的列, 可以用diag135[2*n - 1]来记录被占用情况.
   
   在做DFS时, 对col从0 - n-1 来枚举, 把queen放在哪个col是有效的. 如果无效, 就试下一个col的值. 
   
   当我们的row = n时, 说明我们找到了一种有效放置queen的方法, 这个时候就可以cnt++, return. 
   继续dfs...
   
   Time: O(n),
   Space: O(n). 
   
*/

class Solution {
    int cnt;
    public int totalNQueens(int n) {
        cnt = 0;
        boolean[] cols = new boolean[n];
        boolean[] diag45 = new boolean[2 * n - 1];
        boolean[] diag135 = new boolean[2 * n - 1];
        check(0, cols, diag45, diag135, n);
        return cnt;
    }
    
    private void check(int row, boolean[] cols, boolean[] diag45, boolean[] diag135, int n){
        if (row == n){
            cnt++;
            return;
        }
        for (int col = 0; col < n; col++){
            int idx45 = row + col;
            int idx135 = n - 1 + col - row;
            if (cols[col] || diag45[idx45] || diag135[idx135]){
                continue;
            }
            cols[col] = true;
            diag45[idx45] = true;
            diag135[idx135] = true;
            check(row + 1, cols, diag45, diag135, n);
            cols[col] = false;
            diag45[idx45] = false;
            diag135[idx135] = false;
        }
    }
}