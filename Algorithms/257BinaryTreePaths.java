class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        
        traversal(root, res, "");
        return res;
            
    }
    
    public void traversal(TreeNode root, List<String> res, String cur){
        if (root.left == null && root.right == null){
            res.add(cur+root.val);
            return;
        }
        if (root.left != null){
            traversal(root.left, res, cur+root.val+"->");
        }
        if (root.right != null){
            traversal(root.right, res, cur+root.val+"->");
        }
    }
}