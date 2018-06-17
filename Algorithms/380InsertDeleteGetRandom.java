class RandomizedSet {

    /** Initialize your data structure here. */
    Map<Integer, Integer> map;
    List<Integer> nums;
    java.util.Random rand;
    public RandomizedSet() {
        map = new HashMap<>();
        nums = new ArrayList<>();
        rand = new java.util.Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }
        
        int pos = map.get(val);
        if(pos < nums.size() - 1){
            int last = nums.get(nums.size() - 1);
            nums.set(pos, last);
            map.put(last, pos);
        }
        nums.remove(nums.size() - 1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}