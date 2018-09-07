/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Integer preVal;
    public boolean isValidBST(TreeNode root) {
       if (root == null){return true; }
       if (!isValidBST(root.left)){return false;}
       if (preVal != null && root.val <= preVal){
           return false;
       }
        preVal = root.val;
        return isValidBST(root.right);
    }
}