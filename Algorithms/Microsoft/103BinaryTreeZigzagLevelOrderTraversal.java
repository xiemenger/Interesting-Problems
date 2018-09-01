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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(root);
        boolean rightToLeft = false;
        while (!nodes.isEmpty()){
            List<Integer> layer = new LinkedList<>();
            for (int sz = nodes.size(); sz > 0; sz--){
                TreeNode cur = nodes.poll();
                if (rightToLeft){
                    layer.add(0, cur.val);
                } else {
                    layer.add(cur.val);
                }
                
                if (cur.left != null){
                    nodes.offer(cur.left);
                }
                if (cur.right != null){
                    nodes.offer(cur.right);
                }
            }
            res.add(layer);
            rightToLeft = !rightToLeft;
        }
        return res;
    }
}