class Solution {
    public int minArea(char[][] image, int x, int y) {
        int[] bound = new int[4];
        bound[0] = Integer.MAX_VALUE;
        bound[1] = Integer.MAX_VALUE;
        bound[2] = Integer.MIN_VALUE;
        bound[3] = Integer.MIN_VALUE;
        dfs(image, x, y, bound);
        System.out.println(bound[0]+"  "+bound[1]+"  "+bound[2]+"  "+bound[3]);
        return (bound[2] - bound[0] + 1) * (bound[3] - bound[1] + 1);
    }
    public void dfs(char[][] image, int x, int y,int[] bound){
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != '1'){
            return;
        }
        image[x][y] = '#';
        bound[0] = Math.min(bound[0], x);
        bound[1] = Math.min(bound[1], y);
        bound[2] = Math.max(bound[2], x);
        bound[3] = Math.max(bound[3], y);
//         System.out.println(" --- "+image[x][y]+" ----- ");
//         System.out.println(bound[0]+"  "+bound[1]+"  "+bound[2]+"  "+bound[3]);
        
        dfs(image, x - 1, y, bound);
        dfs(image, x, y - 1, bound);
        dfs(image, x + 1, y, bound);
        dfs(image, x, y + 1, bound);
    }
}