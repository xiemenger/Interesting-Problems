
/**
 * Two method:
 * 1)
 * Since there zeros number is 1, we can use q to store the
 * zero's index, the zero is which we counted.
 * 
 * for meetting 0, l = q + 1 (decrease number of zeros by 1)
 * max = Math.max(max, r - l + 1);
 * 
 *  2)
 * Mantain a window which cover k zeros (this method is suited for 
 * k zeros cases);
 * if the window has more than k zeros, 
 * move left pointer.
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int q = -1;
        int max = 0;
        for (int l = 0, r = 0; r < nums.length; r++){
            if (nums[r] == 0){
                l = q + 1;
                q = r;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
    
    public int findMaxConsecutiveOnes2(int[] nums) {
        int max = 0;
        int zeros = 0;
        int k = 1;
        for (int l = 0, r = 0; r < nums.length; r++){
            if (nums[r] == 0){
                zeros++;
            }
            while (zeros > k){
                if (nums[l++] == 0){
                    zeros--;
                }
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}