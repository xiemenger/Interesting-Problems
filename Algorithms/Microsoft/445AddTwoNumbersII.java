class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        
        while (l1 != null){
            s1.push(l1);
            l1 = l1.next;
        }
        
        while (l2 != null){
            s2.push(l2);
            l2 = l2.next;
        }
        
        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()){
            if (!s1.isEmpty()){
                sum += s1.pop().val;
            }
            
            if (!s2.isEmpty()){
                sum += s2.pop().val;
            }
            list.val = sum % 10;
            sum /= 10;
            ListNode head = new ListNode(sum);
            head.next = list;
            list = head;
        }
        
        return list.val == 0 ? list.next : list;
    }
}