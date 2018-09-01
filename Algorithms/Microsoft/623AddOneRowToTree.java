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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null){return root; }
        if (d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        
        int layer = 2;
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(root);
        
        while (layer < d){
            layer++;
            for (int sz = nodes.size(); sz > 0; sz--){
                TreeNode cur = nodes.poll();
                if (cur.left != null){
                    nodes.offer(cur.left);
                }
                if (cur.right != null){
                    nodes.offer(cur.right);
                }
            }
        }
        
        for (TreeNode node : nodes){
            TreeNode newleft = new TreeNode(v);
            TreeNode newright = new TreeNode(v);
            newleft.left = node.left;
            newright.right = node.right;
            node.left = newleft;
            node.right = newright;
        }
        return root;
    }
}