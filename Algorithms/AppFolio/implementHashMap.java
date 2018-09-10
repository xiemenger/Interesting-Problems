class MyHashMap {

    /** Initialize your data structure here. */
    Bucket[] buckets;
    public MyHashMap() {
        buckets = new Bucket[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = getIdx(key);
        if (buckets[idx] == null){
            buckets[idx] = new Bucket();
        }
        ListNode prev = findPrevNode(buckets[idx], key);
        if (prev.next == null){
            prev.next = new ListNode(key, value);
        } else {
            prev.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = getIdx(key);
        if (buckets[idx] == null){
            return -1;
        }
        ListNode prev = findPrevNode(buckets[idx], key);
        if (prev.next == null){ return -1; }
        return prev.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = getIdx(key);
        if (buckets[idx] == null){
            return;
        }
        ListNode prev = findPrevNode(buckets[idx], key);
        if (prev.next == null){ return; }
        prev.next = prev.next.next;
    }
    
    private int getIdx(int key){
        return Integer.hashCode(key) % buckets.length;
    }
    
    private ListNode findPrevNode(Bucket bucket, int key){
        ListNode cur = bucket.head;
        ListNode prev = null;
        while (cur != null && cur.key != key){
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
}

class Bucket{
    ListNode head = new ListNode(-1, -1);
}

class  ListNode{
    int key;
    int value;
    ListNode next;
    
    public ListNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */