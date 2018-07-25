class TwoSum {

    /** Initialize your data structure here. */
    Map<Integer, Integer> nums;
    public TwoSum() {
        nums = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        nums.put(number, nums.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int num1 : nums.keySet()){
            int num2 = value - num1;
            if (nums.containsKey(num2)){
                if (num1 != num2 || nums.get(num1) >= 2){
                    return true;
                }
            }
        }
        return false;
    }
}