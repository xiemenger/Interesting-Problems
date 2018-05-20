class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        int n = nums.length;
        
        for (int i = 0; i < k; i++){
            queue.add(nums[i]);
        }
        
        for (int i = k; i < n; i++){
            if (nums[i] > queue.peek()){
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }
}