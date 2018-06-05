class NumArray {
    private segementTreeNode root;
    private int[] arr;
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0){ return; }
        arr = nums;
        root = buildTree(arr, 0, arr.length - 1);
    }
    
    public void update(int i, int val) {
        int diff = val - arr[i];
        arr[i] = val;
        updateTree(root, i, diff, 0, arr.length - 1);
    }
    
    public int sumRange(int i, int j) {
        return searchSum(root, i, j, 0, arr.length - 1);
    }
    
    private int searchSum(segementTreeNode root, int i, int j, int l, int r){
        if (i <= l && j >= r ){
            return root.val; 
        }
        if (i > r || j < l){ return 0; 
                           }
        int m = l + (r - l) / 2;
        return searchSum(root.left, i, j, l, m) + searchSum(root.right, i, j, m+1, r);
    }
    
    private void updateTree(segementTreeNode root, int pos, int diff, int l, int r){
        if (l > pos || r < pos){
            return;
        }
        root.val += diff;
        if (l == r){ return; }
        int mid = l + (r - l)/2;
        updateTree(root.left, pos, diff, l, mid);
        updateTree(root.right, pos, diff, mid+1, r);
    }
    
    private segementTreeNode buildTree(int[] nums, int l, int r){
        if (l == r){
            segementTreeNode node = new segementTreeNode(nums[l]);
            return node;
        }   
        segementTreeNode node = new segementTreeNode(0);
        int m = l + (r - l) / 2;
        node.left = buildTree(nums, l, m);
        node.right = buildTree(nums, m+1, r);
        node.val = node.left.val+node.right.val;
        return node;
    }
    
    private class segementTreeNode{
         int val;
         segementTreeNode left;
         segementTreeNode right;
        public segementTreeNode(int sum){
            this.val = sum;
        }
    }
}