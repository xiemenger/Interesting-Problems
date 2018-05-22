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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return root;
        }
        if (p.val > q.val){
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        
        TreeNode res = null;
        
        while (root != null){
            if (p.val <= root.val && root.val <= q.val){
                res = root;
                break;
            }
            
            if (q.val < root.val){
                root = root.left;
            } else if (p.val > root.val){
                root = root.right;
            }
        }
        return res;
    }
}