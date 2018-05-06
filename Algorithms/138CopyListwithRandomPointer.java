/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return head;
        }
        
        RandomListNode node1 = head;
        RandomListNode node2 = node1;
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = node1;
        
        // Copy node
        while(node1 != null){
            RandomListNode newNode = new RandomListNode(node1.label);
            node2 = node1.next;
            node1.next = newNode;
            newNode.next = node2;
            
            node1 = node2;
        }
        
        node1 = head;
        // Copy random pointer;
        while (node1 != null){
            if (node1.random != null){
                node1.next.random = node1.random.next;
            }
            node1 = node1.next.next;
        }
        
        // Separate
        node1 = head;
        dummy.next = node1.next;
        while (node1 != null){
            node2 = node1.next;
            node1.next = node2.next;
            if (node1.next != null){
                node2.next = node1.next.next;
            }
            node1 = node1.next;
        }
        
        return dummy.next;     
    }
}
