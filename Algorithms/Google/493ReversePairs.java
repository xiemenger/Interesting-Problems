class Solution {
    public int reversePairs(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int res = 0;
        int[] count = new int[nums.length + 1];
        for (int num : nums){
            res += getSum(count, index(copy, 2L * num + 1));
            insert(count, index(copy, num), 1);
        }
        return res;
    }
    
    private int index(int[] copy, long num){
        int l = 0;
        int r = copy.length - 1;
        int mid = 0;
        while (l <= r){
            mid = l + ((r - l) >> 1);
            if (num <= copy[mid]){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l + 1;
    }
    
    private void insert(int[] sum, int idx, int val){
        for (int i = idx; i > 0; i -= i & (-i)){
            sum[i] += val;
        }
    }
    
    private int getSum(int[] sum, int idx){
        int res= 0;
        while (idx < sum.length){
            res += sum[idx];
            idx += idx & (-idx);
        }
        return res;
    }
}