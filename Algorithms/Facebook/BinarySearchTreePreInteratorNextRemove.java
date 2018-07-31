import java.util.*;
public class FBIteratorBSTPreOrderNextRemove {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node5 = new TreeNode(5);
		root.left = node2;
		root.right = node5;
		node2.left = node1;
		node2.right = node3;
		BSTIterator(root);
		System.out.println("hasNext? "+hasNext());
		System.out.println("Next? "+ next());
		System.out.println("remove? ");
		remove();
		System.out.println("hasNext? "+hasNext());
		//System.out.println("Next? "+ next());
	}
	
	 static Queue<TreeNode> nodes;
	 static TreeNode preVisited = null;
	    public static void BSTIterator(TreeNode root) {
	        nodes = new LinkedList<>();
	        storeNodesInQueue(root);
	        while (!nodes.isEmpty()){
	            System.out.print(nodes.poll().val+"->");
	        }
	        System.out.println("done");
	        storeNodesInQueue(root);
	    }
	    
	    public static boolean hasNext() {
	        return !nodes.isEmpty();
	    }
	    
	    public static int next() {
	    	    if (nodes.isEmpty()) {
	    	    		return -1;
	    	    }
	    		preVisited = nodes.poll();
	    		return preVisited.val;
	        
	    }
	    
	    public static void remove() {
	    		if (nodes.isEmpty()) {return; }
	    		System.out.print(" removed "+preVisited.val);
	    		removeSubTree(preVisited);
	    		System.out.println(" removed done");
	    }
	    
	    public static void removeSubTree(TreeNode node){
	    		if (node != preVisited) {
	    			node = nodes.poll();
	    			System.out.print(" removed "+node.val+",");
	    		}
	    		if (node.left != null) { removeSubTree(node.left); }
	    		if (node.right != null) {  removeSubTree(node.right); }
	    }
	    
	    private static void storeNodesInQueue(TreeNode root){
	        if (root == null){ return; }
	        nodes.offer(root);
	        storeNodesInQueue(root.left);
	        storeNodesInQueue(root.right);
	    }
	    
	    public static class TreeNode {
	    	      int val;
	    	      TreeNode left;
	    	      TreeNode right;
	    	      TreeNode(int x) { val = x; }
	    	 }

}
