class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()){
            double sum = 0;
            int size = q.size();
            for (int i = size; i > 0; i--){
                TreeNode cur = q.poll();
                sum += cur.val;
                if (cur.left != null){ q.offer(cur.left); }
                if (cur.right != null){ q.offer(cur.right); }
            }
            res.add(sum / size);
        }
        return res;
    }
}