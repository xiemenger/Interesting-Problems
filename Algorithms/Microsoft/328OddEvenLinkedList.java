/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode evenhead = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        
        while (even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
}