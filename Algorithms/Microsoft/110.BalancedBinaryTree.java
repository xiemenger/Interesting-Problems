class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null){ return true; }
        return checkHeight(root) != -1;
    }
    
    public int checkHeight(TreeNode root){
        if (root == null){return 0; }
        int ldepth = checkHeight(root.left);
        if (ldepth == -1){return -1; } 
        int rdepth = checkHeight(root.right);
        if (rdepth == -1){return -1; }
        if (Math.abs(ldepth - rdepth) > 1){
            return -1;
        }
        return Math.max(ldepth, rdepth) + 1;
    }
}