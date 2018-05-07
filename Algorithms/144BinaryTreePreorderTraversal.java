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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        
        Stack<TreeNode> rightNodes = new Stack<>();
        TreeNode node = root;
        while(node != null){
            res.add(node.val);
            if (node.right != null){
                rightNodes.push(node.right);
            }
            node = node.left;
            
            if (node == null && !rightNodes.isEmpty()){
                node = rightNodes.pop();
            }
        }
        return res;
    }
}