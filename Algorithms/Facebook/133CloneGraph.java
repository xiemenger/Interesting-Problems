public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return clone(node, map);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map){
        if (node == null){
            return null;
        }
        if (map.containsKey(node.label)){
            return map.get(node.label);
        }
        
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node.label, copy);
        for (UndirectedGraphNode neib : node.neighbors){
            copy.neighbors.add(clone(neib, map));
        }
        return copy;
    }
}