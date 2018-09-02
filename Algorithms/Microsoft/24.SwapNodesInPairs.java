class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null){
            ListNode first = prev.next;
            ListNode second = first.next;
            ListNode post = second.next;
            
            prev.next = second;
            second.next = first;
            first.next = post;
            
            prev = first;
        }
        return dummy.next;
    }
}