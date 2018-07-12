class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++){
            int idx = i % n;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[idx]){
                res[stack.pop()] = nums[idx];
            }
            stack.push(idx);
        }
        return res;
    }
}