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
    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        int[] sum = new int[1];
        sum[0] = 0;
        pathSum(root, sum, 0);
        return sum[0];
    }
    
    public void pathSum(TreeNode root, int[] sum, int tmpSum){
        tmpSum = tmpSum * 10 + root.val;
        if (root.right == null && root.left == null){
            System.out.println("root:"+root.val);
            sum[0]+= tmpSum;
            return;
        }
        
        if (root.left != null){
            pathSum(root.left, sum, tmpSum);
        }
        if (root.right != null){
            pathSum(root.right, sum, tmpSum);
        }
    }
}

