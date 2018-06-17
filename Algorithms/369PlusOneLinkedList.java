class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        slow.next = head;
        ListNode fast = head;
        while (fast != null){
            if (fast.val != 9){
                slow = fast;
            }
            fast = fast.next;
        }
        slow.val += 1;
        fast = slow;
        while (fast.next != null){
            fast = fast.next;   
            fast.val = 0;
        }
        
        return slow ==  dummy ? dummy : head;
    }
}