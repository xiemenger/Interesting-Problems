class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }
    
    private boolean traverse(TreeNode r1, TreeNode r2){
        return r1 != null && (equals(r1, r2) || traverse(r1.left, r2) || traverse(r1.right, r2));
    }
    
    private boolean equals(TreeNode n1, TreeNode n2){
        if (n1 == null && n2 == null){
            return true;
        }
        if (n1 == null || n2 == null){
            return false;
        }
        return n1.val == n2.val && equals(n1.left, n2.left) && equals(n1.right, n2.right);
    }
}