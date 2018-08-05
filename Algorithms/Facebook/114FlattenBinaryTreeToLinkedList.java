class Solution {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null){ return; }
        build(root);
    }
   
    private void build(TreeNode root){
        if (root == null){ return; }
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        if (pre != null){
            pre.right = root;
        }
        pre = root;
        build(left);
        build(right);
    }
}