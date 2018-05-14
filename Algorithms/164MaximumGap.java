class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int gap = 0;
        int size = 0;
        int maxGap = Integer.MIN_VALUE;

        for (int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (max == min){ return 0; }
        
        gap =(max - min ) % (n - 1) == 0 ? 
              ((max - min ) / (n - 1)) : ((max - min ) / (n - 1) + 1);
        // inase gap is 0;
        gap = Math.max(1, gap);
        size = (max - min) / gap + 1;
        int[] bucketMin = new int[size];
        int[] bucketMax = new int[size];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        
        for (int num : nums){
            int idx = (num - min) / gap;
            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
        }
        
        int pre = min;
        for (int i = 0; i < size; i++){
            // empty bucket    
            if (bucketMin[i] != Integer.MAX_VALUE){
                maxGap = Math.max(maxGap, bucketMin[i] - pre);
                pre = bucketMax[i];
            }
        }
        
        return maxGap;
    }
}