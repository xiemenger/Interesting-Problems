class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tankGasValue = 0;
        for (int i = 0; i < gas.length; i++){
            // start point
            // case that gas is not enought to next station
            if (gas[i] < cost[i]){
                continue;
            }
            
            // case that gas is enought to next station
            if (checkCircle(gas, cost, i, tankGasValue)){
                return i;
            }
        }
        return -1;
    }
    
    // Check Circle case:
    public boolean checkCircle(int[] gas, int[] cost, int i, int tankGasValue){
        int n = gas.length;
        for (int k = 0; k < n; k++){
            int idx = (k + i) % n; 
            if (gas[idx] + tankGasValue >= cost[idx]){
                tankGasValue = tankGasValue + gas[idx] - cost[idx];
            } else {
                return false;
            }
        }
        return true;
    }
}