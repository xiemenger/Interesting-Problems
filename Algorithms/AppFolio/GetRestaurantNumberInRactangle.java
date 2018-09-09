
/**
 一个长方形，给了左上角和右下角的坐标. 1point3acres
给了一个API，可以返回在这个长方形区域内的最多50个饭店信息
get_restaurants(sw_x, sw_y, ne_x, ne_y).

实现get_all_restaurants(sw_x, sw_y, ne_x, ne_y)，返回在这个长方形区域内的所有饭店.
follow up:
1. get_all这个函数会被call很多次，如果中间crash了，需要存哪些信息来恢复
2. 如何speed up

 
 */

class Solution{
    public int get_all_restaurants(int sw_x, int sw_y, int ne_x, int ne_y){
        int cnt = get_restaurants(sw_x, sw_y, ne_x, ne_y);
        if (cnt < 50){
            return cnt;
        }

        int midx = (sw_x + ne_x) / 2;
        int midy = (sw_x + ne_y) / 2;

        cnt = get_restaurants(sw_x, sw_y, midx, midy); 
        cnt += get_restaurants(midx, sw_y, ne_x, midy);
        cnt += get_restaurants(sw_x, midy, midx, ne_y);
        cnt += get_restaurants(midx, midy, ne_x, ne_y);
        return cnt;
    }

    private int get_all_restaurants2(int sw_x, int sw_y, int ne_x, int ne_y){
        Stack<int[]> rects = new Stack<>();
        rects.push(new int[]{sw_x, sw_y, ne_x, ne_y});

        int cnt = 0;
        while (!rects.isEmpty()){
            int[] rect = rects.poll();
            int tmp = get_restaurants(rect[0], rect[1], rect[2], rect[3]);
            if (tmp < 50){
                cnt += tmp;
            } else {
                int midx = (sw_x + ne_x) / 2;
                int midy = (sw_x + ne_y) / 2;
                stack.push(new int[]{sw_x, sw_y,midx, midy});
                stack.push(new int[]{midx, sw_y, ne_x, midy});
                stack.push(new int[]{sw_x, midy, midx, ne_y});
                stack.push(new int[]{midx, midy, sw_x, sw_y});
            }
        }
        return cnt;
    }

}


