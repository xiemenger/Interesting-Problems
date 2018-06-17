class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length ==0 || k == 0){
            return res;
        }
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]+a[1]-b[0]-b[1];
            }
        });
        
        for (int i = 0; i < k && i < nums1.length; i++){
            q.offer(new int[]{nums1[i], nums2[0], 0});
        }
        
        while (k-- > 0 && !q.isEmpty()){
            int[] cur = q.poll();
            res.add(new int[]{cur[0], cur[1]});
            if (cur[2] < nums2.length - 1){
                q.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
            }
        }
        
        return res;
    }
}