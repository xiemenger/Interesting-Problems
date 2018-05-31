class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> smallers = new Stack<>();
        Stack<Integer> largers = new Stack<>();
        traverse(root, target, true, smallers);
        traverse(root, target, false, largers);
        
        while (k-- > 0){
            if (smallers.isEmpty()){
                res.add(largers.pop());
            } else if (largers.isEmpty()){
                res.add(smallers.pop());
            } else if (target - smallers.peek() < largers.peek() - target){
                res.add(smallers.pop());
            } else {
                res.add(largers.pop());
            }
        }
        
        return res;
    }
    
    public void traverse(TreeNode root, double t, boolean preOrder, Stack<Integer> stack){
        if (root == null){
            return;
        }
        
        traverse(preOrder? root.left : root.right, t, preOrder, stack);
        if (preOrder && root.val >= t || !preOrder && root.val < t){
            return;
        }
        stack.push(root.val);
        traverse(preOrder? root.right : root.left, t, preOrder, stack);
    }
}