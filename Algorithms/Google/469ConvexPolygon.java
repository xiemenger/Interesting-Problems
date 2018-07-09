class Solution {
    public boolean isConvex(List<List<Integer>> points) {
        boolean pos = false;
        boolean neg = false;
        int n = points.size();
        for (int p1 = 0; p1 < n; p1++){
            int p2 = (p1 + 1) % n;
            int p3 = (p2 + 1) % n;
            
            int direct = ccw(points.get(p1).get(0), points.get(p1).get(1), 
                            points.get(p2).get(0), points.get(p2).get(1),
                            points.get(p3).get(0), points.get(p3).get(1));
            
            if (direct > 0){pos = true; }
            else if (direct < 0){neg = true; }
            
            if (pos && neg){
                return false;
            }
        }
       return true;
    }
    
    private int ccw(int p1x, int p1y, int p2x, int p2y, int p3x, int p3y){
        return (p2x - p1x) * (p3y - p1y) - (p2y - p1y) *(p3x - p1x);
        
    }
    
}