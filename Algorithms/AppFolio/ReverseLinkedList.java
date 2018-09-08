/**
 * Two method, 
 * Iterate
 * Recursive
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    
    
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode post = null;
        while (head != null){
            post = head.next;
            head.next = pre;
            pre = head;
            head = post;
        }
        return pre;
    }
}