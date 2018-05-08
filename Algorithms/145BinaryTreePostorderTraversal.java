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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null){
            if (node != null){
                res.addFirst(node.val);
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop().left;
            }
        }
        return res;
    }
    
    public List<Integer> postorderTraversal_Recursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        postOrderTrack(root, res);
        return res;
    }
    
    private void postOrderTrack(TreeNode root, List<Integer> res){
        if (root.left != null){
            postOrderTrack(root.left, res);
        }
        if (root.right != null){
            postOrderTrack(root.right, res);
        }
        res.add(root.val);
    }
}