
class Solution {
11
    public boolean findTarget(TreeNode root, int k) {
12
        Set<Integer> set = new HashSet<>();
13
        return traverse(root, k, set);
14
    }
15
    
16
    private boolean traverse(TreeNode root, int k, Set<Integer> set){
17
        if (root == null){
18
            return false;
19
        }
20
        if (set.contains(k - root.val)){
21
            return true;
22
        }
23
        set.add(root.val);
24
    
25
        return traverse(root.left, k, set) || traverse(root.right, k, set);
26
    }
27
}
  Custom Testcase( Contribute  )
Submis