/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        int h = computeHeight(root);
        if (h == 0){
            return 0;
        }
        int nodes = 0;
        while (root != null){
            int rh = computeHeight(root.right);
            if (h == rh + 1){
                nodes += 1 << rh; 
                root = root.right;
            } else {
                nodes += 1 << (h - 2);
                root = root.left;
            }
            h--;
        }
        return nodes;
    }
    
    
    public int countNodes2(TreeNode root) {
        int rootHeight = computeHeight(root);
        if (rootHeight == 0){
            return 0;
        }
        int rightHeight = computeHeight(root.right);
        
        // the last node is in the right substree.
        // left tree is a full tree with height (root height - 1);
        if (rootHeight == rightHeight + 1){
            return (1 << rightHeight) + countNodes(root.right);
        } else {
        
        // the last node is in the left substree.
        // right substree is a full tree with height (root height - 2)
            return (1 << (rootHeight - 2)) + countNodes(root.left);
        }
        
        
    }
    
    public int computeHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + computeHeight(root.left);
    }
}