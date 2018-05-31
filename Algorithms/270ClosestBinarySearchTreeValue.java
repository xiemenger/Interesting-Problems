class Solution {
    public int closestValue(TreeNode root, double target) {
        int min = root.val;
        double minValue = Math.abs(root.val - target);
        TreeNode node = root;
        while (node != null){
            if (Math.abs(node.val - target) < minValue){
                min = node.val;
                minValue = Math.abs(node.val - target);
            }
            if (node.val > target){
                node = node.left;
            } else {
                node =node.right;
            }
        }
        return min;
    }
    
    
}