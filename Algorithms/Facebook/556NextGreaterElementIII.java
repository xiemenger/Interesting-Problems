class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        int[] pos = new int[10];
        for (int i = 0; i < nums.length; i++){
            pos[nums[i] - '0'] = i;
        }
        
        for (int curPos = nums.length - 1; curPos >= 0; curPos--){
            int curNum = nums[curPos] - '0';
            for (int candNum = curNum + 1; candNum <= 9; candNum++){
                if (pos[candNum] > curPos){
                    swap(nums, curPos, pos[candNum]);
                    reverse(nums, curPos + 1, nums.length - 1);
                    long res = Long.valueOf(new String(nums));
                    if (res > Integer.MAX_VALUE){
                        return -1;
                    }
                    return (int)res;
                }
            }
        }
        return -1;
    }
    
    private void reverse(char[] nums, int s, int e){
        while (s < e){
            char tmp = nums[s];
            nums[s] = nums[e];
            nums[e] = tmp;
            s++;
            e--;
        }
    }
    
    private void swap(char[] nums, int pos1, int pos2){
        char tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
        
    }
}