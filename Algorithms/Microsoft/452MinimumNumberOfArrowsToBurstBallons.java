class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> (a[1] - b[1]) );
        int count = 0;
        long end = Long.MIN_VALUE;
        for (int[] p : points){
            if (p[0] > end){
                count++;
                end = p[1];
            }
        }
        return count;
    }
}