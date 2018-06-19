class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> set = new HashSet<>();
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        int areaSum = 0;
        for (int[] r : rectangles){
            x1 = Math.min(x1, r[0]);
            y1 = Math.min(y1, r[1]);
            x2 = Math.max(x2, r[2]);
            y2 = Math.max(y2, r[3]);
            areaSum += (r[2] - r[0]) * (r[3] - r[1]);
            
            String point1 = r[0]+","+r[1];
            String point2 = r[2]+","+r[3];
            String point3 = r[0]+","+r[3];
            String point4 = r[2]+","+r[1];
            if (!set.add(point1)){ set.remove(point1);}
            if (!set.add(point2)){ set.remove(point2);}
            if (!set.add(point3)){ set.remove(point3);}
            if (!set.add(point4)){ set.remove(point4);}
        }
        if (!set.contains(x1+","+y1) || !set.contains(x1+","+y2) || !set.contains(x2+","+y1) || !set.contains(x2+","+y2)){
            return false;
        }
        return set.size()  == 4 && areaSum == (x2 - x1) * (y2 - y1);
        
    }
}