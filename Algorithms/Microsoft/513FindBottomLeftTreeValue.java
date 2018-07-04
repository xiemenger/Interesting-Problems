class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = 0;
        while (!q.isEmpty()){
            int size = q.size();
            ans = q.peek().val;
            for (int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if (cur.left != null){
                    q.offer(cur.left);
                }
                if (cur.right != null){
                    q.offer(cur.right);
                }
            }
        }
        return ans;
    }
}