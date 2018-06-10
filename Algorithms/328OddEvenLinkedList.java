class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head.next;
        ListNode node1 = head;
        ListNode node2 = head.next;
        
        while (node2 != null && node2.next != null){
            node1.next = node2.next;
            node2.next = node2.next.next;
            
            node1 = node1.next;
            node2 = node2.next;
        }
        node1.next = dummy.next;
        return head;
    }
}