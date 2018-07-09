class LFUCache {
    Map<Integer, Integer> vals; // store (key, value);
    Map<Integer, Integer> count; // store (key, count);
    Map<Integer, LinkedHashSet<Integer>> countKeys; // store (count, the keys has the same count)
    int cap;
    int minCount;
    
    public LFUCache(int capacity) {
        this.cap = capacity;
        this.vals = new HashMap<>();
        this.count = new HashMap<>();
        countKeys = new HashMap<>();
        countKeys.put(1, new LinkedHashSet<>());
        minCount = 0;
    }
    
    public int get(int key) {
        if (!vals.containsKey(key)){
            return -1;
        }
        countIncrease(key);
        return vals.get(key);
    }
    
    public void put(int key, int value) {
        if (cap <= 0){
            return;
        }
        //System.out.println("add:"+key+" "+value);
        if (vals.containsKey(key)){
            vals.put(key, value);
            countIncrease(key); // put operation will increase the count of useage.
            return;
        }
        
        if (vals.size() >= cap){
            int evictKey = countKeys.get(minCount).iterator().next();
            vals.remove(evictKey);
            countKeys.get(minCount).remove(evictKey);
        }
        
        // if vals does not contains the (key, value) pair;
        vals.put(key, value);
        count.put(key, 1);
        countKeys.get(1).add(key);
        minCount = 1;
        

    }
    
    private void countIncrease(int key){
        int c = count.get(key);
        countKeys.get(c).remove(key);
        if (c == minCount && countKeys.get(c).size() == 0){
            minCount += 1;
        }
        count.put(key, c + 1);
        if (!countKeys.containsKey(c + 1)){
            countKeys.put(c + 1, new LinkedHashSet<>());
        }
        countKeys.get(c + 1).add(key);
        //System.out.println("update:"+key+" "+ (c + 1));
    }
}