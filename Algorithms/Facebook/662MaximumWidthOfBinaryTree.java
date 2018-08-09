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
    int maxWidth;
    public int widthOfBinaryTree(TreeNode root) {
        maxWidth = 0;
        computeWidth(root, 0, 1, new ArrayList<>(), new ArrayList<>());
        return maxWidth;
    }
    
    private void computeWidth(TreeNode node, int level, int idx, 
                             List<Integer> starts, List<Integer> ends){
        if (node == null){ return; }
        if (level == starts.size()){
            starts.add(idx);
            ends.add(idx);



            
        } else {
            ends.set(level, idx);
        }
        maxWidth = Math.max(maxWidth, ends.get(level) - starts.get(level) + 1);
        
        computeWidth(node.left, level + 1, 2 * idx, starts, ends);
        computeWidth(node.right, level + 1, 2 * idx + 1, starts, ends);
        
    }
}