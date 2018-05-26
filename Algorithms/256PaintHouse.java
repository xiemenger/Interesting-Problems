class Solution {
    public int minCost(int[][] costs) {
        if(costs==null||costs.length==0){
            return 0;
        }
        int m = costs.length;
        int[] paintCost = new int[3];
        int[] preCost = new int[3];
        for (int j = 0; j < 3; j++){
            preCost[j] = costs[0][j];
        }
        
        for (int i = 1; i < m; i++){
            paintCost[0] = Math.min(preCost[1], preCost[2]) + costs[i][0];
            paintCost[1] = Math.min(preCost[0], preCost[2]) + costs[i][1];
            paintCost[2] = Math.min(preCost[0], preCost[1]) + costs[i][2];
            preCost = paintCost;
            paintCost = new int[3];
        }
        
        return Math.min(Math.min(preCost[0], preCost[1]), preCost[2]);
    }
}