
/**
 * 题目的意思是给一个int 数组,  每个数字的数值代表了这个数字的权重.比如
 * [1,2,4,5,1,3]  数字1代表了这个数字他的权重是1.  1/ totoal sum.
 * 解法:
 * 用一个新的数组把这个权重累加起来
 * [1,2, 4, 5, 1,3] ->
 * [1,3, 7,11,12,15]  sum array
 *  0 1  2 3  4   5
 * 然后我们知道所有的权重是多少 : 这个例子中是15.
 * 那么我们用random在[0 15)的范围随机产生一个值.
 * 比如产生了13, 那么我们用binary search在sum array里面找这么一个数的位置. 
 * 在用binary search的时候我们如果没有找到, 我们应该回复这个数插入到数组中的idx.
 * 回复Index 5. 
 * 如果要回复的是数的话, 就是nums[5].
 * 
 * 注意: 这里面的数值是有可能重复的, 顺序也可能乱的, 但是不影响解法
 * 
 */

class Solution{
    public int randomNumber(int[] weights){
        if (weights == null || weights.length == 0){return 0; }
        int n = weights.length;
        int[] sum = new int[n];
        sum[0] = weights[0];
        for (int i = 1; i < n; i++){
            sum[i] += sum[i - 1];
        }
        int allWeight = sum[n - 1];
        Random rand = new Random();
        int num = rand.nextInt(allWeight);
        int idx = binarysearch(sum, num);
        return weights[num];
    }

    private int binarysearch(int[] weights, int target){
        int l = 0;
        int r = weights.length - 1;
        while (l < r){
            int m = l + (r - l)/2;
            if (weights[m] >= target){
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}