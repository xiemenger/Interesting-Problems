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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightView(root, res, 0);
        return res;
    }
    
    public void rightView(TreeNode cur, List<Integer> res, int depth){
        if (cur == null){
            return;
        }
        if (depth == res.size()){
            res.add(cur.val);
        }
        rightView(cur.right, res, depth+1);
        rightView(cur.left, res, depth+1);
    }
    
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if (cur.left != null){
                    queue.offer(cur.left);
                }  
                if (cur.right != null){
                    queue.offer(cur.right);
                }
                if (i == size - 1){
                    res.add(cur.val);
                }
            }
        }
        return res;
    }
}