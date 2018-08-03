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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){ return res; }
        findPathSum(root, sum, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void findPathSum(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res){
       if (root == null){ return; }
       
        list.add(root.val);
       if (root.left == null && root.right == null && sum == root.val){
           res.add(new ArrayList<>(list));
       }
        sum = sum - root.val;
        findPathSum(root.left, sum, list, res);
        findPathSum(root.right, sum, list, res);
        list.remove(list.size() - 1);
    }
}