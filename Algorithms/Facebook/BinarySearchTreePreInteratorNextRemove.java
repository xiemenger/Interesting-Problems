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
		next();
		next();
		next();
		next();
		next();
		remove();
	}
	
    static Queue<TreeNode> nodes;
    static Queue<TreeNode> roots;
	 static TreeNode preVisited = null;
	 static TreeNode preVisitedRoot = null;
	    public static void BSTIterator(TreeNode root) {
           nodes = new LinkedList<>();
           roots = new LinkedList<>();
           roots.offer(new TreeNode(-1));
	        storeNodesInQueue(root);
	        while (!nodes.isEmpty()){
	            System.out.print(nodes.poll().val+"->");
	        }
           System.out.println("done");
           while (!roots.isEmpty()){
               TreeNode cur = roots.poll();
               if (cur == null){System.out.print("null->"); continue; }
	            System.out.print(cur.val+"->");
	        }
	        System.out.println("done");
	        roots.offer(new TreeNode(-1));
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
            preVisitedRoot = roots.poll();
            return preVisited.val;
	        
	    }
	    
	    public static void remove() {
            removeSubTree(preVisited);
            
            if (preVisitedRoot == null) {
                System.out.println("root is null");
                return;
            } 
            if (preVisitedRoot.left == preVisited) {
                preVisitedRoot.left = null;
            } else {
                preVisitedRoot.right = null;
            }
	    }
	    
	    public static void removeSubTree(TreeNode node){
            if(nodes.isEmpty()) {
                return;
            }
            if (node != preVisited) {
                node = nodes.poll();
            }
            if (node.left != null) { removeSubTree(node.left); }
            if (node.right != null) {  removeSubTree(node.right); }
	    }
	    
	    private static void storeNodesInQueue(TreeNode root){
	    	 	if (root == null){ return; }
	            nodes.offer(root);
	            if (root.left != null){
	                roots.offer(root);
	                storeNodesInQueue(root.left);
	            }
		        if (root.right != null){
	                roots.offer(root);
	                storeNodesInQueue(root.right);
	            }
	    }
	    
	    public static class TreeNode {
	    	      int val;
	    	      TreeNode left;
	    	      TreeNode right;
	    	      TreeNode(int x) { val = x; }
             }
}