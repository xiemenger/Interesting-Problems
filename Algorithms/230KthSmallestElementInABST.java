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
    public int kthSmallest(TreeNode root, int k) {
        if (root == null){
            return 0;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode cur = root;
        int res = 0;
        while (!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                count++;
                if (count == k){
                    res = cur.val;
                    break;
                }
                cur = cur.right;
            }
        }
        return res;
    }
    

}