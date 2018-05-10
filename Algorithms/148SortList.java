/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        
        // divide into two half:
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode half2 = slow.next;
        slow.next = null;
        
        // sort each half
        
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(half2);
        
        // merge two halfs;
        return merge(head1, head2);
    }
    
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 != null && head2 != null){
            if (head1.val <= head2.val){
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null){
            tail.next = head1;
        }
        if (head2 != null){
            tail.next = head2;
        }
        return dummy.next;
    }
}