class Solution {
    class result {
        int size;
        int lower;
        int upper;
        
        public result(int size, int lower, int upper){
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
    
    int max;
    public int largestBSTSubtree(TreeNode root) {
        max = 0;
        if (root == null){ return 0; }
        isBST(root);
        return max;
    }

    public result isBST(TreeNode root){
        if (root == null){
            return new result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        result left = isBST(root.left);
        result right = isBST(root.right);
        
        if (left.size < 0 || right.size < 0 || root.val <= left.upper || root.val >= right.lower){
            return new result(-1, 0, 0);
        }
        
        int size = left.size + 1 + right.size;
        int lower = Math.min(left.lower, root.val);
        int upper = Math.max(right.upper, root.val);
        max = Math.max(max, size);
        return new result(size, lower, upper);
    }
}