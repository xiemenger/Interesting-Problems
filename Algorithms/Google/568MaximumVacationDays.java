class Solution {
    // Dynamic method
    public int maxVacationDays(int[][] flights, int[][] days) {
        int cityNum = flights.length;
        int weekNum = days[0].length;
        int[] dp = new int[cityNum];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        int max = 0;
        
        for (int i = 0; i < weekNum; i++){
            int[] tmp = new int[cityNum];
            Arrays.fill(tmp, Integer.MIN_VALUE);
            for (int curCity = 0; curCity < cityNum; curCity++){
                for (int preCity = 0; preCity < cityNum; preCity++){
                    if (preCity == curCity || flights[preCity][curCity] == 1 ){
                        //System.out.println("days:"+days[curCity][i]);
                        tmp[curCity] = Math.max(tmp[curCity], dp[preCity] + days[curCity][i]);
                    }
                }
            }
            dp = tmp;
        }
        for (int vac : dp){
            max = Math.max(max, vac);
        }
        return max;
    }
    
    // DFS with memory
    public int maxVacationDays2(int[][] flights, int[][] days) {
        int cityNum = flights.length;
        int weekNum = days[0].length;
        int[][] memo = new int[cityNum][weekNum];
        for (int i = 0; i < memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return dfs(flights, days, 0, 0, memo);
    }
    
    private int dfs(int[][] flights, int[][] days, int week, int cityA, int[][] memo){
        if (week == days[0].length){
            return 0;
        }
        if (memo[cityA][week] != -1){
            return memo[cityA][week];
        }
        
        int maxvac = 0;
        for (int cityB = 0; cityB < flights.length; cityB++){
            if (flights[cityA][cityB] == 1 || cityA == cityB){
                int vac = days[cityB][week] + dfs(flights, days, week+1, cityB, memo);
                maxvac = Math.max(vac, maxvac);
            }
        }
        memo[cityA][week] = maxvac;
        return maxvac;
    }
}