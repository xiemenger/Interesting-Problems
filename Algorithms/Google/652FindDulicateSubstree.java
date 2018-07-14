class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        check(root, new HashMap<>(), res);
        return res;
    }
    
    private String check(TreeNode root, Map<String, Integer> map, List<TreeNode> res){
        if (root == null){
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(',');
        sb.append(check(root.left, map, res));
        sb.append(',');
        sb.append(check(root.right, map, res));
        String s = sb.toString();
        if (map.getOrDefault(s,  0) == 1){
            res.add(root);
        }
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }

}