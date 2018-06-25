class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return traverse(root, k, set);
    }
    
    private boolean traverse(TreeNode root, int k, Set<Integer> set){
        if (root == null){
            return false;
        }
        if (set.contains(k - root.val)){
            return true;
        }
        set.add(root.val);
    
        return traverse(root.left, k, set) || traverse(root.right, k, set);
    }
}