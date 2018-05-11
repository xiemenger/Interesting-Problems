/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
        // Time: O(n^2), Space: O(1)
        public int maxPoints(Point[] points) {
        	if (points == null){ return 0; }
            if (points.length <= 2){
                return points.length;
            }
            
            int res = 0;
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            int overlap = 0;
            int max = 0;
            for (int i = 0; i < points.length; i++){
                map.clear();
                max = 0;
                overlap = 0;
                for (int j = i + 1; j < points.length; j++){
                    int x = points[i].x - points[j].x;
                    int y = points[i].y - points[j].y;
                    if (x == 0 && y == 0){
                        overlap++;
                        continue;
                    }
                    int gcd = generateGCD(x, y);
                    if (gcd != 0){
                        x = x / gcd;
                        y = y / gcd;
                    }
                    
                    if (map.containsKey(x)){
                        if (map.get(x).containsKey(y)){
                            map.get(x).put(y,map.get(x).get(y) + 1);  
                        } else {
                            map.get(x).put(y, 1);
                        }
                    } else {
                        Map<Integer, Integer> m = new HashMap<>();
                        m.put(y, 1);
                        map.put(x, m);
                    }
                    max = Math.max(max, map.get(x).get(y));
                }
                res = Math.max(res, max + overlap + 1);
            }
        	return res;
        	
        }
        private int generateGCD(int a,int b){
        	if (b==0) return a;
        	else return generateGCD(b,a%b);
        	
        }
}