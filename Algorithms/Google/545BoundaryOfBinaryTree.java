class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){return res; }
        //add left boundary
        if (!isLeaf(root)){ res.add(root.val); }
        TreeNode node = root.left;
        while (node != null ){
            if (!isLeaf(node)){
                res.add(node.val);
            }
            
            if (node.left != null){
                node = node.left;
            } else {
                node = node.right;
            }
        }
        
        // add leaves.
        addLeaves(root, res);
        
        // add right bound.
        List<Integer> rights = new ArrayList<>();
        node = root.right;
        while (node != null){
            if (!isLeaf(node)){
                rights.add(node.val);
            }
            
            if (node.right != null){
                node = node.right;
            } else {
                node = node.left;
            }
        }
        for (int i = rights.size() - 1; i >= 0; i--){
            res.add(rights.get(i));
        }
        return res;
    }
    
    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
    
    private void addLeaves(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        if (isLeaf(root)){
            res.add(root.val);
            return;
        }
        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }
    
}