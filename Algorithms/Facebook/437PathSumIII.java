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
    public int pathSum(TreeNode root, int sum) {
        if (root == null){ return 0; }
        return searchPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int searchPath(TreeNode root, int sum ){
        if (root == null){ return 0; }
        int cnt = 0;
        if(sum - root.val == 0){
            cnt += 1;
        }
        cnt += searchPath(root.left, sum - root.val);
        cnt += searchPath(root.right, sum - root.val);
        return cnt;
    }
}