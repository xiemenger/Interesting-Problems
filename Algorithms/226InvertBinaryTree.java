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
    public TreeNode invertTree(TreeNode root){
        if (root == null){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
    
    
    public TreeNode invertTree1(TreeNode root){
        invertTreeHelper(root);
        return root;
    }
    
    public void invertTreeHelper(TreeNode root){
        if (root == null){
            return;
        }
        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
    
    public TreeNode invertTree2(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}