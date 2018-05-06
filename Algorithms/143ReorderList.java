/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        
        // break list
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second list
        ListNode secondListHead = slow.next;
        secondListHead = reverseList(secondListHead);
        
        // Merge two lists
        slow.next = null;
        ListNode firstListHead = head;
        ListNode secondNext = secondListHead;
        while (firstListHead != null && secondListHead != null){
            secondNext = secondListHead.next;
            
            secondListHead.next = firstListHead.next;
            firstListHead.next = secondListHead;
            
            firstListHead = secondListHead.next;
            secondListHead = secondNext;
        }    
    }
    
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newNext = null;
        while (head != null){
            ListNode oldNext = head.next;
            head.next = newNext;
            
            newNext = head;
            head = oldNext;
        } 
        return newNext; 
    }
}