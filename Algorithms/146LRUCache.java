class LRUCache {
    Map<Integer, DLinkedNode> cache;
    int capacity;
    int count;
    DLinkedNode head;
    DLinkedNode tail;
    
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        this.count = 0;
        this.head = new DLinkedNode();
        head.pre = null;
        this.tail = new DLinkedNode();
        tail.post = null;
        
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DLinkedNode curNode = cache.get(key);
        if (curNode == null){
            return -1;
        } 
        this.moveToHead(curNode);
        return curNode.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null){
            node = new DLinkedNode();
            node.key = key;
            node.value = value;
            
            this.cache.put(key, node);
            this.addNode(node);
            
            count++;
            
            if (count > capacity){
                DLinkedNode removeTail = this.popTail();
                this.cache.remove(removeTail.key);
                count--;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
            
        }  
    }
    
    public void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }
    
    public void removeNode(DLinkedNode node){
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }
    
    public DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }
    
    public void addNode(DLinkedNode node){
        node.pre = head;
        node.post = head.post;
        
        head.post.pre = node;
        head.post = node;
    }
    

}

class DLinkedNode{
    int value;
    int key;
    DLinkedNode pre;
    DLinkedNode post;
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */