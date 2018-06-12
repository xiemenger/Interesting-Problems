class Solution {
    public int rob(TreeNode root) {
        int[] res = backtrack(root);
        return Math.max(res[0], res[1]);
    }
    
    public int[] backtrack(TreeNode root){
        if (root == null){
            return new int[]{0,0};
        }
        
        int[] l = backtrack(root.left);
        int[] r = backtrack(root.right);
        int no = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        int yes = l[1] + r[1] + root.val;
        return new int[]{yes, no};
    }
    
}