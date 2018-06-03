class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null){
            return 0;
        }
        int[] max = new int[1];
        max[0] = 1;
        traverse(root, max, 1, root.val);
        System.out.println();
        return max[0];
    }
    
    public void traverse(TreeNode root, int[] max, int len, int preVal){
        if (root == null){
            return;
        }
        if (root.val == preVal + 1){
            len += 1;
            max[0] = Math.max(len, max[0]);
        } else {
            len = 1;
        }
        traverse(root.left, max, len, root.val);
        traverse(root.right, max, len, root.val);
    }
}