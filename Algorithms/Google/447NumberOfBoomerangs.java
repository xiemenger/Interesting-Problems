class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++){
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++){
                if (i == j){continue;}
                int d = getDist(points[j], points[i]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
        
            for (int count: map.values()){
                res += count * (count - 1);
            }
        }
        return res;
    }
    
    private int getDist(int[] a, int[] b){
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return (x * x) + (y * y);
    }
}