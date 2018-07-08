/**
 * 1. Bit Operation
 * 2. Find the most significant bit , to see if there are 
 * pair prefix can be XOR to tmp(potential max).
 * if so, max = tmp. there means there are two numbers can 
 * XOR to the tmp so far.
 * But we dont stop here, we will continue to check the 
 * lower significant bit, until we reach the last bit pot;
 * if no, there means there is no two numbers can XOR to the 
 * tmp. we continue to search.
 */
class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        
        for (int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            HashSet<Integer> prefixes = new HashSet<>();
            for (int num : nums){
                prefixes.add(mask & num);
            }
            
            int tmp = max | (1 << i);
            for (int prefix : prefixes){
                if (prefixes.contains(prefix ^ tmp)){
                    max = tmp;
                }
            }
        }
        return max;
    }
}