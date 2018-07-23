class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return root;
        }
        Stack<Node> nodes = new Stack<>();
        Node node = root;
        Node head = null;
        Node prev = null;
        while (node != null || !nodes.isEmpty()){
            while (node != null){
                nodes.push(node);
                node = node.left;
            }
            node = nodes.pop();
            if (prev == null){
                head = node;
            }  else {
                node.left = prev;
                prev.right = node;
            }
            prev = node;
            node = node.right;
        }
        head.left = prev;
        prev.right = head;
        return head;
    }
}