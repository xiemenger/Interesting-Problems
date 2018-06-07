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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){ return res; }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        q.offer(root);
        col.offer(0);
        
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            int curCol = col.poll();
            if (!map.containsKey(curCol)){
                map.put(curCol, new ArrayList<>());
            }
            map.get(curCol).add(cur.val);
            min = Math.min(curCol, min);
            max = Math.max(curCol, max);
            
            if (cur.left != null){
                q.offer(cur.left);
                col.offer(curCol - 1);
            }
            if (cur.right != null){
                q.offer(cur.right);
                col.offer(curCol + 1);
            }
        }
        
        
        for (int i = min; i <= max; i++){
            res.add(map.get(i));
        }
        return res;
    }
    
}