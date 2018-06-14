class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] res = new int[n];
        int l = 0;
        int r = n - 1;
        int idx = a >= 0 ? n - 1 : 0;
        while (l <= r){
            if (a >= 0){
                res[idx--] = func(a,b,c,nums[l]) > func(a,b,c,nums[r]) ? func(a,b,c,nums[l++]) : func(a,b,c,nums[r--]);
            } else {
                res[idx++] = func(a,b,c,nums[l]) < func(a,b,c,nums[r]) ? func(a,b,c,nums[l++]) : func(a,b,c,nums[r--]);
            }
        } 
        return res;
    }
    
    public int func(int a, int b, int c, int x){
        return a * x * x + b * x + c;
    }
}