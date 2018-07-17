class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0){
            return 0;
        }
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();  // store index
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < n; i++){
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]){
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        
        while (stack.peek() != -1){
            maxArea = Math.max(maxArea, heights[stack.pop()] * (n - stack.peek() - 1));
        }
        
        return maxArea;
    }
}