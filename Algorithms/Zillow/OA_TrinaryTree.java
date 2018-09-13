/**
 * Question 2) Implement insert and delete in a tri-nary tree. 
 * A tri-nary tree is much like a binary tree but with three child nodes 
 * for each parent instead of two -- with the left node being values
less than the parent, the right node values greater than the parent, 
and the middle nodes values equal to the parent.

For example, suppose I added the following nodes to the tree in this 
order: 5, 4, 9, 5, 7, 2, 2. 
The resulting tree would look like this:
    5
  / | \
4   5  9
/      /
2     7
|
2
 */


 class TrinaryTree{

    public Node Delete(int value){

    }

    private Node Delete(Node node, int value){
        if (node.value > value){
            Delete(node.right, value);
        } else if (node.value < value){
            Delete(node.left, value);
        } else {
          if (node.mid != null){
            Delete(node.mide, value);
          } else if (node.right != null){

          } else {
              node = node.left;
          }
        }
        return node;
    }
 }

 class Node{
     Node left;
     Node mid;
     Node right;
     int value;

     public Node(int value){
         this.value = value;
     }
 }