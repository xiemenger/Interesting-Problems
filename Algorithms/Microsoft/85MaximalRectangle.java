class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int[] h = new int[matrix[0].length];
        int maxRect = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                h[j] = matrix[i][j] == '0' ? 0 : h[j] + 1;
            }
            maxRect = Math.max(maxRect, getMaxArea(h));
        }
        return maxRect;
    }
    
    private int getMaxArea(int[] nums){
        Stack<Integer> indices = new Stack<>();
        int maxArea = 0;
        indices.push(-1);
        int i = 0;
        for (; i < nums.length; i++){
            while (indices.peek() != -1 && nums[i] < nums[indices.peek()]){
                maxArea = Math.max(maxArea, nums[indices.pop()] * (i - indices.peek() - 1));
            }
            indices.push(i);
        }
        while(indices.peek() != -1){
            maxArea = Math.max(maxArea, nums[indices.pop()] * (i - indices.peek() - 1));
        }
        return maxArea;
    }
}