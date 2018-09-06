/**
 key idea is:
 from station A, if A cannot reach station B. the stations between A and B cannot reach B too.
 Proof:  
    Condition, B is the first station A cannot reach. 
    
    Suppose stations: A .. C ... B.   There is a station in C.
    A can reach C. but A cannot reach B.
    TankGas(A,C) > 0, TankGas(A,B) < 0, 
    TankGas(A,C) + TankGas(C,B) = TankGas(A, B);
    TankGas(C,B) = TankGas(A, B) - TankGas(A,C);
                 = negative - positive = negative ( < 0).
    Thus we know we cannot reach B from C.
    

 Once we have the idea above, we scan the gas and cost array.
 When the tankGas < 0 at station i, that mean from [start] station, it cannot reach to station i.
 so our next condidate start station will be i+1;
 
 
 Time: O(n).
 Spaece: O(1).
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int tankGas = 0;
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < gas.length; i++){
           if (tankGas + gas[i] < cost[i]){
               start = i + 1;
               tankGas = 0;
           } else {
               tankGas += gas[i] - cost[i];
           }
            gasSum += gas[i];
            costSum += cost[i];
        }
        
        return gasSum < costSum ? -1 : start;
    }
}