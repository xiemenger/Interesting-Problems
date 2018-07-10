class Solution {
    public int[] findPermutation(String s) {
        int n = s.length() + 1;
        int[] nums = new int[n];
        int num = 1;
        for (int i = 0; i < n; i++){
            nums[i] = num++;
        }
        
        int idx = 0;

        while (idx < s.length()){
            int l = 0;
            int r = 0;
            if (s.charAt(idx) == 'I'){
                idx++;
            } else {
                l = idx;
                while (idx < s.length() && s.charAt(idx) == 'D'){
                    idx++;
                }
                r = idx;
            }
            
            reverse(nums, l, r);
        }
        return nums;
    }
    
    private void reverse(int[] nums, int s, int e){
        while (s < e){
            int tmp = nums[s];
            nums[s++] = nums[e];
            nums[e--] = tmp;
        }
    }
}