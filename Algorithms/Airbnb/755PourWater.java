class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        if (heights == null || heights.length == 0 || V <= 0){
            return heights;
        }
        while (V > 0){
            int cand = K;
            for (int i = K - 1; i >= 0; i--){
                if (heights[i] > heights[cand]){
                    break;
                } else if (heights[i] < heights[cand]){
                    cand = i;
                }
            }
            if (cand != K){
                heights[cand]++;
                V--;
                continue;
            }
            for (int i = K + 1; i < heights.length; i++){
                if (heights[i] > heights[cand]){
                    break;
                } else if (heights[i] < heights[cand]){
                    cand = i;
                }
            }
            heights[cand]++;
            V--;
        }
        return heights;
    }
}