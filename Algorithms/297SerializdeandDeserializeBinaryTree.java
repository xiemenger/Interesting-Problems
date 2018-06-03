public class Codec {

    // Encodes a tree to a single string.
    private String spliter = ",";
    private String NN = "X";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        //System.out.println(sb);
        return sb.toString();
    }
    
    public void buildString(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append(NN).append(spliter);
            return;
        } 
        
        sb.append(root.val).append(spliter);
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }
    
    public TreeNode buildTree(Queue<String> nodes){
        String val = nodes.poll();
        if (val.equals(NN)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }
}