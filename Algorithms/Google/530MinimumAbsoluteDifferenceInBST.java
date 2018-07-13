class Solution {
    int min;
    Integer last;
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        inorder(root);
        return min;
    }
    
    private void inorder(TreeNode root){
        if (root == null){
            return;
        }
        
        inorder(root.left);
        if (last == null){
            last = root.val;
        } else {
            min = Math.min(min, root.val - last);
        }
            
        last = root.val;
        inorder(root.right);
    }
}