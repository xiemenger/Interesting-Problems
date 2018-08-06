/**
  这道题和Combination sum IV https://leetcode.com/problems/combination-sum-iv/description/  不同!!!!
  Combination sum的combination是分顺序的, 比如1, 2, 1 和 1,1,2是不同的.
  而我们这道题, 这两种情况是一样的.
  cnt[i][j] means the max number of different way to sum up to j by using first i coins , 
  cnt[i][j] = cnt[i - 1][j] // not using current coin, how many ways can sum up to j.
             + cnt[i][j - coin[i]] // use the current coin, how many ways can sum up to j - coin[i]
                                      since if we know the number of ways to sum up to j - coin[i], 
                                       we just need to add one coin, that means we can get 
                                       same number of ways to sum up to j.
  now, we can see the transform equation is :
  cnt[i][j] = cnt[i - 1][j] + cnt[i][j - coin[i]]
  since cnt[i][j] about i, only care about the previous line, i - 1; thus we can compress it to one line:
  cnt[j] += cnt[j - coint[i]];
*/
class Solution {
    public int change(int amount, int[] coins) {
        int[] cnt = new int[amount+1];
        cnt[0] = 1;
        for (int coin : coins){
            for (int target = coin; target <= amount; target++){
                cnt[target] += cnt[target - coin];
            }
        }
        return cnt[amount];
    }
}