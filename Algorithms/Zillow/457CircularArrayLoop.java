/**
 key idea is:
 use slow and fast pointer to detect the circle.
 
 The question requires the circle is only forward circle or backward circle.
 so all the number in the circle must be positive or all must be negative.
 if two numbers are in different direction, the product of them will be negative number.
 
 if there is no circle, the nums[slow] * nums[fast] <= 0 which are in different direction, or meet one number which is confirmed that has no circle.
 
 if we confirm the path has no circle, we set the numbers in the path to 0.
 
 TIME: O(n)  
 Space: O(1).
*/

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if(nums == null || nums.length < 2){
            return false;
        }
        
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){continue; }
            int slow = i;
            int fast = getNext(nums, i);
            while (nums[slow] * nums[fast] > 0){  // 双指针保持一个方向
                if (slow == fast){
                    if (slow == getNext(nums, slow)){ // 如果只含有一个element.
                        break;
                    }
                    return true;
                }
                slow = getNext(nums, slow);
                fast = getNext(nums, getNext(nums, fast));
            }
            
            slow = i;
            int start = nums[i];
            while (start * nums[slow] > 0){  // 设置path上的num to 0.
                int old = slow;
                 slow = getNext(nums, slow);
                nums[old] = 0;
            }
        }
        return false;
    }
    
    private int getNext(int[] nums, int i){
        i += nums[i];
        if (i < 0){ return i % nums.length + nums.length; }
        return i %= nums.length;
    }
}