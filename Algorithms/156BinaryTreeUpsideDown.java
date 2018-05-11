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
    // Time O(n); space: O(1)
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode preRight = null;
        TreeNode pre = null;
        TreeNode next = null;
        
        while(cur != null){
            next = cur.left;
            
            cur.left = preRight;
            preRight = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }    
    
    // Time O(n); space: O(log(n))
    public TreeNode upsideDownBinaryTree1(TreeNode root) {
        if (root == null || root.left == null){
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        
        return newRoot;
    }
}