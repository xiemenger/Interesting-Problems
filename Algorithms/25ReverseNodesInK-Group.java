/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k){
            cur = cur.next;
            count++;
        }
        
        if (count == k){
            cur = reverseKGroup(cur, count);
            
            while (count -- > 0){
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;                
            }
            head = cur;
        }
        return head;
    }
}