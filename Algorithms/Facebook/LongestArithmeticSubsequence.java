/**
 * len[i][j] // means,  ith and jth num's distance as distance's LAS length,
 {1, 5, 6, 9, 12, 13}
 
       0  1   2   3   4   5
  -------------------------
i 0       2   2   2   2   2
  -------------------------
  1           2   3   2   2
  -------------------------
  2               2   2   2
  -------------------------
  3                   2   4
  -------------------------
  4                      2
  -------------------------
  5                     
  -------------------------

  i 必须小于 j, 对于任何i < j的以(nums[i] - nums[j]) 为距离的 并且 以nums[i], nums[j]
  为结束的sebsequene的长度起始值都是2, 因为当只有两个数, 那么长度必然为2.
  起始值为上图.
  我们开始中间指针j从(1 ~ n - 2) 扫, 左指针i = j - 1, 右指针k = j + 1. 
  1)当nums[i] + nums[k] == 2 * nums[j]; 
       左右两遍的值     ==  中间值的两倍,    说明构成等差数列.   
  说明以nums[i],nums[j]的长度可以增加1,  
  当然subsequence的结束数组就是nums[j],nums[k]
  那么len[j][k] = len[i][j] + 1;  i--; k++;

 2) 当nums[i] + nums[k] < 2 * nums[j];
  说明nums[k]太小, k++;
  
 3)当nums[i] + nums[k] > 2 * nums[j];
  说明nums[i] 太大, i--;
 * 
 */
class Solution{
    public int getLAS(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[][] len = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i < j ){
                    len[i][j] = 2;
                }
            }
        }
        int maxLen = 0;
        for (j = 1; j < n - 1; j++){
            int i = j - 1;
            int k = j + 1;
            while (i >=0 && k < n){
                if (nums[i] + nums[k] == 2 * nums[j]){
                    len[j][k] = len[i][j] + 1;
                    maxLen = Math.max(maxLen, len[j][k]);
                    i--; k++;
                } else if (nums[i] + nums[k] < 2 * nums[j]){
                    k++;
                } else {
                    i--;
                }
            }
        }
        return maxLen;
    }
}