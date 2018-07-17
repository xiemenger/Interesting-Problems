class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] nums = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '0'){
                    nums[j] = 0;
                } else {
                    nums[j] += 1;
                }
            }
            max = Math.max(max, getMaxArea(nums));
        }
        return max;
    }
    
    private int getMaxArea(int[] nums){
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int n = nums.length;
        for (int i = 0; i < n; i++){
            while (stack.peek() != -1 && nums[i] < nums[stack.peek()]){
                maxArea = Math.max(maxArea, nums[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        
        while (stack.peek() != -1){
            maxArea = Math.max(maxArea, nums[stack.pop()] * (n - stack.peek() - 1));
        }
        return maxArea;
    }
}