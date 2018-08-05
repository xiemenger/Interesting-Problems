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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int pStart, int[] inorder, int iStart, int iEnd){
        //System.out.println(pStart+", "+iStart+", "+iEnd);
        if (pStart > preorder.length - 1 || iStart > iEnd){return null;}
        if (iStart == iEnd){ return new TreeNode(inorder[iStart]); }
        int idx = iStart;
        for (; idx < iEnd; idx++){
            if (inorder[idx] == preorder[pStart]){ break; }
        }
        TreeNode node = new TreeNode(preorder[pStart]);
        node.left = build(preorder, pStart+1, inorder, iStart, idx - 1);
        node.right = build(preorder, pStart + (idx - iStart + 1), inorder, idx+1, iEnd);
        return node;
    }
}