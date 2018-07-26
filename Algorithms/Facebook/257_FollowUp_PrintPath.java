class Solution {
    public void binaryTreePaths(TreeNode root) {
        Map<TreeNode, Integer> cols = new HashMap<>();
        getColsForNodes(root, cols, 0);
        print(root, cols, new ArrayList<>());
        
    }
    
    private void print(TreeNode root, Map<TreeNode, Integer> cols, List<TreeNode> path){
        if (root == null){
            return;
        }
        path.add(root);
        if (root.left == null && root.right == null){
            int tmpMin = Integer.MAX_VALUE;
            for (int i = 0; i < path.size(); i++){
                tmpMin = Math.min(cols.get(path.get(i)), tmpMin);
            }
            for (int i = 0; i < path.size(); i++){
                int space = tmpMin;
                TreeNode cur = path.get(i);
                int spaceTotal = cols.get(cur);
                while (space++ < spaceTotal){
                    System.out.print(" ");
                }
                System.out.println(cur.val);
            }
            System.out.println(" -------------------- ");
        }
        print(root.left, cols, path);
        print(root.right, cols, path);
        path.remove(path.size() - 1);
    }
    
    private void getColsForNodes(TreeNode root, Map<TreeNode, Integer> cols, int col){
        if (root == null){
            return;
        }
        cols.put(root, col);
        minCol = Math.min(minCol, col);
        getColsForNodes(root.left, cols, col - 1);
        getColsForNodes(root.right, cols, col + 1);    
    }
}