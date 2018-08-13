class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null){
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }
        Node cur = head;
        while (true){
            if (cur.val < cur.next.val){ // at climbing 
                if(cur.val <= insertVal && insertVal <= cur.next.val){
                    insertAfter(cur, insertVal);
                    break;
                }
            } else if (cur.val > cur.next.val){  // at tipping point
                if (cur.val <= insertVal || insertVal <= cur.next.val){
                    insertAfter(cur, insertVal);
                    break;
                }
            } else {  // no tipping point at all
                if (cur.next == head){
                    insertAfter(cur, insertVal);
                    break;
                }
            }
            cur = cur.next;
        }
        return head;
    }
    
    private void insertAfter(Node cur , int val){
        Node node = new Node(val, cur.next);
        cur.next = node;
    }
}