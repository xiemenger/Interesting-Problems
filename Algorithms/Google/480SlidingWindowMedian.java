class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int n = nums.length;
        double[] medians = new double[n - k + 1];
        for (int i = 0; i < k - 1; i++){
            addNum(left, right, nums[i]);
        }
        
        int idx = 0;
        for (int i = k - 1; i < nums.length; i++){
            addNum(left, right, nums[i]);
            if (left.size() == right.size()){
                medians[idx++] = ((long)left.peek() + right.peek()) / 2.0;
            } else {
                medians[idx++] = left.peek();
            }
            removeNum(left, right, nums[i - k + 1]);
        }
        return medians;
    }
    
    private void addNum(PriorityQueue<Integer> left, PriorityQueue<Integer> right, Integer val){
        if (left.size() <= right.size()){
            right.add(val);
            left.add(right.remove());
        } else {
            left.add(val);
            right.add(left.remove());
        }
    }
    
    private void removeNum(PriorityQueue<Integer> left, PriorityQueue<Integer> right, Integer val){
        if (val <= left.peek()){
            left.remove(val);
        } else {
            right.remove(val);
        }
    }
}