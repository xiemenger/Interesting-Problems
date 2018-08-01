class Solution {
    Integer preVal;
    public boolean isValidBST(TreeNode root) {
       if (root == null){
           return true;
       }
       if (!isValidBST(root.left)){
           return false;
       }
       if (preVal != null && preVal >= root.val){
           return false;  
       }
        preVal = root.val;
       return isValidBST(root.right);
    }
}