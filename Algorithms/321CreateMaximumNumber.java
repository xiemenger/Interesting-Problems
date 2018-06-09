class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int l1 = nums1.length;
        int l2 = nums2.length;
        for (int k1 = 0; k1 <= k; k1++){
            int k2 = k - k1;
            if (k1 > l1 || k2 > l2){ continue; }
            
            int[] candiate = merge(findMaxNum(nums1, k1), findMaxNum(nums2, k2), k);
            res = greater(candiate, 0, res, 0)? candiate : res;
        }
        return res;
        
    }
    public int[] merge(int[] nums1, int[] nums2, int k){
        int[] res = new int[k];
        int i = 0;
        int j = 0;
        for (int r = 0; r < k; r++){
            res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }
    
    public boolean greater(int[] num1, int i, int[] num2, int j){
        while (i < num1.length && j < num2.length && num1[i] == num2[j]){
            i++;
            j++;
        }
        return j == num2.length || (i < num1.length && num1[i] > num2[j]);
    }
    
    public int[] findMaxNum(int[] num, int k){
        Stack<Integer> stack = new Stack<>();
        int n = num.length;
        for (int i = 0; i < n; i++){
            while (!stack.empty() && n-i+stack.size() > k && stack.peek() < num[i]){
                stack.pop();
            }
            if (stack.size() < k){
                stack.push(num[i]);
            }
        }
        
        int[] res = new int[k];
        for (int i = k - 1; i >=0 ; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}