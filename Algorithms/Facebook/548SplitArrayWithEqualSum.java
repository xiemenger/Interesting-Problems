/**
    i's range :  1 <= i <= n - 6
    j's range :  3 <= j <= n - 4
    k's range :  5 <= k <= n - 2
    i, j, k 把array分成四个sum: sum1, sum2, sum3, sum4
    思想:
    对于每个mid j来说, 先计算好左边 sum1 = sum2的情况, 把相等的值存入set里.
    然后再遍历右边找k, 看是否有sum3 == sum4 && set有sum3的情况.
*/

class Solution {
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++){
            sum[i] = sum[i - 1] + nums[i];
        }
        
        for (int j = 3; j <= n - 4; j++){
            HashSet<Integer> leftEqualSum = new HashSet<>();
            for (int i = 1; i < j - 1; i++){   // compute left equal sums.
                if (sum[i - 1] == sum[j - 1] - sum[i]){
                    leftEqualSum.add(sum[i - 1]);
                }
            }
            for (int k = j + 2; k <= n - 2; k++){  // find if right and left have equal sums.
                if (sum[k - 1] - sum[j] == sum[n - 1] - sum[k] 
                    && leftEqualSum.contains(sum[n - 1] - sum[k])){
                    return true;
                }
            }
        }
        return false;
    }
}