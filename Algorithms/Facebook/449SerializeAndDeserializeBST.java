public class Codec {

    // Encodes a tree to a single string.
    String splitter = ",";
    String NULL = "N";
    
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serial(root, res);
        System.out.println(res.toString());
        return res.toString();
    }
    
    private void serial(TreeNode root, StringBuilder res){
        if (root == null){
            res.append(NULL).append(splitter);
            return;
        }
        res.append(root.val).append(splitter);
        serial(root.left, res);
        serial(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(splitter);
        Queue<String> nodes = new LinkedList<>(Arrays.asList(strs));
        return deserial(nodes);
    }
    
    private TreeNode deserial(Queue<String> nodes){
        String cur = nodes.poll();
        if (cur.equals(NULL)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(cur));
        node.left = deserial(nodes);
        node.right = deserial(nodes);
        return node;
    }
}