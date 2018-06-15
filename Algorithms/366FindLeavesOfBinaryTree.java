class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        findheight(root, res);
        return res;
    }
    
    public int findheight(TreeNode root, List<List<Integer>> res){
        if (root == null){
            return 0;
        }
        int height = 1 + Math.max(findheight(root.left, res), findheight(root.right, res));
        if (res.size() < height){
            res.add(new ArrayList<>());
        }
        res.get(height - 1).add(root.val);
        return height;
    }
    
}