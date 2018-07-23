class Solution {
    Node prev;  // before recursion, it will store prehead, after recursion, it will be the tail.
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return root;
        }
        Node dummy = new Node();
        prev = dummy;
        preOrder(root);
        dummy.right.left = prev;
        prev.right = dummy.right;
        return dummy.right;
    }
    
    private void preOrder(Node root){
        if (root == null){
            return;
        }
        preOrder(root.left);
        root.left = prev;
        prev.right = root;
        prev = root;
        preOrder(root.right);
    }

}
