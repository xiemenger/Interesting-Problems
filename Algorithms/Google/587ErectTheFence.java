class Solution {
    public List<Point> outerTrees(Point[] points) {
        Set<Point> res = new HashSet<>();
        // find the leftmost point
        int l = 0;
        int n = points.length;
        for (int i = 1; i < n; i++){
            if (points[i].x < points[l].x){
                l = i;
            }
        }
        
        res.add(points[l]);
        List<Integer> collinearPoints = new ArrayList<>();
        
        int p = l;
        do {
            int q = (p + 1) % n;
            for (int i = 0; i < n; i++){
                int ccwVal = ccw(points[p], points[q], points[i]);
                if ( ccwVal < 0){
                    q = i;
                    collinearPoints = new ArrayList<>();
                }
            } 
            
            for (int i = 0; i < n; i++){
                if (i != p && i != q && ccw(points[p], points[q], points[i]) == 0 
                    && inBetween(points[p], points[i], points[q])){
                    res.add(points[i]);
                }
            }
            res.add(points[q]);
            p = q;
            
        } while (p != l);
        
        return new ArrayList<Point>(res);
    }
    
    public boolean inBetween(Point p, Point i, Point q) {
        boolean a = i.x >= p.x && i.x <= q.x || i.x <= p.x && i.x >= q.x;
        boolean b = i.y >= p.y && i.y <= q.y || i.y <= p.y && i.y >= q.y;
        return a && b;
    }
    
    private int ccw (Point p1, Point p2, Point p3){
        return (p2.x - p1.x)*(p3.y - p1.y) - (p2.y - p1.y)*(p3.x - p1.x);
    }
}