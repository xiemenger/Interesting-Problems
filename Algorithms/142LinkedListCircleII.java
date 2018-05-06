/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean isCircle = false;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                isCircle = true;
                break;
            }
        }
        if (isCircle){
            slow = head;
            while (slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        } else {
            return null;
        }
    }
}