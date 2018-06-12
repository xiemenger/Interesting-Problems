class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> tmp = new HashSet<>();
        
        for (int num : nums1){
            set1.add(num);
        }
        
        for (int num : nums2){
            if (set1.contains(num)){
                tmp.add(num);
            }
        }
        int[] r = new int[tmp.size()];
        int i = 0;
        for (int n : tmp){
            r[i++] = n;
        }
        return r;
    }
}