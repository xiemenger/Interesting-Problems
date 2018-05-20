class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> heightMap = new ArrayList<>();
        
        for(int[] b : buildings){
            heightMap.add(new int[]{b[0], -b[2]});
            heightMap.add(new int[]{b[1], b[2]});
        }
        
        Collections.sort(heightMap, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if (a[0] != b[0]){
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
           
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        
        queue.offer(0);
        int pre = 0;
        for (int[] point : heightMap){
            if (point[1] < 0){
                queue.offer(-point[1]);
            } else {
                queue.remove(point[1]);
            }
            
            int cur = queue.peek();
            if (cur != pre){
                res.add(new int[]{point[0], cur});
                pre = cur;
            }
        }
        
        return res;
    }
}