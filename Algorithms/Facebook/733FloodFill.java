class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || sr < 0 || sc < 0 || 
            sr >= image.length || sc >= image[0].length || newColor == image[sr][sc]){
            return image;
        }
        color(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    private void color(int[][] image, int i, int j, int newColor, int oldColor){
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length 
            || image[i][j] != oldColor){
            return;
        }
        image[i][j] = newColor;
        color(image, i + 1, j, newColor, oldColor);
        color(image, i - 1, j, newColor, oldColor);
        color(image, i, j + 1, newColor, oldColor);
        color(image, i, j - 1, newColor, oldColor);
    }
}