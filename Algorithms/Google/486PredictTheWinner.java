class Solution {
    
    
    /*
    As we observed. if we know the score[x + 1 , y], and score[x, y -1 ]. 
    we can easily get the result for the score[x, y] where 
    score[x, y] = max(nums[x] - score[x + 1,y], nums[y]- score[x, y - 1]);
    Thus, we can use dynamic method to solve this problem.
    transaction formula: score[x, y] = max(nums[x] - score[x + 1,y], nums[y]- score[x, y - 1]).
    result : score[0, n - 1];
    */
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] score = new int[n][n];
        for (int s = n - 1; s >= 0; s--){
            for (int e = s; e < n; e++){
                if (s == e){
                    score[s][e] = nums[s];
                } else {
                    score[s][e] = Math.max(nums[s] - score[s+1][e], nums[e] - score[s][e - 1]);
                }
            }
        }
        return score[0][n - 1] >= 0;
    }
    
    
    
    
    
    /*
    Recursive by Memo:
    
    For each player, he has two options:  pick either start or end of the array nums[x ~ y].
    And after the picking, give the turn to player2.
    after player2 obtain the its maximum score in the remain range, for player1, 
    he can get the score by nums[x] - score[x+1, y] where score[x+1, y] represents the maximum score
    between the range [x+1, y];
    or player1 can get score by nums[y] - score[x, y - 1].
    
    player1 will pick the larger one.
    
    We can use memory to record the compute result. for example we have compute the score[x, y]. 
    we can store it and reuse it when next approaching.

    O(n^2), O(n^2);
    */
    public boolean PredictTheWinner2(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
        return check(nums, 0, nums.length - 1, memo) >= 0;
    }
    
    private int check(int[] nums, int s, int e, Integer[][] memo){
        if (s == e){
            return nums[s];
        }
        
        if (memo[s][e] != null){
            return memo[s][e];
        }
        int pickstart = nums[s] - check(nums, s+1, e, memo);
        int pickend = nums[e] - check(nums, s, e-1, memo);
        memo[s][e] = Math.max(pickstart, pickend);
        return  memo[s][e];
    }
}