class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (cur.left != null){
                if (cur.left.left == null && cur.left.right == null){
                    sum += cur.left.val;
                } else {
                    stack.push(cur.left);
                }
                
            }
            if (cur.right != null){
                stack.push(cur.right);
            }
        }
        return sum;
    }
    
    public int sumOfLeftLeaves2(TreeNode root) {
        int[] count = new int[1];
        iterate(root, false, count);
        return count[0];
    }
    
    private void iterate(TreeNode root, boolean left, int[] count){
        if (root == null){
            return;
        }
        if (left && root.left == null && root.right == null){
            count[0] += root.val;
        }
        iterate(root.left, true, count);
        iterate(root.right, false, count);
    }
}