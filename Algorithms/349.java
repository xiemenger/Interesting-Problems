class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        
        for (int num : nums1){
            set1.add(num);
        }
        
        for (int num : nums2){
            if (set1.contains(num)){
                res.add(num);
            }
        }
        int[] r = new int[res.size()];
        int i = 0;
        for (int n : res){
            r[i++] = n;
        }
        return r;
    }
}