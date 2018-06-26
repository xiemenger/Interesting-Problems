class Solution {
    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int[] buckets = new int[10];
        
        for (int i = 0; i < nums.length; i++){
            buckets[nums[i] - '0'] = i;
        }
        
        for (int i = 0; i < nums.length; i++){
            for (int j = 9; j > nums[i] - '0'; j--){
                if (buckets[j] > i){
                    char tmp = nums[i];
                    nums[i] = (char)(j + '0');
                    nums[buckets[j]] = tmp;
                    return Integer.valueOf(new String(nums));
                }
            }
        }
        return num;
    }
}