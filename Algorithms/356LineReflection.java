class Solution {
    public boolean isReflected(int[][] points) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        for (int[] p : points){
            min = Math.min(p[0], min);
            max = Math.max(p[0], max);
            set.add(p[0]+"a"+p[1]);
        }
        
        int dist = min + max;
        for (int[] p : points){
            String tmp = (dist - p[0])+"a"+p[1];
            if (!set.contains(tmp)){
                return false;
            }
        }
        return true;
    }
}