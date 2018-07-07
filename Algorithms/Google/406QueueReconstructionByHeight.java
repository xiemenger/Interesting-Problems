class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]));
        List<int[]> res = new LinkedList<>();
        for (int[] p : people){
            res.add(p[1], p);
        }
        
        int[][] r = new int[people.length][2];
        int i = 0;
        for (int[] p : res){
            r[i++] = p;
        }
        return r;
    }
}