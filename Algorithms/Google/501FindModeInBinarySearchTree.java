class Solution {
    private int curCount;
    private int curVal;
    private int maxCount;
    private List<Integer> maxVals;
    
    public int[] findMode(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        curCount = 0;
        curVal = root.val;
        maxCount = 0;
        maxVals = new ArrayList<>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            handleValue(node);
            node = node.right;
        }
        
        int[] res = new int[maxVals.size()];
        int i = 0;
        for (int num : maxVals){
            res[i++] = num;
        }
        return res;   
    }
    
    private void handleValue(TreeNode root){
        if (root.val != curVal){
            curVal = root.val;
            curCount = 0;
        }
        
        curCount++;
        if (curCount > maxCount){
            maxCount = curCount;
            maxVals = new ArrayList<>();
            maxVals.add(root.val);
        } else if (curCount == maxCount){
            maxVals.add(root.val);
        }
    }
        
        
//     private int curCount;
//     private int curVal;
//     private int maxCount;
//     private List<Integer> maxVals;
    
//     public int[] findMode(TreeNode root) {
//         if (root == null){
//             return new int[0];
//         }
//         curCount = 0;
//         curVal = root.val;
//         maxCount = 0;
//         maxVals = new ArrayList<>();
        
//         inorder(root);
//         int[] res = new int[maxVals.size()];
//         int i = 0;
//         for (int num : maxVals){
//             res[i++] = num;
//         }
//         return res;
//     }
    
//     private void handleValue(TreeNode root){
//         if (root.val != curVal){
//             curVal = root.val;
//             curCount = 0;
//         }
        
//         curCount++;
//         if (curCount > maxCount){
//             maxCount = curCount;
//             maxVals = new ArrayList<>();
//             maxVals.add(root.val);
//         } else if (curCount == maxCount){
//             maxVals.add(root.val);
//         }
//     }
    
//     private void inorder(TreeNode root){
//         if (root == null){
//             return;
//         }
        
//         inorder(root.left);
//         handleValue(root);
//         inorder(root.right);
//     }
}