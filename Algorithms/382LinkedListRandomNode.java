class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    java.util.Random rand;
    ListNode h;
    public Solution(ListNode head) {
        rand = new java.util.Random();
        h = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode node = h;
        ListNode res = node;
        int n = 1;
        while (node.next != null){
            if (rand.nextInt(n+1) == n){
                res = node;
            }
            node = node.next;
            n++;
        }
        return res.val;
    }
}