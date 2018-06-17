    Queue<Integer> nums = new LinkedList<>();
    Set<Integer> set = new HashSet<>();
    public PhoneDirectory(int maxNumbers) {
        for (int i = 0; i < maxNumbers; i++){
            nums.add(i);
            set.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (nums.isEmpty()){
            return -1;
        }
        int res = nums.poll();
        set.remove(res);
        return res;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return set.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (set.add(number)){
            nums.offer(number);
        }
    }
}