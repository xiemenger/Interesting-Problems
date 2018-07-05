class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }
    
    private TreeNode construct(int[] nums, int l, int r){
        if (l > r){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int idx = l;
        for (int i = l; i <= r; i++){
            if (max < nums[i]){
                max = nums[i];
                idx = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = construct(nums, l, idx - 1);
        node.right = construct(nums, idx + 1, r);
        return node;
    }
}