/**
  Fish-Yates Algorithm.
  Time: O(n)
  Space: O(1).
*/

class Solution {
    int[] original;
    int[] input;
    Random rand;
    public Solution(int[] nums) {
        original = nums;
        rand = new Random();
        input = new int[nums.length];
        for (int i = 0; i < input.length; i++){
            input[i] = nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = input.length; i > 0; i--){
            int j = rand.nextInt(i);
            swap(input, i-1, j);
        }
        return input;
    }
    
    private void swap(int[] input, int i, int j){
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}