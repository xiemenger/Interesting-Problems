class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (l1 != null || l2 != null){
            if(l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                carry += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(carry % 10);
            carry = carry / 10;
            tail.next = node;
            tail = node;
        }
        if (carry != 0){
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }
}