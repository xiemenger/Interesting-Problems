/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        ListNode slow = head; 
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        
        head2 = reverse(head2);
        ListNode head1 = head;
        while (head2 != null){
            if (head1.val != head2.val){
                return false;
            }
            head2 = head2.next;
            head1 = head1.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode post;
        while (head != null){
            post = head.next;
            
            head.next = pre;
            pre = head;
            head = post;
        }
        return pre;
    }
}