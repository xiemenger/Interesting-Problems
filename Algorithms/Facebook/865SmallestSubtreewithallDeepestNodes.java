class Solution {
    int maxDepth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return root;
        }
        maxDepth = 0;
        Map<TreeNode,Integer> depthsMap = new HashMap<>();
        getDepth(root, 0, depthsMap);
        return getLowestCommonAncestor(root, depthsMap);
    }
    
    private void getDepth(TreeNode root, int depth, Map<TreeNode,Integer> depthsMap){
        if (root == null){
            return;
        }
        depthsMap.put(root, depth);
        maxDepth = Math.max(maxDepth, depth);
        getDepth(root.left, depth + 1, depthsMap);
        getDepth(root.right, depth + 1, depthsMap);
    }
    
    private TreeNode getLowestCommonAncestor(TreeNode root, Map<TreeNode,Integer> depthsMap){
        if (root == null || depthsMap.get(root) == maxDepth){
            return root;
        } 
        TreeNode left = getLowestCommonAncestor(root.left, depthsMap);
        TreeNode right = getLowestCommonAncestor(root.right, depthsMap);
        if (left != null && right != null){ return root; }
        return left != null ? left : right;
    }
}