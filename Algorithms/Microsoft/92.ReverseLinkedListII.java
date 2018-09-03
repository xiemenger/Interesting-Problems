class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1; i < m; i++){
            prev = prev.next;
        }
        
        head = prev.next;
        ListNode tail = head.next;
        for (int i = 0; i < (n - m); i++){
            head.next = tail.next;
            tail.next = prev.next;
            prev.next = tail;
            tail = head.next;
        }
        return dummy.next;
    }
}