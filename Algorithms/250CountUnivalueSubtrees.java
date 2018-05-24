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
    
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        countHelper(root, count);
        return count[0];
    }
    
    public boolean countHelper(TreeNode root, int[] count){
        if (root == null){
            return true;
        }
        boolean left = countHelper(root.left, count);
        boolean right = countHelper(root.right, count);
        left = left && (root.left == null? true : root.val == root.left.val);
        right = right && (root.right == null? true : root.val == root.right.val);
        if (left && right){
            count[0]++;
            return true;
        }
        return false;
    }
}