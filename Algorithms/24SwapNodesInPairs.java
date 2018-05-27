class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;
        while (pre.next != null && pre.next.next != null){
            tail = pre.next.next;
            ListNode post = tail.next;
            
            // swap
            tail.next = pre.next;
            pre.next.next = post;
            pre.next = tail;
            
            pre = pre.next.next;
        }
        return dummy.next;
    }
}