/**
 * Time: O(nlogn).
 * Space: O(n)
 * 类似BFS+PriorityQueue
 */

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> neibs = new HashMap<>();  //station -> (next -> price);
        for (int[] f : flights){
            if (!neibs.containsKey(f[0])){
                neibs.put(f[0], new HashMap<>());
            }
            neibs.get(f[0]).put(f[1], f[2]);
        }
        
        PriorityQueue<int[]> costs = new PriorityQueue<>((a, b) -> (a[0] - b[0]));  
        costs.offer(new int[]{0, src, K+1}); // {cost, station, stops}
        while (!costs.isEmpty()){
            int[] cur = costs.poll();
            int curCost = cur[0];
            int curPos = cur[1];
            int curStop = cur[2];
            
            if (curPos == dst){
                return curCost;
            }
            
            if (curStop > 0 && neibs.containsKey(curPos)){j
                Map<Integer, Integer> neib = neibs.get(curPos);
                for (int next : neib.keySet()){
                    costs.offer(new int[]{curCost+neib.get(next), next, curStop - 1});
                }
            }
        }
        return -1;
    }
}