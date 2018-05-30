class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0){
            return 0;
        }
        int minIdx1 = -1;
        int minIdx2 = -1;
        
        for (int i = 0; i < costs.length; i++){
            int last1 = minIdx1; 
            int last2 = minIdx2;
            minIdx1 = -1;
            minIdx2 = -1;
            for (int j = 0; j < costs[0].length; j++){
                if (last1 != j){
                    costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                } else {
                    costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }
                
                if (minIdx1 < 0 || costs[i][j] < costs[i][minIdx1]){
                    minIdx2 = minIdx1;
                    minIdx1 = j;
                } else if (minIdx2 < 0 || costs[i][j] < costs[i][minIdx2]){
                    minIdx2= j;
                }
                
            }
        }
        return costs[costs.length - 1][minIdx1];
    }
}