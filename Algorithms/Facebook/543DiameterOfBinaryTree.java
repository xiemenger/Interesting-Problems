class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        search(root, max);
        return max[0];
    }
    
    private int search(TreeNode root, int[] max){
        if (root == null){
            return 0;
        }
        
        int left = search(root.left, max);
        int right = search(root.right, max);
        max[0] = Math.max(max[0], left + right);
        return 1+Math.max(left, right);
    }   
}