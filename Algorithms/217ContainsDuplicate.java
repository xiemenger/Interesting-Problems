class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seenNums = new HashSet<>();
        for (int num : nums){
            if (!seenNums.add(num)){
                return true;
            }
        }
        return false;
    }
}