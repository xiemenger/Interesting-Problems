class Solution {
    int max;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null){
            return 0;
        }
        max = 0;
        len(root, root.val);
        return max;
    }
    
    private int len(TreeNode root, int parentVal){
        if (root == null){ return 0; }
        int l = len(root.left, root.val);
        int r = len(root.right, root.val);
        
        max = Math.max(max, l + r);
        if (root.val == parentVal){
            return Math.max(l, r) + 1;
        } 
        
        return 0;
    }
}